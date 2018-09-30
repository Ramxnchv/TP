package tp.p1.plants;

import tp.p1.game.Game;

public class PeaShooter {
	private int cost = 50;
	private int healthPoints = 3;
	private int frequency = 1;
	private int damage = 1;
	private int x;
	private int y;
	private Game game;
	
	public PeaShooter(int x, int y,Game game) {
		this.x=x;
		this.y=y;
		this.game=game;
	}
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCost() {
		return cost;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}


	public int getFrequency() {
		return frequency;
	}

	public int getDamage() {
		return damage;
	}
}
