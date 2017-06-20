package com.mavaze.puzzles.bahubali.core.commands;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.domain.Snapshot;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.persistence.SerializedSnapshotDao;
import com.mavaze.puzzles.bahubali.core.persistence.SnapshotDao;

public class LoadGameAction extends AbstractAction {
	
	private List<Snapshot> snapshots = new ArrayList<>();

	public LoadGameAction(StateChangeListener listener) {
		super(listener);
	}
	
	@Override
	public void execute() {
		File snapshotFolder = new File(".");
		File [] savedSnashots = snapshotFolder.listFiles(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(".snapshot");
		    }
		});
		
		for (File savedSnashot : savedSnashots) {
		    SnapshotDao snapshotDao = new SerializedSnapshotDao();
			try {
				Snapshot snapshot = snapshotDao.load(savedSnashot);
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
			new MenusUpdateEvent("Available Snapshots")
		}
		
	}

	@Override
	public String getMenuName() {
		return "Load Game";
	}


}
