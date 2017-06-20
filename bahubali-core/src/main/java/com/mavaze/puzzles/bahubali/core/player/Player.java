package com.mavaze.puzzles.bahubali.core.player;

import java.io.Serializable;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.domain.Health;

public class Player implements Serializable {
	
	private String name;
	
	private Health health;
	
	private List<Action> actions;

	public Player(String name) {
		this.name = name;
	}
	
	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public String getName() {
		return name;
	}

}
