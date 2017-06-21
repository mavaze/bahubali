package com.mavaze.puzzles.bahubali.thrones.topic;

import com.mavaze.puzzles.bahubali.core.layout.MapLayout;

public class ThronesMapLayout extends MapLayout {

	private static final long serialVersionUID = -6729856026768217742L;

	public ThronesMapLayout(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
		
		// load map file and set variable
		// this is just for illustration. Map is not loaded like this.
		// TODO: functionality yet to be implemented
		this.mapLayoutConfigFile = "GameOfThronesLayout.map";
	}

}
