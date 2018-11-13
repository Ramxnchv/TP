package tp.p1.plants;

import tp.p1.game.Game;
import tp.p1.objects.Plant;

public class PeaShooter extends Plant {

	private final static int damage=1;
	
	public PeaShooter(int x, int y,Game game) {
		//x,y,healthPoints,frequency,cost,game
		super(x,y,3,1,50,game);
	}
	
	public PeaShooter() {
		//para avaiablePlants
		super(0,0,3,1,50,null);
	}
	
	public void update() {
		game.attackZombie("Peashooter",x,y);
	}
	
	
	public String toString()
	{	
		String str =  "P [" + this.healthPoints + "]";
		
		return str;
	}
	
	
	public static int getDamage() {
		return damage;
	}
}