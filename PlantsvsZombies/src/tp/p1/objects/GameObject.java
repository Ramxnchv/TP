package tp.p1.objects;

import tp.p1.game.Game;

public abstract class GameObject {
	protected int healthPoints;
	protected int frequency;
	protected int x;
	protected int y;
	protected Game game;

	public GameObject(int x, int y, int healthPoints,int frequency, Game game) {
		this.x=x;
		this.y=y;
		this.healthPoints=healthPoints;
		this.frequency=frequency;
		this.game=game;
	}

	public abstract void update();
	public abstract String printInfo();

	public void decreaseHealth(int damage)
	{
		healthPoints -= damage;
	}

	//getters y setters
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
