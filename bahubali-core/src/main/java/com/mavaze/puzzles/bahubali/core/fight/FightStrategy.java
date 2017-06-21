package com.mavaze.puzzles.bahubali.core.fight;

import com.mavaze.puzzles.bahubali.core.character.GameCharacter;

public interface FightStrategy {

	void fight(GameCharacter player, GameCharacter opponent);
}
