package com.mavaze.puzzles.bahubali.core.actions;

import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.character.Player;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.fight.DefaultFightStrategy;
import com.mavaze.puzzles.bahubali.core.fight.FightStrategy;

public class FightAction extends AbstractAction {

	private static final long serialVersionUID = 736628048599654831L;
	
	private FightStrategy strategy;
	
	private GameCharacter opponent;
	
	@Override
	public String getMenuName() {
		return null;
	}
	
	public FightAction() {
		this.strategy = new DefaultFightStrategy();
	}
	
	public FightAction(final FightStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void setOpponent(GameCharacter opponent) {
		this.opponent = opponent;
	}
	
	@Override
	public void execute() {
		super.execute();
		Player player = GameContextHolder.getContext().getActivePlayer();
		strategy.fight(player, opponent);
		new EchoAction("You defeated " + opponent.getMenuName() + ". XP increased by 10.")
				.builder().listener(listener).nextAction(backAction).build().execute();
	}

}
