package com.mavaze.puzzles.bahubali.core.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.mavaze.puzzles.bahubali.core.character.Player;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.domain.GameSnapshot;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.listener.StatisticsUpdateEvent;
import com.mavaze.puzzles.bahubali.core.persistence.SnapshotDao;
import com.mavaze.puzzles.bahubali.core.topic.Topic;

public class LoadGameActionTest {
	
	@Mock
	private StateChangeListener listener;
	
	@Mock
	private SnapshotDao snapshotDao;
	
	@Spy
	@InjectMocks
	private LoadGameAction actionUnderTest;
	
	@Captor
	ArgumentCaptor<MenusUpdateEvent> eventCaptor;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testHomeCompositeActionMunuName() {
		assertEquals("Load Game", actionUnderTest.getMenuName());
	}
	
	@Test
	public void testLoadGameActionExecutionFlowWihNoSnapshotsAvailable() throws IOException {
		when(actionUnderTest.getStoredSnapshots()).thenReturn(new File[] {});
		
		actionUnderTest.execute();
		
		verify(listener).onMenusLayoutUpdated(eventCaptor.capture());		
		assertEquals("No snapshot is available", eventCaptor.getValue().getMenuTitle());
		assertNotEquals(actionUnderTest, GameContextHolder.getContext().getActiveAction());
	}
	
	@Test
	public void testLoadGameActionExecutionFlowWhenSnapshotFailToLoad() throws IOException {
		File dummyFile = new File("dummy.snapshot");
		when(actionUnderTest.getStoredSnapshots()).thenReturn(new File[] {dummyFile});
		when(snapshotDao.load(dummyFile)).thenThrow(new IOException());
		
		actionUnderTest.execute();
		
		verify(listener).onMenusLayoutUpdated(eventCaptor.capture());		
		assertEquals("No snapshot is available", eventCaptor.getValue().getMenuTitle());
		assertNotEquals(actionUnderTest, GameContextHolder.getContext().getActiveAction());
	}
	
	@Test
	public void testLoadGameActionExecutionFlowWithSnapshotsAvailable() throws IOException {
		GameSnapshot snapshot = mock(GameSnapshot.class);
		File dummyFile = new File("dummy.snapshot");
		when(actionUnderTest.getStoredSnapshots()).thenReturn(new File[] {dummyFile});
		when(snapshotDao.load(dummyFile)).thenReturn(snapshot);
		when(snapshot.getMenuName()).thenReturn("Dummy Snapshot");
		
		actionUnderTest.execute();
		
		verify(listener).onMenusLayoutUpdated(eventCaptor.capture());		
		assertEquals("Available Snapshots", eventCaptor.getValue().getMenuTitle());
		assertEquals("Dummy Snapshot", eventCaptor.getValue().getMenus().get(0).getMenuName());
		assertEquals(actionUnderTest, GameContextHolder.getContext().getActiveAction());
		
		when(snapshot.getLastTopic()).thenReturn(mock(Topic.class));
		when(snapshot.getLastPlayer()).thenReturn(new Player("Mayuresh"));
		
		actionUnderTest.postExecute("1");
		
		verify(listener).onStatisticsUpdated(any(StatisticsUpdateEvent.class));
		assertEquals("Player Actions", GameContextHolder.getContext().getActiveAction().getMenuName());
	}

}
