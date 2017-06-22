package com.mavaze.puzzles.bahubali.core.character;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.mavaze.puzzles.bahubali.core.actions.Action;

/**
 * Player class
 * 
 * To have Player Topic specific wrap Player in another object like PlayerDetails
 * And let Topic decide the extra properties, like Resources etc, of Player
 * For now, assuming these properties be common across all Topics, keeping all them here
 * 
 * @author mayuresh_vaze
 * 
 */
public class Player implements GameCharacter, Serializable {
	
	private static final long serialVersionUID = -6155318268573153904L;

	private String name;
	
	private AtomicInteger xp = new AtomicInteger(10);

	private Health health = new Health(100, 50, 3);
	
	private Resources resources = new Resources(1000, 10);
		
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

	@Override
	public String getMenuName() {
		return name;
	}

	@Override
	public boolean isAlive() {
		return getHealth().getLife() > 0;
	}

	@Override
	public Health getHealth() {
		return health;
	}

	public AtomicInteger getXp() {
		return xp;
	}

	public Resources getResources() {
		return resources;
	}

}
