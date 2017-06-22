package com.mavaze.puzzles.bahubali.core.character;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author mayuresh_vaze
 *
 */
public class Health implements Serializable {
	
	private static final long serialVersionUID = -116155433842120219L;

	// A percentage value suggesting the likelyhood of the character being alive
	protected AtomicInteger life;
	
	// Shield lessen the impact of hit on health
	protected int shield;
	
	// A medical kit can increase health by 20% max
	protected int medicalKit;

	public Health(int life, int shield, int medicalKit) {
		this.life = new AtomicInteger(life);
		this.shield = shield;
		this.medicalKit = medicalKit;
	}

	public int getLife() {
		return life.get();
	}
	
	public int damageAndGetLife(int delta) {
		if(life.addAndGet(-delta) <= 0) {
			life.set(0);
		};
		return life.get();
	}

	public int getShield() {
		return shield;
	}

	public int getMedicalKit() {
		return medicalKit;
	}
	
	@Override
	public String toString() {
		return "Health::Life -> " + life + 
				"\nHealth::Shield -> " + shield + 
				"\nHealth::MedicalKit -> " + medicalKit;
		
	}
	
}