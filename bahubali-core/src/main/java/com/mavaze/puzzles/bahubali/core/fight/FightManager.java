package com.mavaze.puzzles.bahubali.core.fight;

import com.mavaze.puzzles.bahubali.core.character.GameCharacter;

public class FightManager {
	
	private FightStrategy strategy;
	
	public FightManager() {
		this.strategy = new DefaultFightStrategy();
	}
	
	public void fight(GameCharacter player, GameCharacter opponent) {
		strategy.fight(player, opponent);
	}
	

}
