package com.mavaze.puzzles.bahubali.thrones.character;

import java.util.Map;

import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.character.Health;

public class BaratheonHouse implements GameCharacter {
	
	private static final long serialVersionUID = -111136483853985912L;

	@Override
	public String getMenuName() {
		return "House Baratheon";
	}

	@Override
	public Map<String, Object> getCharacteristics() {
		return null;
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
