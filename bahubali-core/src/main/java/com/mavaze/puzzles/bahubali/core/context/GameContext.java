package com.mavaze.puzzles.bahubali.core.context;

import java.io.Serializable;

import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.player.PlayerDetails;
import com.mavaze.puzzles.bahubali.core.settings.GameSettings;

public interface GameContext extends Serializable {

	GameSettings getSettings();
	
	PlayerDetails getPlayer();
	
	Action getActiveAction();

	void setActiveAction(Action action);
	
}