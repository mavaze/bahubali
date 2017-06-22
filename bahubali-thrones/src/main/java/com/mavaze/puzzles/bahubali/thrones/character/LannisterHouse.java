package com.mavaze.puzzles.bahubali.thrones.character;

import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.character.Health;

public class LannisterHouse implements GameCharacter {

	private static final long serialVersionUID = 5125377008411844823L;

	private Health health = new Health(100, 0, 0);

	@Override
	public String getMenuName() {
		return "House Lannister";
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
