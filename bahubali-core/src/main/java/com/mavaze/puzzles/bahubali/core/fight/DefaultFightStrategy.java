package com.mavaze.puzzles.bahubali.core.fight;

import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.character.Player;

public class DefaultFightStrategy implements FightStrategy {

	@Override
	public void fight(Player player, GameCharacter opponent) {
		player.getXp().addAndGet(10);
		opponent.getHealth().damageAndGetLife(100);
	}

}
