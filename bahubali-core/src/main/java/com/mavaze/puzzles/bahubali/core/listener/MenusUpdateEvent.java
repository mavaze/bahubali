package com.mavaze.puzzles.bahubali.core.listener;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.action.Menu;

public class MenusUpdateEvent {
	
	private String menuTitle;
	
	private List<Menu> menus = new ArrayList<>();
	
	public MenusUpdateEvent(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	
	public String getMenuTitle() {
		return menuTitle;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<? extends Menu> menus) {
		this.menus = new ArrayList<>();
		for(Menu menu : menus) {
			addMenu(menu);
		}
	}
	
	public void addMenu(Menu menu) {
		this.menus.add(menu);
	}

}
