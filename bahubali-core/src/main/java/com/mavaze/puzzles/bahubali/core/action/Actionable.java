package com.mavaze.puzzles.bahubali.core.action;

import java.util.List;

public interface Actionable {

	List<Action> getActions();
	
	void setBackAction(Action action);
	
}
