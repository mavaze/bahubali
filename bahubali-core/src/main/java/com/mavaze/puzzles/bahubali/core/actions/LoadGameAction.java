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
import com.mavaze.puzzles.bahubali.core.listener.StatisticsUpdateEvent;
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
				// Loading all available snapshots in advance to show only
				// that list of snapshots which were able to get deserialized
				GameSnapshot snapshot = snapshotDao.load(savedSnashot);
				snapshots.add(snapshot);
			} catch (Exception e) {
				// Skipping this snapshot as it was failed to deserialize
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
			GameContext context = GameContextHolder.getContext();
			context.setActiveTopic(loadedSnapshot.getLastTopic());
			context.setActivePlayer(loadedSnapshot.getLastPlayer());
			listener.onStatisticsUpdated(new StatisticsUpdateEvent());
			new PlayerCompositeAction(listener).execute();			
		} else {
			throw new NumberFormatException("Invalid option selected.");
		}
	}

}
