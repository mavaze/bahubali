package com.mavaze.puzzles.bahubali.thrones.actions;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mavaze.puzzles.bahubali.core.actions.Action;
import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.domain.GameEntity;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.thrones.character.AbstractHouse;

public class WanderKingdomActionTest {

	@Mock
	private StateChangeListener listener;
	
	@Mock
	private Action backAction;
	
	private WanderKingdomAction actionUnderTest;
	
	@Captor
	ArgumentCaptor<MenusUpdateEvent> menuEventCaptor;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		List<GameEntity> entities = new ArrayList<>();
		entities.add(mock(AbstractHouse.class));
		
		GameEntity entity1 = spy(GameEntity.class);
		when(entity1.getMenuName()).thenReturn("Entity1");
		entities.add(entity1);
		
		entities.add(mock(GameCharacter.class));
		
		GameEntity entity2 = spy(GameEntity.class);
		when(entity2.getMenuName()).thenReturn("Entity2");
		entities.add(entity2);
		
		actionUnderTest = (WanderKingdomAction) new WanderKingdomAction(entities).builder()
				.listener(listener).backAction(backAction).build();
	}
	
	@Test
	public void testWanderKingdomActionMenuName() {
		assertEquals("Wander Kingdom", actionUnderTest.getMenuName());
	}
	
	@Test
	public void testWanderKingdomActionExecutionFlow() {
		actionUnderTest.execute();
		assertEquals(actionUnderTest, GameContextHolder.getContext().getActiveAction());		
		verify(listener).onMenusLayoutUpdated(menuEventCaptor.capture());		
		assertEquals("Wander Kingdom", menuEventCaptor.getValue().getMenuTitle());
		assertEquals(3, menuEventCaptor.getValue().getMenus().size());
	}
	
	@Test
	public void testWanderKingdomActionPostExecutionFlow() {
		actionUnderTest.postExecute("1");
		assertEquals("You visited Entity1", GameContextHolder.getContext().getActiveAction().getMenuName());
	}

}
