package com.mavaze.puzzles.bahubali.core.domain;

import java.io.Serializable;

import com.mavaze.puzzles.bahubali.core.actions.Action;
import com.mavaze.puzzles.bahubali.core.character.Player;
import com.mavaze.puzzles.bahubali.core.topic.Topic;

public class GameSnapshot implements MenuItem, Serializable {

	private static final long serialVersionUID = 8115287498114077397L;
	
	private String snapshotId;

	private Topic lastTopic;
	
	private Player lastPlayer;
	
	private Action lastAction;

	public GameSnapshot(String snapshotId) {
		this.snapshotId = snapshotId;
	}

	@Override
	public String getMenuName() {
		return snapshotId;
	}

	public Topic getLastTopic() {
		return lastTopic;
	}
	
	public void setLastTopic(Topic lastTopic) {
		this.lastTopic = lastTopic;
	}

	public Player getLastPlayer() {
		return lastPlayer;
	}

	public void setLastPlayer(Player lastPlayer) {
		this.lastPlayer = lastPlayer;
	}
	
	public Action getLastAction() {
		return this.lastAction;
	}
	
	public void setLastAction(Action lastAction) {
		this.lastAction = lastAction;
	}

}
