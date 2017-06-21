package com.mavaze.puzzles.bahubali.core.domain;

import java.io.Serializable;
import java.util.Map;

public interface GameEntity extends MenuItem, Serializable {
	
	Map<String, Object> getCharacteristics();
	
}