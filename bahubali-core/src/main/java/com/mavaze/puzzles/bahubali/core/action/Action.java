package com.mavaze.puzzles.bahubali.core.action;

public interface Action {
	
	String getActionName();
	
	void execute();
	
	void postExecute(String response);

}
