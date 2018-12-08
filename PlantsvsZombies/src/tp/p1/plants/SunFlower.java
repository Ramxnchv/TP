package tp.p1.plants;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p1.game.Game;
import tp.p1.objects.Plant;

public class SunFlower extends Plant {
	private int internalCycle;

	public SunFlower(int x,int y, Game game) {
		//x,y,healthPoints,frequency,cost,game
		super("S",x,y,1,2,2,20,game);
		this.internalCycle=0;
	}

	public SunFlower() {
		//para avaiablePlants
		super("S",0,0,1,2,2,20,null);
		name="SunFlower";
	}

	public void update() {
		internalCycle++;
		if(timeToNextAction() == 0) {
			game.addSun(x,y);
		}
	}

	public String toString()
	{
		String str = "S [" + this.healthPoints + "]";

		return str;
	}

	public String printInfo() {
	String str = "S [l:" + this.healthPoints + ",x:" + this.getX() + ",y:" + this.getY() + ",t:"+ timeToNextAction() + " ]";

	return str;
	}

	public int timeToNextAction() {
		if(frequency-internalCycle == -1) {
			internalCycle = 0;
		}
		return frequency-internalCycle;
	}

	@Override
	public void store(BufferedWriter bw) throws IOException {
		bw.write(symbol + ":" + healthPoints + ":" + x + ":" + y + ":" + timeToNextAction() + ", ");

	}


}
