package com.mavaze.puzzles.bahubali.thrones.actions;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
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
import com.mavaze.puzzles.bahubali.core.character.Health;
import com.mavaze.puzzles.bahubali.core.character.Player;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.domain.GameEntity;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.listener.StatisticsUpdateEvent;
import com.mavaze.puzzles.bahubali.thrones.character.AbstractHouse;

public class ClashWithHouseActionTest {

	@Mock
	private StateChangeListener listener;
	
	@Mock
	private Action backAction;
	
	private ClashWithHouseAction actionUnderTest;
	
	@Captor
	ArgumentCaptor<MenusUpdateEvent> menuEventCaptor;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		List<GameEntity> entities = new ArrayList<>();
		
		Health health = new Health(100, 50, 3);
		
		GameCharacter house1 = spy(AbstractHouse.class);
		when(house1.getMenuName()).thenReturn("House1");
		when(house1.getHealth()).thenReturn(health);
		entities.add(house1);
		
		entities.add(mock(GameEntity.class));
		
		GameCharacter house2 = mock(AbstractHouse.class);
		when(house2.getMenuName()).thenReturn("House2");
		when(house2.isAlive()).thenReturn(true);
		entities.add(house2);
		
		actionUnderTest = (ClashWithHouseAction) new ClashWithHouseAction(entities).builder()
				.listener(listener).backAction(backAction).build();
	}
	
	@Test
	public void testClashWithHouseActionMenuName() {
		assertEquals("Clash of Houses", actionUnderTest.getMenuName());
	}
	
	@Test
	public void testClashWithHouseActionExecutionFlow() {
		actionUnderTest.execute();
		assertEquals(actionUnderTest, GameContextHolder.getContext().getActiveAction());		
		verify(listener).onMenusLayoutUpdated(menuEventCaptor.capture());		
		assertEquals("Clash of Houses", menuEventCaptor.getValue().getMenuTitle());
		assertEquals(3, menuEventCaptor.getValue().getMenus().size());
	}

	@Test
	public void testClashWithHouseActionPostExecutionFlow() {
		Player player = new Player("Mayuresh");
		GameContextHolder.getContext().setActivePlayer(player);
		assertEquals(100, actionUnderTest.getActionMenus().get(0).getHealth().getLife());
		assertEquals(true, actionUnderTest.getActionMenus().get(0).isAlive());
		assertEquals(10, player.getXp().get());
		
		actionUnderTest.postExecute("1");
		
		verify(listener).onStatisticsUpdated(any(StatisticsUpdateEvent.class));
		assertEquals(0, actionUnderTest.getActionMenus().get(0).getHealth().getLife());
		assertEquals(false, actionUnderTest.getActionMenus().get(0).isAlive());
		assertEquals(20, player.getXp().get());
		assertEquals("You defeated House1. XP increased by 10.", GameContextHolder.getContext().getActiveAction().getMenuName());
	}
}
