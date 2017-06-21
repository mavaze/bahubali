package com.mavaze.puzzles.bahubali.core.layout;

import java.util.List;
import java.util.Map;

import com.mavaze.puzzles.bahubali.core.domain.MenuItem;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;

public class MenusLayout extends TextLayout {

	private static final long serialVersionUID = 8105981024749076445L;

	public static final String KEY = "MENUS";
	
	private static final int x_margin = 5;

	public MenusLayout(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	
	//private void update(List<MenuItem> menus) {
	private void update(MenusUpdateEvent event) {
		List<MenuItem> menus = event.getMenus();
		
		int y = y2 - menus.size() - 3;
		this.setStringAt(x1 + x_margin, y, event.getMenuTitle());
		
		y+=2;
		
		if(menus.size() == 1) {
			this.setStringAt(x1 + x_margin, y++, menus.get(0).getMenuName());
		} else {
			int index = 1;
			for(MenuItem menu : menus) {
				this.setStringAt(x1 + x_margin, y++, index++ + ". " + menu.getMenuName());
			}
		}
	}
	
	@Override
	public void updateState(Map<String, Object> state) {
		if(state.containsKey(MenusLayout.KEY)) {
			clearLayout();
			//List<MenuItem> menus = (List<MenuItem>) state.get(MenusLayout.KEY);
			MenusUpdateEvent event = (MenusUpdateEvent) state.get(MenusLayout.KEY);
			update(event);
		}
	}
	
}
