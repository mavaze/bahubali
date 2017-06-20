package com.mavaze.puzzles.bahubali.core.action;

public interface Action extends Menu {
	
	void execute();
	
	void postExecute(String response);

}
