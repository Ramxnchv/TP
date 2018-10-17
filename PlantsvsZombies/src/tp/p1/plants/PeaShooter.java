package tp.p1.plants;

import tp.p1.game.Game;
import tp.p1.lists.ZombieList;
import tp.p1.zombies.Zombie;

public class PeaShooter {
	private final static int cost = 50;
	private int healthPoints = 3;
	private int frequency = 1;
	private final static int damage = 1;
	private int x;
	private int y;
	private Game game;
	
	public PeaShooter(int x, int y,Game game) {
		this.x=x;
		this.y=y;
		this.game=game;
	}
	
	public void disparar() {
		for(int i=0;i<game.getZombieList().getContador();i++) {
			if(this.x==game.getZombieList().getZombie(i).getX()) {
				game.getZombieList().getZombie(i).setHealthPoints(game.getZombieList().getZombie(i).getHealthPoints());
			}
		}			
	}
	

	public String toString()
	{	
		String str =  "P [" + this.healthPoints + "]";
		
		return str;
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

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}


	public int getFrequency() {
		return frequency;
	}

	public static int getDamage() {
		return damage;
	}
}