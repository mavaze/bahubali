package com.mavaze.puzzles.bahubali.core.domain;

import java.io.Serializable;

import com.mavaze.puzzles.bahubali.core.action.Menu;

public class Snapshot implements Menu, Serializable {

	private static final long serialVersionUID = 8115287498114077397L;
	
	private String name;

	@Override
	public String getMenuName() {
		return this.name;
	}

}
