package tp.p1.plants;

import tp.p1.game.Game;

public class SunFlower {
	private static final int cost = 20;
	private static final int damage = 0;
	private int healthPoints = 1;
	private int frequency = 10;
	private int x;
	private int y;
	private Game game;
	
	
	public SunFlower(int x,int y, Game game) {
	this.x=x;
	this.y=y;
	this.game=game;
	}

	public int recolectar(int suncoins) {
		return suncoins+=10;
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

	public static int getCost() {
		return cost;
	}
	
	public static int getDamage() {
		return damage;
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
}
