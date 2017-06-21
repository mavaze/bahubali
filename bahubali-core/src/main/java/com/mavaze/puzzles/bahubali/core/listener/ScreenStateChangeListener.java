package com.mavaze.puzzles.bahubali.core.listener;

import com.mavaze.puzzles.bahubali.core.controller.ScreenController;

public final class ScreenStateChangeListener implements StateChangeListener {
	
	private ScreenController screenController;

	public ScreenStateChangeListener(ScreenController screenController) {
		this.screenController = screenController;
	}
	
	@Override
	public void onStatisticsUpdated(StatisticsUpdateEvent event) {
		// TODO: convert event to statistics object
		screenController.updateStatistics(event);
	}
	
	@Override
	public void onMenusLayoutUpdated(MenusUpdateEvent event) {
		// TODO: convert event to list of menus
		screenController.updateMenus(event);
	}
	
	@Override
	public void onMapLayoutUpdated(MapsUpdateEvent event) {
		
	}

}
