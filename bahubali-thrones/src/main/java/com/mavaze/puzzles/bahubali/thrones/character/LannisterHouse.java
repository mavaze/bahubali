package com.mavaze.puzzles.bahubali.thrones.character;

import java.util.Map;

import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.character.Health;

public class LannisterHouse implements GameCharacter {

	private static final long serialVersionUID = 5125377008411844823L;

	@Override
	public String getMenuName() {
		return "House Lannister";
	}

	@Override
	public Map<String, Object> getCharacteristics() {
		// TODO Auto-generated method stub
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
