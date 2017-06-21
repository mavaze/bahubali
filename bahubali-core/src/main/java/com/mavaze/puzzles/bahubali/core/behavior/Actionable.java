package com.mavaze.puzzles.bahubali.core.behavior;

import java.util.List;

import com.mavaze.puzzles.bahubali.core.actions.Action;

public interface Actionable {

	List<Action> getActions();
	
	void setBackAction(Action action);
	
}