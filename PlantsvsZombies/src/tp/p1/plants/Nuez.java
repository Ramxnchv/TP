package tp.p1.plants;

import tp.p1.game.Game;
import tp.p1.objects.Plant;

public class Nuez extends Plant {
	
	public Nuez(int x, int y,Game game) {
		//x,y,healthPoints,frequency,cost,game
		super(x,y,10,1,50,game);
	}
	
	public void update() {
		
	}
	
	public String toString()
	{	
		String str =  "N [" + this.healthPoints + "]";
		
		return str;
	}
}
