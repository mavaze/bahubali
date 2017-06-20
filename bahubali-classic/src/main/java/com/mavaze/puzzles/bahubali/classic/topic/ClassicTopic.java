package com.mavaze.puzzles.bahubali.classic.topic;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.domain.Entity;
import com.mavaze.puzzles.bahubali.core.layout.Layout;
import com.mavaze.puzzles.bahubali.core.layout.MapLayout;
import com.mavaze.puzzles.bahubali.core.topic.Topic;

public class ClassicTopic implements Topic {
		
	private MapLayout mapLayout;
	
	private List<Entity> entities;
	
	private List<Action> playerActions;
	
	@Override
	public String getMenuName() {
		return "Classic";
	}
	
	public ClassicTopic() {
		mapLayout = new ClassicMapLayout(51, 0, 100, 48);
		entities = new ArrayList<Entity>();
		playerActions = new ArrayList<>();
	}

	@Override
	public Layout getMapLayout() {
		return this.mapLayout;
	}

	@Override
	public List<Entity> getEntities() {
		return entities;
	}

	@Override
	public List<Action> getPlayerActions() {
		return playerActions;
	}

}