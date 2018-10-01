package tp.p1.zombies;

import tp.p1.game.Game;

public class Zombie {
	private int healthPoints = 5;
	private int speed=1;
	private int damage=1;
	private int x;
	private int y;
	private Game game;
	
	public Zombie(int x,int y,Game game) {
		this.x=x;
		this.y=y;
		this.game=game;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
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

	public int getSpeed() {
		return speed;
	}

	public int getDamage() {
		return damage;
	}
}
