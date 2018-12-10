package tp.p1.plants;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p1.game.Game;
import tp.p1.objects.Plant;

public class PeaShooter extends Plant {

	private final static int damage=1;

	public PeaShooter(int x, int y,Game game) {
		//x,y,healthPoints,frequency,timeToAction,cost,game
		super("P",x,y,3,1,1,50,game);
		name="PeaShooter";
	}

	public PeaShooter() {
		//para avaiablePlants
		super("P",0,0,3,1,1,50,null);
	}

	public void update() {
		int i = 0;
		//recorremos las columnas en busca de un zombie
		while (i < game.getCOLUMNAS() && !game.checkZombie(x, i))
		{
			i++;
		}
		//si sale porque encuentra un zombie -> dispara
		if(game.checkZombie(x,i))
		{
			game.decreaseHealthZombie(x,i,PeaShooter.getDamage());
		}
	}


	public String toString()
	{
		String str =  "P [" + this.healthPoints + "]";

		return str;
	}


	public static int getDamage() {
		return damage;
	}

	public String printInfo() {
	String str = "P [l:" + this.healthPoints + ",x:" + this.getX() + ",y:" + this.getY() + ",t:"+ "1 ]";

	return str;
	}

	@Override
	public void store(BufferedWriter bw) throws IOException {

		bw.write("P" + ":" + healthPoints + ":" + x + ":" + y + ":" + 1 + ", ");

	}
}
