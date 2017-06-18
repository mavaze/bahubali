package com.mavaze.puzzles.bahubali.core.layout;

import java.util.Map;

public interface Layout {
	
	int getX1();
	
	int getX2();
	
	int getY1();
	
	int getY2();
	
	void updateState(Map<String, Object> state);

}