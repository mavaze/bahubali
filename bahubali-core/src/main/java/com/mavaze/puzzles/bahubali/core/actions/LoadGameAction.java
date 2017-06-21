package com.mavaze.puzzles.bahubali.core.actions;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.context.GameContext;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.domain.GameSnapshot;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.persistence.SerializedSnapshotDao;
import com.mavaze.puzzles.bahubali.core.persistence.SnapshotDao;

public class LoadGameAction extends AbstractAction {
	
	private static final long serialVersionUID = -2097132964871365273L;
	
	private List<GameSnapshot> snapshots = new ArrayList<>();
	
	@Override
	public String getMenuName() {
		return "Load Game";
	}

	public LoadGameAction(StateChangeListener listener) {
		super(listener);
	}
	
	@Override
	public void execute() {
		super.execute();
		
		File snapshotFolder = new File("snapshots");
		File [] savedSnashots = snapshotFolder.listFiles(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(".snapshot");
		    }
		});
		
		for (File savedSnashot : savedSnashots) {
		    SnapshotDao snapshotDao = new SerializedSnapshotDao();
			try {
				GameSnapshot snapshot = snapshotDao.load(savedSnashot);
				snapshots.add(snapshot);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(snapshots.size()==0) {
			nextAction = new EchoAction("No snapshot is available")
					.builder()
					.listener(listener)
					.nextAction(backAction)
					.build();
			nextAction.execute();
		} else {
			MenusUpdateEvent event = new MenusUpdateEvent("Available Snapshots");
			event.setMenus(snapshots);
			event.addMenu(new BackAction(backAction));
			listener.onMenusLayoutUpdated(event);
		}
		
	}
	
	@Override
	public void postExecute(String response) {
		int selectedOption = Integer.parseInt(response);
		if (selectedOption > 0 || selectedOption <= snapshots.size()) {
			GameSnapshot loadedSnapshot = snapshots.get(selectedOption - 1);
			
			Action lastAction = loadedSnapshot.getLastAction();
			GameContext context = GameContextHolder.getContext();
			
			Action activeAction = ((AbstractAction)lastAction).builder().listener(listener).build();
			
			context.setActiveTopic(loadedSnapshot.getLastTopic());
			context.setActivePlayer(loadedSnapshot.getLastPlayer());
			context.setActiveAction(activeAction);
			
			activeAction.execute();
		} else {
			throw new NumberFormatException("Invalid option selected.");
		}
	}

}
