package com.mavaze.puzzles.bahubali.core.layout;

import java.util.Map;
import java.util.Map.Entry;

public class StatisticsLayout extends TextLayout {

	private static final long serialVersionUID = -4709723390891769846L;

	public static final String KEY = "STATISTICS";
	
	private static final int XMARGIN = 5;

	public StatisticsLayout(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void updateState(Map<String, Object> state) {
		if(state.containsKey(StatisticsLayout.KEY)) {
			clearLayout();
			Map<String, Object> event = (Map<String, Object>) state.get(StatisticsLayout.KEY);
			update(event);
		}
	}

	private void update(Map<String, Object> event) {
		int y = getY2() - event.entrySet().size() - 1;			
		for(Entry<String, Object> stat : event.entrySet()) {
			this.setStringAt(getX1() + XMARGIN, y++, stat.getKey() + " -> " + stat.getValue().toString());
		}		
	}
	
}
