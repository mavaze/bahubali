package com.mavaze.puzzles.bahubali.core.layout;

import java.util.Map;

public class MapLayout extends TextLayout {
	
	private static final long serialVersionUID = 5414682901634609361L;

	protected String mapLayoutConfigFile;
	
	public static final String KEY = "MAP";
	
	public MapLayout(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	@Override
	public void updateState(Map<String, Object> state) {
		// TODO Auto-generated method stub
		
	}

}
