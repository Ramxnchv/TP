package tp.p1.plants;

import tp.p1.game.Game;
import tp.p1.objects.Plant;

public class PetaCereza extends Plant {
	private final static int damage=10;
	private int internalCycle;
	
	public PetaCereza(int x, int y, Game game) {
		//x,y,healthPoints,frequency,cost,game
		super(x,y,2,2,50,game);
		this.internalCycle=0;
	}
	
	public PetaCereza() {
		//para avaiablePlants
		super(0,0,2,2,50,null);
	}
	
	public void update() {
		if(internalCycle==frequency) {
			game.attackZombie("PetaCereza",x,y);
			healthPoints=0;
		}
		else {
			this.internalCycle++;
		}
	}
	
	public String toString()
	{
		String str = "C [" + this.healthPoints + "]";
		
		return str;
	}

	public static int getDamage() {
		return damage;
	}
	
}
