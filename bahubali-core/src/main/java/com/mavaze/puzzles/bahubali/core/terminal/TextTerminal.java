package com.mavaze.puzzles.bahubali.core.terminal;

import java.util.Scanner;

import com.mavaze.puzzles.bahubali.core.character.Player;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.layout.TextLayout;

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
		Player player = GameContextHolder.getContext().getActivePlayer();
		if (player!=null && player.getMenuName()!=null) {
			playerName = player.getMenuName();
		}
		
		System.out.print("[" + playerName + "] # ");
		while(true) {
			try {
				String answer = scanner.nextLine();
				GameContextHolder.getContext().getActiveAction().postExecute(answer);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid option selected.");
			} catch (Exception e) {
				System.out.println("Error processing your input.");
			}
		}
	}

}