package tp.p1.plants;

import tp.p1.game.Game;
import tp.p1.objects.Plant;

public class Nuez extends Plant {

	public Nuez(int x, int y,Game game) {
		//x,y,healthPoints,frequency,cost,game
		super(x,y,10,1,50,game);
	}

	public Nuez() {
		//para avaiablePlants
		super(0,0,10,1,50,null);
	}

	public void update() {
		//no realiza update pero se ha de implementar
	}

	public String toString()
	{
		String str =  "N [" + this.healthPoints + "]";

		return str;

	}

	public String printInfo() {
	String str = "N [l:" + this.healthPoints + ",x:" + this.getX() + ",y:" + this.getY() + ",t:"+ "0 ]";
	
	return str;
	}
}
