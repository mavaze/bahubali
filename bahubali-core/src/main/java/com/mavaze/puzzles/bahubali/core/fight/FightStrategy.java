package com.mavaze.puzzles.bahubali.core.fight;

import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.character.Player;

public interface FightStrategy {

	void fight(Player player, GameCharacter opponent);
}
