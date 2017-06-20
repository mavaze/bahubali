package com.mavaze.puzzles.bahubali.core.topic;

import java.util.List;

import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.action.Menu;
import com.mavaze.puzzles.bahubali.core.domain.Entity;
import com.mavaze.puzzles.bahubali.core.layout.Layout;

public interface Topic extends Menu {
		
	Layout getMapLayout();
	
	List<Entity> getEntities();
	
	List<Action> getPlayerActions();

}
