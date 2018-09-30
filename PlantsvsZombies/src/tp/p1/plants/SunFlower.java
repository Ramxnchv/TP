package tp.p1.plants;

import tp.p1.game.Game;

public class SunFlower {
	private int cost = 20;
	private int healthPoints = 1;
	private int frequency = 10;
	private int damage = 0;
	private int x;
	private int y;
	private Game game;
	
	
	public SunFlower(int x,int y, Game game) {
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
