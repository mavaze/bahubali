package com.mavaze.puzzles.bahubali.core.actions;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.domain.MenuItem;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

@SuppressWarnings("serial")
public abstract class AbstractAction<T extends MenuItem> implements Action {
	
	protected Action backAction;
	
	private Action nextAction;
		
	protected transient StateChangeListener listener;
	
	public AbstractAction() { }
	
	public AbstractAction(StateChangeListener listener) {
		this.listener = listener;
	}
	
	protected List<T> getActionMenus() {
		return new ArrayList<>();
	}

	@Override
	public Action getBackAction() {
		return backAction;
	}
	
	public void setBackAction(Action backAction) {
		this.backAction = backAction;
	}

	@Override
	public Action getNextAction() {
		return nextAction;
	}
	
	public void setNextAction(Action nextAction) {
		this.nextAction = nextAction;
	}
	
	@Override
	public void execute() {
		GameContextHolder.getContext().setActiveAction(this);
	}
	
	protected void postExecute(T menu) { }
		
	@Override
	public void postExecute(String response) {
		int selectedOption = Integer.parseInt(response);
		if (selectedOption > 0 && selectedOption <= getActionMenus().size()) {
			T menu = getActionMenus().get(selectedOption - 1);
			// This is template method. All actions are encouraged to implement following method
			postExecute(menu);	
			if(getNextAction() != null) {
				getNextAction().execute();
			}
		} else if (backAction != null && selectedOption == getActionMenus().size() + 1) {
			backAction.execute();
		} else {
			throw new NumberFormatException("Invalid option selected.");
		}
	}
	
	public  Builder<T> builder() {
		return new Builder<>(this);
	}

	public static class Builder<T extends MenuItem> {
		
		private AbstractAction<T> action;
		
		public Builder(AbstractAction<T> action) {
			this.action = action;
		}
		
		public Builder<T> listener(StateChangeListener listener) {
			this.action.listener = listener;
			return this;
		}
		
		public Builder<T> backAction(Action backAction) {
			this.action.setBackAction(backAction);
			return this;
		}
		
		public Builder<T> nextAction(Action nextAction) {
			this.action.setNextAction(nextAction);
			return this;
		}
		
		public AbstractAction<T> build() {
			return action;
		}
		
	}
}