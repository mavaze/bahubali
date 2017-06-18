package com.mavaze.puzzles.bahubali.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.action.Actionable;
import com.mavaze.puzzles.bahubali.core.domain.Entity;

public class Brothel implements Entity, Actionable {
	
	List<Action> actions = new ArrayList<>();
	
	Action backAction;
	
	public Brothel() {
	}

	@Override
	public List<Action> getActions() {
		List<Action> withBackAction = new ArrayList<>(actions);
		withBackAction.add(backAction);
		return withBackAction;
	}

	@Override
	public Map<String, Object> getCharacteristics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBackAction(Action backAction) {
		this.backAction = backAction;
	}

}
