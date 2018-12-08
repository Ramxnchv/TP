package tp.p1.plants;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p1.game.Game;
import tp.p1.objects.Plant;

public class PetaCereza extends Plant {
	private final static int damage=10;
	private int internalCycle;

	public PetaCereza(int x, int y, Game game) {
		//x,y,healthPoints,frequency,timeAction,cost,game
		super("C",x,y,2,2,2,50,game);
		this.internalCycle=0;
	}

	public PetaCereza() {
		//para avaiablePlants
		super("C",0,0,2,2,2,50,null);
		name="PetaCereza";
	}

	public void update() {
		if(internalCycle==frequency) {
			//comprueba coordenada dentro tablero y comprueba que haya zombie para atacarlo con la explosion

			for(int i=y-1;i<y+2;i++) {
				if(game.comprobarDamagePetaCereza(x-1,i)) {
					if(game.checkZombie(x-1,i)) {
						game.decreaseHealthZombie(x-1, i, PetaCereza.getDamage());
					}
				}
			}
			for(int i=y-1;i<y+2;i++) {
				if(game.comprobarDamagePetaCereza(x,i)) {
					if(game.checkZombie(x,i)) {
						game.decreaseHealthZombie(x, i, PetaCereza.getDamage());
					}
				}
			}
			for(int i=y-1;i<y+2;i++) {
				if(game.comprobarDamagePetaCereza(x+1,i)) {
					if(game.checkZombie(x+1,i)) {
						game.decreaseHealthZombie(x+1, i, PetaCereza.getDamage());
					}
				}
			}

			healthPoints=0;

		}
		else {
			this.internalCycle++;
		}
	}

	public String toString()
	{
		String str = "C [" + this.healthPoints + "]";

		return str;
	}

	public static int getDamage() {
		return damage;
	}
	public String printInfo() {
	String str = "C [l:" + this.healthPoints + ",x:" + this.getX() + ",y:" + this.getY() + ",t:"+ timeToNextAction() + " ]";

	return str;
	}

	private int timeToNextAction() {
		return frequency-internalCycle;
	}

	@Override
	public void store(BufferedWriter bw) throws IOException {

		bw.write(symbol + ":" + healthPoints + ":" + x + ":" + y + ":" + timeToNextAction() + ", ");

	}

}
