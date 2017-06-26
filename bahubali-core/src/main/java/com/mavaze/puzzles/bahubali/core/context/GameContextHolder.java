package com.mavaze.puzzles.bahubali.core.context;

public class GameContextHolder {
	
	private static GameContext context;
	
	private GameContextHolder() { }
	
    public static GameContext getContext() {
    	if(context == null) {
    		context = new GameContextImpl();
    	}
        return context;
    }

}
