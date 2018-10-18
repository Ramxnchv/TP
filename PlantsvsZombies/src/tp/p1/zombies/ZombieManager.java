package tp.p1.zombies;

import tp.p1.lists.ZombieList;
import java.util.Random;
import tp.p1.game.Game;
import tp.p1.game.LEVEL;

public class ZombieManager {
	private Game game;
	private int zombiesRestantes;
	private int zombiesRestantesVivos;
	
	public ZombieManager(Game game) {
		this.game=game;
		this.zombiesRestantes=game.getLevel().getNumeroZombies();
		this.zombiesRestantesVivos=game.getLevel().getNumeroZombies();
	}
	
	public boolean isZombieAdded() {
		Random rand= new Random();
		return rand.nextDouble() < game.getLevel().getFrecuencia();
	}
	
	public boolean zombiGanador() {
		boolean zombiganador=false;
		int i=0;
		while(i<game.getZombieList().getContador() && !zombiganador) {
			if(game.checkWinnerZombie()) {
				zombiganador=true;
			}
			i++;
		}
		return zombiganador;
	}

	public int getZombiesRestantes() {
		return zombiesRestantes;
	}

	public void setZombiesRestantes(int zombiesRestantes) {
		this.zombiesRestantes = zombiesRestantes;
	}

	public int getZombiesRestantesVivos() {
		return zombiesRestantesVivos;
	}

	public void setZombiesRestantesVivos(int zombiesRestantesVivos) {
		this.zombiesRestantesVivos = zombiesRestantesVivos;
	}

	
}