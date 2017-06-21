package com.mavaze.puzzles.bahubali.core.character;

import java.io.Serializable;

public class Resources implements Serializable {

	private static final long serialVersionUID = -9113408508663457764L;

	private int gold;
	
	private int elixir;

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getElixir() {
		return elixir;
	}

	public void setElixir(int elixir) {
		this.elixir = elixir;
	}
}
