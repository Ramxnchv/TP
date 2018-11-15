package tp.p1.zombies;

import tp.p1.game.Game;
import tp.p1.objects.Zombie;

public class Caracubo extends Zombie {
	
	public Caracubo(int x, int y, Game game) {
		//x,y,healthPoints,frequency,damage,speed,game
		super(x,y,8,4,1,1,game);
	}
	
	public Caracubo() {
		//para avaiableZombies
		super(0,0,8,4,1,1,null);
	}
	
	public String toString()
	{
		String 	str = "W ["  + this.healthPoints + "]";
		
		return str;
	}
}
