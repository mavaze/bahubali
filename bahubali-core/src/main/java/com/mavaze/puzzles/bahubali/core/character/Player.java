package com.mavaze.puzzles.bahubali.core.character;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.mavaze.puzzles.bahubali.core.actions.Action;

public class Player implements GameCharacter, Fightable, Serializable {
	
	private static final long serialVersionUID = -6155318268573153904L;

	private String name;
	
	private Health health;
	
	private Resources resources;
	
	private int experience;
	
	private List<Action> actions;

	public Player(String name) {
		this.name = name;
	}
	
	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public String getName() {
		return name;
	}

	@Override
	public Map<String, Object> getCharacteristics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMenuName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAlive() {
		return true;
	}

	@Override
	public Health getHealth() {
		return health;
	}

}
