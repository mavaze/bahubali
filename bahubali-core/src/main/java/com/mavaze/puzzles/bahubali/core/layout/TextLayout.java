package com.mavaze.puzzles.bahubali.core.layout;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class TextLayout implements Layout, Serializable {

	protected int x1, y1, x2, y2;
	
	protected char area[][];

	public TextLayout(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		area = new char[x2-x1+1][y2-y1+1];
	}

	@Override
	public int getX1() {
		return x1;
	}
	
	@Override
	public int getY1() {
		return y1;
	}

	@Override
	public int getX2() {
		return x2;
	}

	@Override
	public int getY2() {
		return y2;
	}
	
	public void clearLayout() {
		area = new char[x2-x1+1][y2-y1+1];
	}

	public char getCharacterAt(int x, int y) {
		if( x>=x1 && x<=x2 && y>=y1 && y<=y2) {
			return area[x-x1][y-y1];
		}
		return '\u0000';
	}
	
	public void setStringAt(int x, int y, String text) {
		for(int p=0; p < text.length(); p++) {
			area[p+x-x1][y-y1] = text.charAt(p);
		}
	}

}
