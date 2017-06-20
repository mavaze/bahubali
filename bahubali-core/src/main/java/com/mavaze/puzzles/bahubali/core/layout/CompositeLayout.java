package com.mavaze.puzzles.bahubali.core.layout;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CompositeLayout extends TextLayout {
	
	private Map<String, TextLayout> embeddedLayouts = new HashMap<>();

	public void updateState(Map<String, Object> state) {
		for(Entry<String, TextLayout> entry : embeddedLayouts.entrySet()) {
			entry.getValue().updateState(state);
		}
	}
	
	public CompositeLayout() {
		
		super(0, 0, 100, 48);
		
		TextLayout statisticsLayout = new StatisticsLayout(0, 29, 50, 38);
		embeddedLayouts.put(StatisticsLayout.KEY, statisticsLayout);
		
		TextLayout menusLayout = new MenusLayout(0, 39, 50, 48);
		embeddedLayouts.put(MenusLayout.KEY, menusLayout);
		
		MapLayout mapLayout = new MapLayout(51, 0, 100, 48);
		embeddedLayouts.put(MapLayout.KEY, mapLayout);
	}

	@Override
	public char getCharacterAt(int x, int y) {
		for(Entry<String, TextLayout> entry : embeddedLayouts.entrySet()) {
			char letter = entry.getValue().getCharacterAt(x, y);
			if(letter!='\u0000') {
				return letter;
			}
		}
		return '\u0000';
	}

}