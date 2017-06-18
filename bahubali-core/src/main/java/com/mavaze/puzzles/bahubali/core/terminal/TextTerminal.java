package com.mavaze.puzzles.bahubali.core.terminal;

import java.util.Scanner;

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
		
		for(int y = layout.getY1(); y < layout.getY2(); y++) {
			for(int x = layout.getX1(); x < layout.getX2(); x++) {
				System.out.print(layout.getCharacterAt(x, y));
			}
			System.out.println();
		}
		System.out.print("Please provide answer (" + GameContextHolder.getContext().getActiveAction() + ") : " );
		String answer = scanner.nextLine();
		System.out.println("You entered : " + answer);
		GameContextHolder.getContext().getActiveAction().postExecute(answer);
		
	}

}