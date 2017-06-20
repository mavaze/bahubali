package com.mavaze.puzzles.bahubali.thrones.topic;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.domain.Entity;
import com.mavaze.puzzles.bahubali.core.layout.Layout;
import com.mavaze.puzzles.bahubali.core.layout.MapLayout;
import com.mavaze.puzzles.bahubali.core.topic.Topic;
import com.mavaze.puzzles.bahubali.thrones.character.BaratheonHouse;
import com.mavaze.puzzles.bahubali.thrones.character.LannisterHouse;
import com.mavaze.puzzles.bahubali.thrones.character.MormontHouse;
import com.mavaze.puzzles.bahubali.thrones.character.TargaryenHouse;
import com.mavaze.puzzles.bahubali.thrones.character.TullyHouse;
import com.mavaze.puzzles.bahubali.thrones.character.VelaryonHouse;
import com.mavaze.puzzles.bahubali.thrones.command.ClashWithHouseAction;
import com.mavaze.puzzles.bahubali.thrones.command.WanderKingdomAction;
import com.mavaze.puzzles.bahubali.thrones.entity.CasterlyRock;
import com.mavaze.puzzles.bahubali.thrones.entity.CastleBlack;
import com.mavaze.puzzles.bahubali.thrones.entity.Dragonstone;
import com.mavaze.puzzles.bahubali.thrones.entity.Highgarden;
import com.mavaze.puzzles.bahubali.thrones.entity.RedKeep;
import com.mavaze.puzzles.bahubali.thrones.entity.TheWall;
import com.mavaze.puzzles.bahubali.thrones.entity.Winterfall;

public class ThronesTopic implements Topic {
		
	private MapLayout mapLayout;
	
	private List<Entity> entities;
	
	private List<Action> playerActions;

	@Override
	public String getMenuName() {
		return "Game of Thrones";
	}
	
	public ThronesTopic() {
		mapLayout = new ThronesMapLayout(51, 0, 100, 48);
		
		// Register different places and houses (characters)
		entities = new ArrayList<Entity>();
		registerPlaces();
		registerHouses();
		
		// Register player actions
		playerActions = new ArrayList<>();
		registerPlayerActions();
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
	public List<Entity> getEntities() {
		return entities;
	}

	@Override
	public List<Action> getPlayerActions() {
		return playerActions;
	}

}