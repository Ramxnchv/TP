package tp.p1.game;

import tp.p1.lists.*;
import tp.p1.zombies.ZombieManager;

public class Game {
	//atributos
	private ZombieList zombieList;
	private PeaShooterList peashooterList;
	private SunFlowerList sunflowerList;
	private LEVEL level;
	private int seed;
	private int numCiclos;
	private SunCoinManager suncoins;
	private GamePrinter gamePrinter;
	private ZombieManager zombieManager;
	private int zombiesLeftAlive;
	
	//constuctor
	public Game(LEVEL level,int seed) {
		this.level=level;
		this.seed=seed;
		this.inicializar();
	}
	
	//metodos principales
	public void update() {
		//recolectar girasol
		sunflowerList.update();
		//disparar lanzaguisantes
		peashooterList.update();
		//avanzar y atacar zombies
		zombieList.update();

		//limpiar sin vida
		this.eliminarSinVida();
	}
	
	public void inicializar() {
		zombieList =new ZombieList();
		peashooterList=new PeaShooterList();
		sunflowerList=new SunFlowerList();
		numCiclos=0;
		this.gamePrinter=new GamePrinter(this,4,8);
		this.suncoins=new SunCoinManager(this);
		suncoins.setSunCoins(50);
		this.zombieManager=new ZombieManager(this);
	}
	
	public String toString() {
		String salida1="Number of cycles: "+numCiclos;
		String salida2="\nSun coins: "+suncoins.getSunCoins();
		String salida3="\nRemaining zombies: "+zombieManager.getZombiesRestantes();
		
		return salida1+salida2+salida3+gamePrinter.toString();
	}
	
	
	public boolean checkEmpty(int x,int y) {
		boolean empty = false;
		
		if(!peashooterList.checkPeashooter(x, y) && !sunflowerList.checkSunflower(x, y) && !zombieList.checkZombie(x, y)) {
			empty = true;
		}
		return empty;
	}
	
	public void eliminarSinVida() {
		System.out.println("Los zombies vivos antes de eliminar sin vida son: " + zombieManager.getZombiesRestantesVivos());
		if(zombieList.Delete())
			zombieManager.setZombiesRestantesVivos(zombieManager.getZombiesRestantesVivos()-1);
		System.out.println("Los zombies vivos despues de eliminar son: " + zombieManager.getZombiesRestantesVivos());
		sunflowerList.Delete();
		peashooterList.Delete();
	}
	public void attackZombie(int x, int y, int damage) {
		
		int i = 0, position;
		
		//recorremos las columnas en busca ed un zombie
		while (i < 8 && !zombieList.checkZombie(x, y))
		{
			y++;
			if(zombieList.checkZombie(x,y))
			{
				position = zombieList.searchPosition(x,y);
				zombieList.decreaseHealth(position, damage);
			}
			i++;
		}
	}
	
	public boolean checkWinnerZombie()
	{
		boolean found = false;;
		if(zombieList.checkWinnerZombie())
			found = true;
		return found;
	}
	
	public void attackPlant(int x, int y, int damage) {
		int i = 0;
		if(sunflowerList.checkSunflower(x, y))
		{
			i = sunflowerList.searchPosition(x, y);
			sunflowerList.decreaseHealth(i, x, y, damage);
		}
		else 
		{
			i = peashooterList.searchPosition(x, y);
			peashooterList.decreaseHealth(i, x, y, damage);
		}
		
		/*public void atacar() {
		for(int i=0;i<game.getZombieList().getContador();i++) {
			for(int j=0;j<game.getSunflowerList().getContador();j++) {
				if(game.getZombieList().getZombie(i).getY()-1==game.getSunflowerList().getSunFlower(j).getY()) {
					game.getSunflowerList().getSunFlower(j).setHealthPoints(game.getSunflowerList().getSunFlower(j).getHealthPoints()-game.getZombieList().getZombie(i).getDamage());
				}
			}
			for(int k=0;k<game.getPeashooterList().getContador();k++) {
				if(game.getZombieList().getZombie(i).getY()-1==game.getPeashooterList().getPeaShooter(k).getY()) {
					game.getPeashooterList().getPeaShooter(k).setHealthPoints(game.getPeashooterList().getPeaShooter(k).getHealthPoints()-game.getZombieList().getZombie(i).getDamage());	
				}
			}
		}
	}*/
	}
	
		
	public String getObject(int x, int y)
	{
		String str;
		int i;
		if(peashooterList.checkPeashooter(x, y))
		{
			i = peashooterList.searchPosition(x, y);
			str = peashooterList.printPosition(i);
		} else if (sunflowerList.checkSunflower(x, y))
		{
			i = sunflowerList.searchPosition(x, y);
			str = sunflowerList.printPosition(i);
		} else if (zombieList.checkZombie(x, y))
		{
			i = zombieList.searchPosition(x, y);
			str = zombieList.printPosition(i);
		} else {
			str = " ";
		}
		return str;
	}
	
	
	
	//getters y setters
	public LEVEL getLevel() {
		return level;
	}
	public ZombieList getZombieList() {
		return zombieList;
	}
	
	public void setGamePrinter(GamePrinter gamePrinter) {
		this.gamePrinter = gamePrinter;
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

	public int getZombiesLeftAlive() {
		return zombiesLeftAlive;
	}

	public void setZombiesLeftAlive(int zombiesLeftAlive) {
		this.zombiesLeftAlive = zombiesLeftAlive;
	}
	
	
		
	
}