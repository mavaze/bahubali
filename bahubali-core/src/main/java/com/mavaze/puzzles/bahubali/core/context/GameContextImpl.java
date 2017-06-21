package com.mavaze.puzzles.bahubali.core.context;

import java.util.Map;

import com.mavaze.puzzles.bahubali.core.actions.Action;
import com.mavaze.puzzles.bahubali.core.character.Player;
import com.mavaze.puzzles.bahubali.core.topic.Topic;

public class GameContextImpl implements GameContext {

	private static final long serialVersionUID = 5051508470706672582L;
		
	private Topic activeTopic;
	
	private Player activePlayer;
	
	private Action activeAction;
	
	@SuppressWarnings("unused")
	private Map<String, Object> properties;

	public Player getActivePlayer() {
		return activePlayer;
	}

	@Override
	public Action getActiveAction() {
		return activeAction;
	}

	@Override
	public void setActiveAction(Action activeAction) {
		this.activeAction = activeAction;
	}
	
	@Override
	public Topic getActiveTopic() {
		return activeTopic;
	}

	@Override
	public void setActiveTopic(Topic activeTopic) {
		this.activeTopic = activeTopic;	
	}

	@Override
	public void setActivePlayer(Player player) {
		this.activePlayer = player;
	}

}
