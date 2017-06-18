package com.mavaze.puzzles.bahubali.characters;

import java.util.List;
import java.util.Map;

import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.action.Actionable;
import com.mavaze.puzzles.bahubali.core.domain.Character;
import com.mavaze.puzzles.bahubali.core.domain.Health;

public class CerseiLannister implements Character, Actionable {
	
	private boolean alive;
	
	private List<Action> actions;

	@Override
	public Map<String, Object> getCharacteristics() {
		return null;
	}
	
	@Override
	public boolean isAlive() {
		return alive;
	}

	@Override
	public Health getHealth() {
		return null;
	}

	@Override
	public void setBackAction(Action backAction) {
		actions.add(backAction);
	}
	
	@Override
	public List<Action> getActions() {
		return actions;
	}

}
