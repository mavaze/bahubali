package com.mavaze.puzzles.bahubali.core.actions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.persistence.SnapshotDao;

public class QuitAndSaveActionTest {
	
	@Mock
	private StateChangeListener listener;
	
	@Mock
	private SnapshotDao snapshotDao;
	
	@InjectMocks
	private QuitAndSaveAction actionUnderTest;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testQuitAndSaveActionMenuName() {
		assertEquals("Save and Quit", actionUnderTest.getMenuName());
	}
}
