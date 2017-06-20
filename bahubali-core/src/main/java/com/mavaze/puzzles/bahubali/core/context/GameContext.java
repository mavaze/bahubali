package com.mavaze.puzzles.bahubali.core.context;

import java.io.Serializable;

import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.player.Player;
import com.mavaze.puzzles.bahubali.core.topic.Topic;

public interface GameContext extends Serializable {
		
	Action getActiveAction();

	void setActiveAction(Action action);

	Topic getActiveTopic();
	
	void setActiveTopic(Topic topic);
	
	Player getPlayer();

	void setPlayer(Player player);
	
}