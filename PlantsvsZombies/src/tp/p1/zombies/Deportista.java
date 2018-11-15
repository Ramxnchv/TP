package tp.p1.zombies;

import tp.p1.game.Game;
import tp.p1.objects.Zombie;

public class Deportista extends Zombie{
	
	public Deportista(int x, int y, Game game) {
		//x,y,healthPoints,frequency,damage,speed,game
		super(x,y,2,1,1,1,game);
	}
	
	public Deportista() {
		//para avaiableZombies
		super(0,0,2,1,1,1,null);
	}
	
	
	public String toString()
	{
		String 	str = "X ["  + this.healthPoints + "]";
		
		return str;
	}
}
