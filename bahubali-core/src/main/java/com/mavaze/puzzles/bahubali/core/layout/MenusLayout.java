package com.mavaze.puzzles.bahubali.core.layout;

import java.util.List;
import java.util.Map;

import com.mavaze.puzzles.bahubali.core.action.Menu;

public class MenusLayout extends TextLayout {

	public static final String KEY = "MENUS";
	
	private static final int x_margin = 5;

	public MenusLayout(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	
	private void update(List<Menu> menus) {
		
		int y = y2 - menus.size() - 1;
		
		if(menus.size() == 1) {
			this.setStringAt(x1 + x_margin, y++, menus.get(0).getMenuName());
		} else {
			int index = 1;
			for(Menu menu : menus) {
				this.setStringAt(x1 + x_margin, y++, index++ + ". " + menu.getMenuName());
			}
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void updateState(Map<String, Object> state) {
		if(state.containsKey(MenusLayout.KEY)) {
			clearLayout();
			List<Menu> menus = (List<Menu>) state.get(MenusLayout.KEY);
			update(menus);
		}
	}
	
}
