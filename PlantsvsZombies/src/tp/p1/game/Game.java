package tp.p1.game;

import tp.p1.lists.*;
import tp.p1.zombies.ZombieManager;

public class Game {
	private final int BOARD_SIZE=32;
	private Game game;
	private ZombieList zombieList;
	private PeaShooterList peashooterList;
	private SunFlowerList sunflowerList;
	private LEVEL level;
	private int seed;
	private int numCiclos;
	private SunCoinManager suncoins;
	private GamePrinter gamePrinter;
	private ZombieManager zombieManager;
	
	
	public Game(LEVEL level,int seed) {
		this.level=level;
		this.seed=seed;
		inicializar();
	}
	
	public void update() {
		
	}
	
	public void inicializar() {
		zombieList =new ZombieList();
		peashooterList=new PeaShooterList();
		sunflowerList=new SunFlowerList();
		numCiclos=0;
		this.suncoins=new SunCoinManager(this.game);
		suncoins.setSunCoins(50);
		this.zombieManager=new ZombieManager(this.game);
		zombieManager.setZombiesRestantes(zombieManager.getZombiesRestantes());
	}
	
	public String toString() {
		String salida1="Number of cycles: "+numCiclos;
		String salida2="\nSun coins: "+suncoins.getSunCoins();
		String salida3="\nRemaining zombies: "+zombieManager.getZombiesRestantes();
		
		return salida1+salida2+salida3+gamePrinter.toString();
	}
	
	
	public boolean checkEmpty(int x,int y) {
		if(zombieList.searchPosition(x, y))
		return true;
	}
	
	public LEVEL getLevel() {
		return level;
	}
	public ZombieList getZombieList() {
		return zombieList;
	}
	
	public PeaShooterList getPeashooterList() {
		return peashooterList;
	}
	
	public SunFlowerList getSunflowerList() {
		return sunflowerList;
	}

	public int getSeed() {
		return seed;
	}

	public int getNumCiclos() {
		return numCiclos;
	}

	public void setNumCiclos(int numCiclos) {
		this.numCiclos = numCiclos;
	}

	public SunCoinManager getSuncoins() {
		return suncoins;
	}

	public void setSuncoins(SunCoinManager suncoins) {
		this.suncoins = suncoins;
	}

	public GamePrinter getGamePrinter() {
		return gamePrinter;
	}

	public ZombieManager getZombieManager() {
		return zombieManager;
	}
		
}
