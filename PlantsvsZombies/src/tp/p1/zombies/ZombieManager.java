package tp.p1.zombies;

import tp.p1.lists.ZombieList;
import java.util.Random;
import tp.p1.game.Game;
import tp.p1.game.LEVEL;

public class ZombieManager {
	private Game game;
	private int zombiesRestantes;
	
	public ZombieManager(Game game) {
		this.game=game;
		this.zombiesRestantes=game.getLevel().getNumeroZombies();
	}
	
	public boolean isZombieAdded() {
		Random rand= new Random();
		return rand.nextDouble() < game.getLevel().getFrecuencia()*game.getSeed();
	}
	
	public boolean zombiGanador() {
		boolean zombiganador=false;
		int i=0;
		while(i<game.getZombieList().getContador() && !zombiganador) {
			if(game.getZombieList().getZombie(i).getY()==0) {
				zombiganador=true;
			}
			else {
			i++;
			}
		}
		return zombiganador;
	}

	public int getZombiesRestantes() {
		return zombiesRestantes;
	}

	public void setZombiesRestantes(int zombiesRestantes) {
		this.zombiesRestantes = zombiesRestantes;
	}
	
}
