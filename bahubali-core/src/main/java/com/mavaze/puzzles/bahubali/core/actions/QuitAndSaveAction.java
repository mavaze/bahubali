package com.mavaze.puzzles.bahubali.core.actions;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mavaze.puzzles.bahubali.core.context.GameContext;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.domain.GameSnapshot;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.persistence.SerializedSnapshotDao;
import com.mavaze.puzzles.bahubali.core.persistence.SnapshotDao;

@SuppressWarnings("rawtypes")
public class QuitAndSaveAction extends AbstractAction {

	private static final long serialVersionUID = -6436943850713182465L;
	
	private transient SnapshotDao snapshotDao;
	
	public QuitAndSaveAction(StateChangeListener listener) {
		this(listener, new SerializedSnapshotDao());
	}

	public QuitAndSaveAction(StateChangeListener listener, SnapshotDao snapshotDao) {
		super(listener);
		this.snapshotDao = snapshotDao;
	}

	@Override
	public String getMenuName() {
		return "Save and Quit";
	}
	
	private GameSnapshot createSnapshot() {
		
		GameContext context = GameContextHolder.getContext();
		
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String snapshotName = context.getActivePlayer().getMenuName() + "-" + formatter.format(new Date());
				
		GameSnapshot snapshot = new GameSnapshot(snapshotName);
		snapshot.setLastAction(context.getActiveAction());
		snapshot.setLastPlayer(context.getActivePlayer());
		snapshot.setLastTopic(context.getActiveTopic());
		
		return snapshot;
	}
	
	@Override
	public void execute() {
		GameSnapshot snapshot = createSnapshot();
		try {
			snapshotDao.save(snapshot);
		} catch (Exception e) {
			new EchoAction("Unable to save game").builder().listener(listener).build();
		}
		new ExitGameAction().builder().listener(listener).build().execute();
	}

}
