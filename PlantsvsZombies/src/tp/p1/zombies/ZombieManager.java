package tp.p1.zombies;

import tp.p1.lists.ZombieList;
import tp.p1.game.Game;
import tp.p1.game.LEVEL;

public class ZombieManager {
	private Game game;
	private int zombiesRestantes;
	private LEVEL nivel;
	
	public ZombieManager(Game game) {
		this.game=game;
	}
	
	public boolean isZombieAdded(int rand) {
		return rand < game.getLevel().getFrecuencia();
	}

	public int getZombiesRestantes() {
		return zombiesRestantes;
	}

	public void setZombiesRestantes(int zombiesRestantes) {
		this.zombiesRestantes = zombiesRestantes;
	}
	
}
