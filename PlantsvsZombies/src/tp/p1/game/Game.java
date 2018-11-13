package tp.p1.game;

import java.util.Random;

import tp.p1.command.CommandParser;
import tp.p1.lists.*;
import tp.p1.objects.Plant;
import tp.p1.plants.*;
import tp.p1.zombies.ZombieManager;

public class Game {
	//atributos
	private ZombieList zombieList;
	private PlantList plantList;
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
		//actualizar plantas
		plantList.update();

		//avanzar y atacar zombies
		zombieList.update();

		//limpiar sin vida
		this.eliminarSinVida();
	}

	public void inicializar() {
		zombieList =new ZombieList();
		plantList=new PlantList();
		numCiclos=0;
		this.gamePrinter=new GamePrinter(this,FILAS,COLUMNAS);
		this.suncoins=new SunCoinManager(this);
		suncoins.setSunCoins(50);
		this.zombieManager=new ZombieManager(this);
	}

	public String toString() {
		StringBuilder sb= new StringBuilder();
		String salida1="Number of cycles: "+numCiclos;
		String salida2="\nSun coins: "+suncoins.getSunCoins();
		String salida3="\nRemaining zombies: "+zombieManager.getZombiesRestantes();
		return sb.append(salida1).append(salida2).append(salida3).append(gamePrinter.toString()).toString();
	}


	private boolean checkEmpty(int x,int y) {
		boolean empty = false;

		if(!peashooterList.checkPeashooter(x, y) && !sunflowerList.checkSunflower(x, y) && !zombieList.checkZombie(x, y)) {
			empty = true;
		}
		return empty;
	}
	
	public void eliminarSinVida() {
		if(zombieList.Delete())
			zombieManager.setZombiesRestantesVivos(zombieManager.getZombiesRestantesVivos()-1);
		plantList.Delete();
	}

	private boolean comprobarDentroTablero(int x, int y) {
		//solo permite poner plantas hasta la penultima columna
		return x >=0 && x<FILAS && y >=0 && y <COLUMNAS-1;
	}

	public void attackZombiePS(int x, int damage) {

		int i = 0;

		//recorremos las columnas en busca de un zombie
		while (i < COLUMNAS && !zombieList.checkZombie(x, i))
		{
			i++;
		}
		//si sale porque encuentra un zombie -> dispara
		if(zombieList.checkZombie(x,i))
		{
			zombieList.decreaseHealth(x, i, damage);
		}
	}

	public void attackZombiePetaCereza(int x,int y) {
		//atacar zombies en la coordenadas que rodean a (x,y)
		//eliminar petacereza (poner su vida a 0)
	}

	public boolean checkWinnerZombie()
	{
		boolean found = false;
		if(zombieList.checkWinnerZombie())
			found = true;
		return found;
	}


	public void addCycle() {
		this.numCiclos++;
	}


	public String getObject(int x, int y)
	{
		String str;

		if(plantList.checkPlantToPrint(x, y))
		{
			str = plantList.printPosition(x, y);
		}
		else if (zombieList.checkZombie(x, y))
		{
			str = zombieList.printPosition(x, y);
		}
		else {
			str = " ";
		}
		return str;
	}

	public boolean isNotFinished() {
		return zombieManager.getZombiesRestantesVivos() > 0 && !zombieManager.zombiGanador();
	}

	public void addZombieAction() {
		int filaZombie= rand.nextInt(FILAS-1);
		if(zombieManager.isZombieAdded()&&checkEmpty(filaZombie,COLUMNAS-1)) {
			addZombie(filaZombie, COLUMNAS-1);
			decreaseZombiesLeft();
		}
	}

	public void addPlantToGame(String plantName, int x, int y)
	{
		
		if(comprobarDentroTablero(x, y) && checkEmpty(x,y)) {
			if(enoughMoney(plantName)) {
				Plant plant = PlantFactory.getPlant(plantName, x, y, this);
				plantList.Add(x,y,plant,this);
			}
		}
	}
	
	public boolean enoughMoney(String plantName) {
		boolean enough;
		if (plantName.equals("peashooter") && (suncoins.getSunCoins() >= PeaShooter.getCost())) {
			enough = true;
		} else if (plantName.equals("petacereza") && (suncoins.getSunCoins() >= PetaCereza.getCost())){
			enough = true;
		} else if (plantName.equals("sunflower") && (suncoins.getSunCoins() >= SunFlower.getCost())) {
			enough = true;
		} else if (plantName.equals("nuez") && (suncoins.getSunCoins() >= Nuez.getCost())) {
			enough = true;
		} else {
			enough = false;
		}
		
		return enough;
				
	}

	public void addZombie(int x, int y) {
		zombieList.Add(x, y, this);
	}

	public void decreaseZombiesLeft()
	{
		zombieManager.decreaseZombiesLeft();
	}

	public void decreaseSuncoins(int cost)
	{

		suncoins.decreaseSuncoins(cost);
	}

	public boolean checkZombie(int x, int y){

		return zombieList.checkZombie(x,  y);
	}

	public int getNumZombiesLista()
	{
		return zombieList.getContador();
	}

	public int getNumPlantasLista()
	{

		return plantList.getContador();
	}


	//getters y setters
	public LEVEL getLevel() {
		return level;
	}

	public void setGamePrinter(GamePrinter gamePrinter) {
		this.gamePrinter = gamePrinter;
	}

	public int getFILAS() {
		return FILAS;
	}

	public int getCOLUMNAS() {
		return COLUMNAS;
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

	public ZombieManager getZombieManager() {
		return zombieManager;
	}

	//aÃ±adido nuevo p2
	public static void commandHelp() {
		CommandParser.commandHelp();
	}

	public String printList() {
		return PlantFactory.listOfAvaiablePlants();
	}



	public boolean setExitTrue(boolean exit)
	{
		return exit = true;
	}

	public void executeNoneCommand()
	{
		//computer action
		this.addZombieAction();
		//aniadir ciclo
		this.addCycle();
	}
}

