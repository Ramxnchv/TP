package tp.p1.zombies;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p1.game.Game;
import tp.p1.objects.Zombie;

public class Caracubo extends Zombie {

	public Caracubo(int x, int y, Game game) {
		//x,y,healthPoints,frequency,damage,timeAction,speed,game
		super(x,y,8,4,1,8,1,game);
	}

	public Caracubo() {
		//para avaiableZombies
		super(0,0,8,4,1,8,1,null);
	}

	public String toString()
	{
		String 	str = "W" + " ["  + this.healthPoints + "]";

		return str;
	}

	public String printInfo() {
	String str = "W" + " [l:" + this.healthPoints + ",x:" + this.getX() + ",y:" + this.getY() + ",t:"+ timeToNextAction() + " ]";

	return str;
	}

	@Override
	public void store(BufferedWriter bw) throws IOException {
		bw.write("W" + ":" + healthPoints + ":" + x + ":" + y + ":" + timeToNextAction() + ", ");
	}



}
