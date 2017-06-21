package com.mavaze.puzzles.bahubali.core.topic;

import java.io.Serializable;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.actions.Action;
import com.mavaze.puzzles.bahubali.core.domain.GameEntity;
import com.mavaze.puzzles.bahubali.core.domain.MenuItem;
import com.mavaze.puzzles.bahubali.core.layout.Layout;

public interface Topic extends MenuItem, Serializable {
		
	Layout getMapLayout();
	
	List<GameEntity> getEntities();
	
	List<Action> getPlayerActions();

}