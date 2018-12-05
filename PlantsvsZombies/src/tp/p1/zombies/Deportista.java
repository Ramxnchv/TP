package tp.p1.zombies;

import tp.p1.game.Game;
import tp.p1.objects.Zombie;

public class Deportista extends Zombie{

	public Deportista(int x, int y, Game game) {
		//x,y,healthPoints,frequency,damage,speed,game
		super("X",x,y,2,1,1,1,game);
	}

	public Deportista() {
		//para avaiableZombies
		super("X",0,0,2,1,1,1,null);
	}


	public String toString()
	{
		String 	str = "X ["  + this.healthPoints + "]";

		return str;
	}
	public String printInfo() {
	String str = "X [l:" + this.healthPoints + ",x:" + this.getX() + ",y:" + this.getY() + ",t:"+ timeToNextAction() + " ]";

	return str;
	}

	public void store(BufferedWriter bw) throws IOException {
	bw.write(symbol + ":" + healthPoints + ":" + x + ":" + y + timeToNextAction());

	}
}
