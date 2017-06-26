package com.mavaze.puzzles.bahubali.core.layout;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CompositeLayout extends TextLayout {

	private static final long serialVersionUID = 6830554961792345566L;
	
	private Map<String, TextLayout> embeddedLayouts = new HashMap<>();
	
	public CompositeLayout() {
		
		super(0, 0, 100, 48);
		
		TextLayout statisticsLayout = new StatisticsLayout(0, 26, 80, 35);
		embeddedLayouts.put(StatisticsLayout.KEY, statisticsLayout);
		
		TextLayout menusLayout = new MenusLayout(0, 36, 80, 48);
		embeddedLayouts.put(MenusLayout.KEY, menusLayout);
		
		MapLayout mapLayout = new MapLayout(81, 0, 180, 48);
		embeddedLayouts.put(MapLayout.KEY, mapLayout);
	}
	
	@Override
	public void updateState(Map<String, Object> state) {
		for(Entry<String, TextLayout> entry : embeddedLayouts.entrySet()) {
			entry.getValue().updateState(state);
		}
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