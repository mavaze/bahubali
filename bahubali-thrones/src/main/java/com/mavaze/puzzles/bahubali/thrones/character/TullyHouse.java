package com.mavaze.puzzles.bahubali.thrones.character;

import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.character.Health;

public class TullyHouse implements GameCharacter {
	
	private static final long serialVersionUID = 8524562694723538985L;

	@Override
	public String getMenuName() {
		return "House Tully";
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
