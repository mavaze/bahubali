package com.mavaze.puzzles.bahubali.core.context;

import java.util.Map;

import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.player.PlayerDetails;
import com.mavaze.puzzles.bahubali.core.settings.GameSettings;

public class GameContextImpl implements GameContext {

	private static final long serialVersionUID = 5051508470706672582L;
	
	private Action activeAction;
	
	@SuppressWarnings("unused")
	private Map<String, Object> properties;

	public GameSettings getSettings() {
		// TODO Auto-generated method stub
		return null;
	}

	public PlayerDetails getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action getActiveAction() {
		return activeAction;
	}

	@Override
	public void setActiveAction(Action activeAction) {
		this.activeAction = activeAction;
	}

}
