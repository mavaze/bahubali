package com.mavaze.puzzles.bahubali.core.controller;

import java.util.List;

import com.mavaze.puzzles.bahubali.core.action.Action;

public class ActionsUpdateEvent {
	
	private List<Action> actions;

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

}
