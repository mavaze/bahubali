package com.mavaze.puzzles.bahubali.classic.topic;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.actions.Action;
import com.mavaze.puzzles.bahubali.core.domain.GameEntity;
import com.mavaze.puzzles.bahubali.core.layout.Layout;
import com.mavaze.puzzles.bahubali.core.layout.MapLayout;
import com.mavaze.puzzles.bahubali.core.topic.Topic;

public class ClassicTopic implements Topic {
		
	private static final long serialVersionUID = -3592116646575852991L;

	private MapLayout mapLayout;
	
	private List<GameEntity> entities;
	
	private List<Action> playerActions;
	
	public ClassicTopic() {
		mapLayout = new ClassicMapLayout(81, 0, 180, 48);
		entities = new ArrayList<>();
		playerActions = new ArrayList<>();
	}
	
	@Override
	public String getMenuName() {
		return "Classic";
	}

	@Override
	public Layout getMapLayout() {
		return this.mapLayout;
	}

	@Override
	public List<GameEntity> getEntities() {
		return entities;
	}

	@Override
	public List<Action> getPlayerActions() {
		return playerActions;
	}

}