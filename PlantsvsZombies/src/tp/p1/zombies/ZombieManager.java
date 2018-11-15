package tp.p1.zombies;


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
		boolean add=false;
		if(zombiesRestantes>0) {
			add=game.getRand().nextDouble() < game.getLevel().getFrecuencia();
		}
		return add;
	}
	
	public boolean zombiGanador() {
		boolean zombiganador=false;
		int i=0;
		while(i<game.getNumZombiesLista() && !zombiganador) {
			if(game.checkWinnerZombie()) {
				zombiganador=true;
			}
			i++;
		}
		return zombiganador;
	}
	
	public void decreaseZombiesLeft()
	{
		zombiesRestantes -= 1;
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
