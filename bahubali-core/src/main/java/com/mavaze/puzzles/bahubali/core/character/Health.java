package com.mavaze.puzzles.bahubali.core.character;

import java.io.Serializable;

/**
 * 
 * @author mayuresh_vaze
 *
 */
public class Health implements Serializable {
	
	private static final long serialVersionUID = -116155433842120219L;

	// A percentage value suggesting the likelyhood of the character being alive
	protected int life;
	
	// Shield lessen the impact of hit on health
	protected int shield;
	
	// A medical kit can increase health by 20% max
	protected int medicalKit;

	public Health(int life, int shield, int medicalKit) {
		this.life = life;
		this.shield = shield;
		this.medicalKit = medicalKit;
	}

	public int getLife() {
		return life;
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