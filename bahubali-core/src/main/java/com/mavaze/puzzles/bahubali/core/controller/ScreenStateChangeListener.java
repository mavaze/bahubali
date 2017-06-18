package com.mavaze.puzzles.bahubali.core.controller;

import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

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
	public void onActionsLayoutUpdated(ActionsUpdateEvent event) {
		screenController.updateActions(event.getActions());
	}
	
	@Override
	public void onMapLayoutUpdated(MapsUpdateEvent event) {
		
	}

}
