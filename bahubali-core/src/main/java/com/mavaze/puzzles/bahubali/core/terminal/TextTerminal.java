package com.mavaze.puzzles.bahubali.core.terminal;

import java.util.Scanner;

import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.layout.TextLayout;
import com.mavaze.puzzles.bahubali.core.player.Player;

public class TextTerminal implements Terminal {

	private TextLayout layout;

	private Scanner scanner = new Scanner(System.in);

	public TextTerminal(TextLayout layout) {
		this.layout = layout;
	}

	public void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println("\n");
		}
	}

	@Override
	public void draw() {

		clearScreen();

		for (int y = layout.getY1(); y < layout.getY2(); y++) {
			for (int x = layout.getX1(); x < layout.getX2(); x++) {
				System.out.print(layout.getCharacterAt(x, y));
			}
			System.out.println();
		}
		
		String playerName = "Guest";
		Player player = GameContextHolder.getContext().getPlayer();
		if (player!=null && player.getName()!=null) {
			playerName = player.getName();
		}
		
		System.out.print("[" + playerName + "] " + GameContextHolder.getContext().getActiveAction().getMenuName() + " # ");
		while(true) {
			try {
				String answer = scanner.nextLine();
				GameContextHolder.getContext().getActiveAction().postExecute(answer);
			} catch (Exception e) {
				System.out.println("Invalid input. Please re-enter your choice.");
			}
		}
	}

}