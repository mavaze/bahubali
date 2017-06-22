package com.mavaze.puzzles.bahubali.thrones.character;

import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.character.Health;

public class BaratheonHouse implements GameCharacter {
	
	private static final long serialVersionUID = -111136483853985912L;
	
	private Health health = new Health(100, 0, 0);

	@Override
	public String getMenuName() {
		return "House Baratheon";
	}

	@Override
	public boolean isAlive() {
		return getHealth().getLife() > 0;
	}

	@Override
	public Health getHealth() {
		return health;
	}

}
