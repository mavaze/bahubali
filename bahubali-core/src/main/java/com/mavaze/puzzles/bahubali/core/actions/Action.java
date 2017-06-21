package com.mavaze.puzzles.bahubali.core.actions;

import java.io.Serializable;

import com.mavaze.puzzles.bahubali.core.domain.MenuItem;

public interface Action extends MenuItem, Serializable {
	
	Action getBackAction();

	Action getNextAction();
	
	void execute();
	
	void postExecute(String response);

}