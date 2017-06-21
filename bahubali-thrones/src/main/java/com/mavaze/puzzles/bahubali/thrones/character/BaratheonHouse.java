package com.mavaze.puzzles.bahubali.thrones.character;

import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.character.Health;

public class BaratheonHouse implements GameCharacter {
	
	private static final long serialVersionUID = -111136483853985912L;

	@Override
	public String getMenuName() {
		return "House Baratheon";
	}

	@Override
	public boolean isAlive() {
		return true;
	}

	@Override
	public Health getHealth() {
		// TODO Auto-generated method stub
		return null;
	}

}
