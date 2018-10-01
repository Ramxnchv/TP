package tp.p1.game;

import tp.p1.lists.*;

public class Game {
	ZombieList zombieList;
	PeaShooterList peashooterList;
	SunFlowerList sunflowerList;
	LEVEL level;
	int seed;
	public Game(LEVEL level,int seed) {
		this.level=level;
		this.seed=seed;
	}
	public void update() {
		
	}
	public LEVEL getLevel() {
		return level;
	}
	
}
