package com.mavaze.puzzles.bahubali.core.topic;

import java.util.List;

import com.mavaze.puzzles.bahubali.core.domain.Entity;
import com.mavaze.puzzles.bahubali.core.layout.Layout;

public interface Topic {
	
	String getName();
	
	Layout getMapLayout();
	
	List<Entity> getEntities();

}
