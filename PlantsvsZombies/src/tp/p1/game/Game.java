package tp.p1.game;

import java.util.Random;

import tp.p1.lists.*;
import tp.p1.zombies.ZombieManager;

public class Game {
	//atributos
	private ZombieList zombieList;
	private PeaShooterList peashooterList;
	private SunFlowerList sunflowerList;
	private LEVEL level;
	private Random rand;
	private int numCiclos;
	private SunCoinManager suncoins;
	private GamePrinter gamePrinter;
	private ZombieManager zombieManager;
	private final int FILAS=4;
	private final int COLUMNAS=8;
	
	//constuctor
	public Game(LEVEL level,Random rand) {
		this.level=level;
		this.rand=rand;
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
		this.gamePrinter=new GamePrinter(this,FILAS,COLUMNAS);
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
		if(zombieList.Delete())
			zombieManager.setZombiesRestantesVivos(zombieManager.getZombiesRestantesVivos()-1);
		sunflowerList.Delete();
		peashooterList.Delete();
	}
	
	public boolean comprobarDentroTablero(String x, String y) {
		return Integer.parseInt(x)>=0 && Integer.parseInt(x)<FILAS && Integer.parseInt(y)>=0 && Integer.parseInt(y)<COLUMNAS;
	}
	
	public void attackZombie(int x, int y, int damage) {
		
		int i = 0;
		
		//recorremos las columnas en busca de un zombie
		while (i < COLUMNAS && !zombieList.checkZombie(x, y))
		{
			y++;
			if(zombieList.checkZombie(x,y))
			{
				zombieList.decreaseHealth(zombieList.searchPosition(x,y), damage);
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
		if(sunflowerList.checkSunflower(x, y))
		{
			sunflowerList.decreaseHealth(sunflowerList.searchPosition(x, y), damage);
		}
		else 
		{
			peashooterList.decreaseHealth(peashooterList.searchPosition(x, y), damage);
		}
	}
	
		
	public String getObject(int x, int y)
	{
		String str;
		
		if(peashooterList.checkPeashooter(x, y))
		{
			str = peashooterList.printPosition(peashooterList.searchPosition(x, y));
		} 
		else if (sunflowerList.checkSunflower(x, y))
		{
			str = sunflowerList.printPosition(sunflowerList.searchPosition(x, y));
		} 
		else if (zombieList.checkZombie(x, y))
		{
			str = zombieList.printPosition(zombieList.searchPosition(x, y));
		} 
		else {
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

	public Random getRand() {
		return rand;
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

	public GamePrinter getGamePrinter() {
		return gamePrinter;
	}

	public ZombieManager getZombieManager() {
		return zombieManager;
	}

	public int getFILAS() {
		return FILAS;
	}

	public int getCOLUMNAS() {
		return COLUMNAS;
	}	
	
}