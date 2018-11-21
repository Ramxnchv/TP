package tp.p1.objects;

import tp.p1.game.Game;

public abstract class ActiveGameObject extends GameObject {
	
	protected int healthPoints;
	protected int frequency;
	
	public ActiveGameObject(int x, int y,  int healthPoints, int frequency, Game game) {
		super(x, y, game);
		this.healthPoints = healthPoints;
		this.frequency = frequency;
	}

	public abstract void update();

	public abstract String printInfo();
	
	public void decreaseHealth(int damage)
	{
		healthPoints -= damage;
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
