package com.mavaze.puzzles.bahubali.core.actions;

import java.io.File;
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

public class LoadGameAction extends AbstractAction<GameSnapshot> {

	private static final long serialVersionUID = -2097132964871365273L;

	private List<GameSnapshot> snapshots = new ArrayList<>();

	private transient SnapshotDao snapshotDao;

	public LoadGameAction(StateChangeListener listener) {
		this(listener, new SerializedSnapshotDao());
	}

	public LoadGameAction(StateChangeListener listener, SnapshotDao snapshotDao) {
		super(listener);
		this.snapshotDao = snapshotDao;
	}

	@Override
	public String getMenuName() {
		return "Load Game";
	}

	@Override
	protected List<GameSnapshot> getActionMenus() {
		return snapshots;
	}

	protected File[] getStoredSnapshots() {
		File snapshotFolder = new File("snapshots");
		return snapshotFolder.listFiles((dir, name) -> name.endsWith(".snapshot"));
	}

	@Override
	public void execute() {
		super.execute();

		File[] savedSnashots = getStoredSnapshots();

		for (File savedSnashot : savedSnashots) {
			try {
				// Loading all available snapshots in advance to show only
				// that list of snapshots which were able to get deserialized
				GameSnapshot snapshot = snapshotDao.load(savedSnashot);
				snapshots.add(snapshot);
			} catch (Exception e) {
				// Skipping this snapshot as it was failed to deserialize
				// Log this exception with logger
			}
		}

		if (snapshots.isEmpty()) {
			new EchoAction("No snapshot is available").builder().listener(listener).nextAction(backAction).build()
					.execute();
		} else {
			MenusUpdateEvent event = new MenusUpdateEvent("Available Snapshots");
			event.setMenus(snapshots);
			event.addMenu(new BackAction(backAction));
			listener.onMenusLayoutUpdated(event);
		}
	}

	@Override
	public void postExecute(GameSnapshot loadedSnapshot) {
		GameContext context = GameContextHolder.getContext();
		context.setActiveTopic(loadedSnapshot.getLastTopic());
		context.setActivePlayer(loadedSnapshot.getLastPlayer());
		listener.onStatisticsUpdated(new StatisticsUpdateEvent().builder().build());
		setNextAction(new PlayerCompositeAction(listener));
	}

}
