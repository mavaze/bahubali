package com.mavaze.puzzles.bahubali.core.action;

import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public abstract class AbstractAction implements Action {
	
	protected Action backAction;
	
	protected Action nextAction;
	
	protected StateChangeListener listener;
	
	public AbstractAction(StateChangeListener listener) {
		this.listener = listener;
	}
	
	@Override
	public void execute() {
		GameContextHolder.getContext().setActiveAction(this);
	}
	
	@Override
	public void postExecute(String response) {
		
	}
	
	public  Builder builder() {
		return new Builder(this);
	}

	public static class Builder {
		
		private AbstractAction action;
		
		public Builder(AbstractAction action) {
			this.action = action;
		}
		
		public Builder listener(StateChangeListener listener) {
			this.action.listener = listener;
			return this;
		}
		
		public Builder backAction(Action backAction) {
			this.action.backAction = backAction;
			return this;
		}
		
		public Builder nextAction(Action nextAction) {
			this.action.nextAction = nextAction;
			return this;
		}
		
		public AbstractAction build() {
			return action;
		}
		
	}
}