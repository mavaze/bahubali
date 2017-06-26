package com.mavaze.puzzles.bahubali.thrones.topic;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.actions.Action;
import com.mavaze.puzzles.bahubali.core.domain.GameEntity;
import com.mavaze.puzzles.bahubali.core.layout.Layout;
import com.mavaze.puzzles.bahubali.core.layout.MapLayout;
import com.mavaze.puzzles.bahubali.core.topic.Topic;
import com.mavaze.puzzles.bahubali.thrones.actions.ClashWithHouseAction;
import com.mavaze.puzzles.bahubali.thrones.actions.WanderKingdomAction;
import com.mavaze.puzzles.bahubali.thrones.character.BaratheonHouse;
import com.mavaze.puzzles.bahubali.thrones.character.LannisterHouse;
import com.mavaze.puzzles.bahubali.thrones.character.MormontHouse;
import com.mavaze.puzzles.bahubali.thrones.character.TargaryenHouse;
import com.mavaze.puzzles.bahubali.thrones.character.TullyHouse;
import com.mavaze.puzzles.bahubali.thrones.character.VelaryonHouse;
import com.mavaze.puzzles.bahubali.thrones.entity.CasterlyRock;
import com.mavaze.puzzles.bahubali.thrones.entity.CastleBlack;
import com.mavaze.puzzles.bahubali.thrones.entity.Dragonstone;
import com.mavaze.puzzles.bahubali.thrones.entity.Highgarden;
import com.mavaze.puzzles.bahubali.thrones.entity.RedKeep;
import com.mavaze.puzzles.bahubali.thrones.entity.TheWall;
import com.mavaze.puzzles.bahubali.thrones.entity.Winterfall;

public class ThronesTopic implements Topic {
		
	private static final long serialVersionUID = -1299431477035090705L;

	private MapLayout mapLayout;
	
	private List<GameEntity> entities;
	
	private List<Action> playerActions;
	
	public ThronesTopic() {
		mapLayout = new ThronesMapLayout(81, 0, 180, 48);
		
		// Register different places and houses (characters)
		entities = new ArrayList<>();
		registerPlaces();
		registerHouses();
		
		// Register player actions
		playerActions = new ArrayList<>();
		registerPlayerActions();
	}
	
	@Override
	public String getMenuName() {
		return "Game of Thrones";
	}

	private void registerPlayerActions() {
		playerActions.add(new WanderKingdomAction(entities));
		playerActions.add(new ClashWithHouseAction(entities));
	}
	
	private void registerPlaces() {
		entities.add(new CasterlyRock());
		entities.add(new CastleBlack());
		entities.add(new Dragonstone());
		entities.add(new Highgarden());
		entities.add(new RedKeep());
		entities.add(new TheWall());
		entities.add(new Winterfall());
	}

	private void registerHouses() {
		entities.add(new BaratheonHouse());
		entities.add(new LannisterHouse());
		entities.add(new MormontHouse());
		entities.add(new TargaryenHouse());
		entities.add(new TullyHouse());
		entities.add(new VelaryonHouse());
	}

	@Override
	public Layout getMapLayout() {
		return this.mapLayout;
	}

	@Override
	public List<GameEntity> getEntities() {
		return entities;
	}

	@Override
	public List<Action> getPlayerActions() {
		return playerActions;
	}

}