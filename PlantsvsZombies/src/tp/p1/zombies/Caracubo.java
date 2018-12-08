package tp.p1.zombies;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p1.game.Game;
import tp.p1.objects.Zombie;

public class Caracubo extends Zombie {

	public Caracubo(int x, int y, Game game) {
		//x,y,healthPoints,frequency,damage,timeAction,speed,game
		super("W",x,y,8,4,1,8,1,game);
	}

	public Caracubo() {
		//para avaiableZombies
		super("W",0,0,8,4,1,8,1,null);
	}

	public String toString()
	{
		String 	str = symbol + " ["  + this.healthPoints + "]";

		return str;
	}

	public String printInfo() {
	String str = symbol + " [l:" + this.healthPoints + ",x:" + this.getX() + ",y:" + this.getY() + ",t:"+ timeToNextAction() + " ]";

	return str;
	}

	@Override
	public void store(BufferedWriter bw) throws IOException {
		bw.write(symbol + ":" + healthPoints + ":" + x + ":" + y + ":" + timeToNextAction() + ", ");
	}



}
