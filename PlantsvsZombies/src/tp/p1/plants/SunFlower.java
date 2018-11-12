package tp.p1.plants;

import tp.p1.game.Game;
import tp.p1.objects.Plant;

public class SunFlower extends Plant {
	private int internalCycle;
	private final int cantidadRecolectada = 10;
	
	
	public SunFlower(int x,int y, Game game) {
		//x,y,healthPoints,frequency,cost,game
		super(x,y,1,2,20,game);
		this.internalCycle=0;
	}
	
	public void update() {	
		if((internalCycle != 0) && (internalCycle%frequency==0))
			game.getSuncoins().setSunCoins(game.getSuncoins().getSunCoins()+cantidadRecolectada);
		this.internalCycle+=1;
	}
	
	public String toString()
	{
		String str = "S [" + this.healthPoints + "]";
		
		return str;
	}
	
}
