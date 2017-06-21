package com.mavaze.puzzles.bahubali.core.listener;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.domain.MenuItem;

public class MenusUpdateEvent {
	
	private String menuTitle;
	
	private List<MenuItem> menus = new ArrayList<>();
	
	public MenusUpdateEvent(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	
	public String getMenuTitle() {
		return menuTitle;
	}

	public List<MenuItem> getMenus() {
		return menus;
	}

	public void setMenus(List<? extends MenuItem> menus) {
		this.menus = new ArrayList<>();
		for(MenuItem menu : menus) {
			addMenu(menu);
		}
	}
	
	public void addMenu(MenuItem menu) {
		this.menus.add(menu);
	}

}
