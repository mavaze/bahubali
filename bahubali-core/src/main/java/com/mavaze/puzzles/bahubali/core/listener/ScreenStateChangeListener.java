package com.mavaze.puzzles.bahubali.core.listener;

import com.mavaze.puzzles.bahubali.core.controller.ScreenController;

public final class ScreenStateChangeListener implements StateChangeListener {
	
	private ScreenController screenController;

	public ScreenStateChangeListener(ScreenController screenController) {
		this.screenController = screenController;
	}
	
	@Override
	public void onStatisticsUpdated(StatisticsUpdateEvent event) {
		screenController.updateStatistics(event.getStatistics());
	}
	
	@Override
	public void onMenusLayoutUpdated(MenusUpdateEvent event) {
		screenController.updateActions(event.getMenus());
	}
	
	@Override
	public void onMapLayoutUpdated(MapsUpdateEvent event) {
		
	}

}
