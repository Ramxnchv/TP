package tp.p1.zombies;

import tp.p1.lists.ZombieList;
import tp.p1.game.Game;
import tp.p1.game.LEVEL;

public class ZombieManager {
	Game game;
	ZombieList zombieList;
	int zombiesRestantes;
	LEVEL nivel;
	
	public ZombieManager(Game game,ZombieList zombielist) {
		this.zombieList=zombielist;
		this.game=game;
	}
	
	public boolean isZombieAdded(int rand) {
		return rand < game.getLevel().getFrecuencia();
	}
}
