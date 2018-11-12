package tp.p1.plants;

import tp.p1.game.Game;
import tp.p1.objects.Plant;

public class SunFlower extends Plant {
	private static final int cost = 20;
	private static final int damage = 0;
	private int healthPoints = 1;
	private int internalCycle;
	private int cantidadRecolectada = 10;
	
	
	public SunFlower(int x,int y, Game game) {
		super(x,y,game);
		this.internalCycle=0;
	}
	
	public String toString()
	{
		String str = "S [" + super.toString() + "]";
		
		return str;
	}
	
	public void update() {
		
		if((internalCycle != 0) && (internalCycle%2==0))
			game.getSuncoins().setSunCoins(game.getSuncoins().getSunCoins()+cantidadRecolectada);
		this.internalCycle+=1;
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
	
	public int getInternalCycle() {
		return internalCycle;
	}

	public void setInternalCycle(int internalCycle) {
		this.internalCycle = internalCycle;
	}

	
	
}
