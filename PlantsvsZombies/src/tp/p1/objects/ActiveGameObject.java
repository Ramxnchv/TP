package tp.p1.objects;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p1.game.Game;

public abstract class ActiveGameObject extends GameObject {
	protected int healthPoints;
	protected int frequency;
	protected int timeToNextAction;
	protected String symbol;


	public ActiveGameObject(int x, int y,  int healthPoints, int frequency, int timeToNextAction, Game game) {
		super(x, y, game);
		this.healthPoints = healthPoints;
		this.frequency = frequency;
		this.timeToNextAction = timeToNextAction;
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

	public int getTimeToNextAction() {
		return timeToNextAction;
	}

	public void setTimeToNextAction(int timeToNextAction) {
		this.timeToNextAction = timeToNextAction;
	}
	
}
