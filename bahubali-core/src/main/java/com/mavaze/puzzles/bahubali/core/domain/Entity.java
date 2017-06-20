package com.mavaze.puzzles.bahubali.core.domain;

import java.util.Map;

import com.mavaze.puzzles.bahubali.core.action.Menu;

public interface Entity extends Menu {
	
	Map<String, Object> getCharacteristics();
	
}