package tp.p1.objects;

import tp.p1.game.Game;

public abstract class GameObject {
	private int healthPoints;
	private int frequency;
	private int x;
	private int y;
	private Game game;
	
	public GameObject(int x, int y, int healthPoints,int frequency, Game game) {
		this.x=x;
		this.y=y;
		this.healthPoints=healthPoints;
		this.frequency=frequency;
		this.game=game;
	}
	
	public abstract void update();
	public void decreaseHealth(int damage)
	{
		healthPoints -= damage;
	}
	public String toString() {
		return String.valueOf(healthPoints);
	}
	
}
