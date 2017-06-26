package com.mavaze.puzzles.bahubali.thrones.character;

import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.character.Health;

public abstract class AbstractHouse implements GameCharacter {
	
	private static final long serialVersionUID = 1837821025551001212L;
	
	protected Health health = new Health(100, 0, 0);

	@Override
	public boolean isAlive() {
		return getHealth().getLife() > 0;
	}

	@Override
	public Health getHealth() {
		return health;
	}

}
