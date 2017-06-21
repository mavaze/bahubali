package com.mavaze.puzzles.bahubali.core.character;

import com.mavaze.puzzles.bahubali.core.domain.GameEntity;

public interface GameCharacter extends GameEntity {

	boolean isAlive();
	
	Health getHealth();
	
}
