package com.mavaze.puzzles.bahubali.topic;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.domain.Entity;
import com.mavaze.puzzles.bahubali.core.layout.Layout;
import com.mavaze.puzzles.bahubali.core.topic.Topic;

public class ThronesTopic implements Topic {
		
	private Layout mapLayout;
	
	private List<Entity> entities;
	
	public ThronesTopic() {
		mapLayout = new ThronesMapLayout();
		entities = new ArrayList<Entity>();
	}

	@Override
	public String getName() {
		return "Game of Thrones";
	}

	@Override
	public Layout getMapLayout() {
		return this.mapLayout;
	}

	@Override
	public List<Entity> getEntities() {
		return entities;
	}

}