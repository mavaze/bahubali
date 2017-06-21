package com.mavaze.puzzles.bahubali.core.actions;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mavaze.puzzles.bahubali.core.context.GameContext;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.domain.GameSnapshot;
import com.mavaze.puzzles.bahubali.core.persistence.SerializedSnapshotDao;
import com.mavaze.puzzles.bahubali.core.persistence.SnapshotDao;

public class QuitAndSaveAction extends AbstractAction {

	private static final long serialVersionUID = -6436943850713182465L;

	@Override
	public String getMenuName() {
		return "Save and Quit";
	}
	
	@Override
	public void execute() {
		
		GameContext context = GameContextHolder.getContext();
		
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String snapshotName = context.getActivePlayer().getName() + "-" + formatter.format(new Date());
				
		GameSnapshot snapshot = new GameSnapshot(snapshotName);
		snapshot.setLastAction(context.getActiveAction());
		snapshot.setLastPlayer(context.getActivePlayer());
		snapshot.setLastTopic(context.getActiveTopic());
		
		SnapshotDao snapshotDao = new SerializedSnapshotDao();
		try {
			snapshotDao.save(snapshot);
		} catch (Exception e) {
			new EchoAction("Unable to save game").builder().listener(listener).build();
		}
		new ExitGameAction().execute();
	}

}
