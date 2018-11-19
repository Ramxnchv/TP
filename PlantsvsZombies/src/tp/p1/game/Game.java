package tp.p1.game;

import java.util.Random;

import tp.p1.command.CommandParser;
import tp.p1.lists.*;
import tp.p1.objects.Plant;
import tp.p1.plants.*;
import tp.p1.printer.GamePrinter;
import tp.p1.printer.Release;
import tp.p1.zombies.ZombieManager;
import tp.p1.objects.Zombie;

public class Game {
	//ATRIBUTOS
	private GameObjectList zombieList;
	private GameObjectList plantList;
	private LEVEL level;
	private Random rand;
	private int seed;
	private int numCiclos;
	private SunCoinManager suncoins;
	private GamePrinter gamePrinter;
	private ZombieManager zombieManager;
	private final int FILAS=4;
	private final int COLUMNAS=8;

	//CONSTRUCTOR
	public Game(LEVEL level,Random rand,int seed) {
		this.level=level;
		this.rand=rand;
		this.seed=seed;
		this.inicializar();
	}

	//UPDATE Y CICLOS
	private void update() {
		//actualizar plantas
		plantList.update();

		//avanzar y atacar zombies
		zombieList.update();

		//limpiar sin vida
		this.eliminarSinVida();
	}

	public void eliminarSinVida() {
		if(zombieList.Delete())
			zombieManager.setZombiesRestantesVivos(zombieManager.getZombiesRestantesVivos()-1);
		plantList.Delete();
	}

	public void addCycle() {
		this.numCiclos++;
	}


	//INICIALIZAR Y RESET
	public void inicializar() {
		zombieList =new GameObjectList();
		plantList=new GameObjectList();
		numCiclos=0;
		this.gamePrinter=new Release(this,FILAS,COLUMNAS);
		this.suncoins=new SunCoinManager(this);
		suncoins.setSunCoins(50);
		this.zombieManager=new ZombieManager(this);
	}


	//PRINT GAME
	public String toString() {
		return gamePrinter.toString();
	}

	public String printPromptRelease() {
		StringBuilder sb= new StringBuilder();
		String salida1="Number of cycles: "+numCiclos;
		String salida2="\nSun coins: "+suncoins.getSunCoins();
		String salida3="\nRemaining zombies: "+zombieManager.getZombiesRestantes();
		return sb.append(salida1).append(salida2).append(salida3).toString();
	}

	public String printPromptDebug() {
		StringBuilder sb= new StringBuilder();
		String salida1="Number of cycles: "+numCiclos;
		String salida2="\nSun coins: "+suncoins.getSunCoins();
		String salida3="\nRemaining zombies: "+zombieManager.getZombiesRestantes();
		String salida4="\nLevel: "+level;
		String salida5="\nSeed: "+seed;
		return sb.append(salida1).append(salida2).append(salida3).toString();
	}

	public void draw() {

		System.out.println(gamePrinter.printGame(this));
	}


	public String getObject(int x, int y)
	{
		String str;

		if(plantList.checkObject(x, y))
		{
			str = plantList.printPosition(x, y);
		}
		else if (zombieList.checkObject(x, y))
		{
			str = zombieList.printPosition(x, y);
		}
		else {
			str = " ";
		}
		return str;
	}

	public String getPlantInfo(int i) {

	String str = plantList.printInfoDebug(i);

	return str;
	}

public String getZombieInfo(int i) {

	String str = plantList.printInfoDebug(i);

	return str;
}



	//ATTACK ZOMBIES Y PLANTAS

	public void attackZombie(String plantName,int x,int y) {
		if(plantName.equals("PeaShooter")) {
			int i = 0;
			//recorremos las columnas en busca de un zombie
			while (i < COLUMNAS && !zombieList.checkObject(x, i))
			{
				i++;
			}
			//si sale porque encuentra un zombie -> dispara
			if(zombieList.checkObject(x,i))
			{
				zombieList.decreaseHealth(x, i, PeaShooter.getDamage());
			}
		}
		else {

			//PetaCereza
			//comprueba coordenada dentro tablero y comprueba que haya zombie para atacarlo con la explosion

			for(int i=y-1;i<y+2;i++) {
				if(comprobarDamagePetaCereza(x-1,i)) {
					if(checkZombie(x-1,i)) {
						zombieList.decreaseHealth(x-1, i, PetaCereza.getDamage());
					}
				}
			}
			for(int i=y-1;i<y+2;i++) {
				if(comprobarDamagePetaCereza(x,i)) {
					if(checkZombie(x,i)) {
						zombieList.decreaseHealth(x, i, PetaCereza.getDamage());
					}
				}
			}
			for(int i=y-1;i<y+2;i++) {
				if(comprobarDamagePetaCereza(x+1,i)) {
					if(checkZombie(x+1,i)) {
						zombieList.decreaseHealth(x+1, i, PetaCereza.getDamage());
					}
				}
			}
		}
	}


	public void attackPlant(int x, int y, int damage)
	{
		plantList.decreaseHealth(x, y, damage);

	}

	private boolean comprobarDamagePetaCereza(int x, int y) {
		return x >=0 && x<FILAS && y >=0 && y <COLUMNAS;
	}

	//CHECK FINAL PARTIDA

	public boolean isNotFinished() {
		update();
		return zombieManager.getZombiesRestantesVivos() > 0 && !zombieManager.zombiGanador();
	}


	public boolean checkWinnerZombie()
	{
		int i = 0;
		boolean found = false;
		while (i < zombieList.getContador() && !found)
		{
			if(zombieList.checkWinnerZombie(i))
			{
				found = true;
			}
			else {
			i++;
			}
		}

		return found;
	}


	//GENERAR ZOMBIES
	public void addZombieAction() {
		int tipoZombie=rand.nextInt(2);
		int filaZombie= rand.nextInt(FILAS-1);
		if(zombieManager.isZombieAdded()&&checkEmpty(filaZombie,COLUMNAS-1)) {
			addZombie(filaZombie, COLUMNAS-1,chooseZombie(tipoZombie));
			decreaseZombiesLeft();
		}
	}

	private String chooseZombie(int numRandom) {
		String zombie;
		switch(numRandom) {
		case 0:
			zombie="ZombieComun";
			break;
		case 1:
			zombie="Caracubo";
			break;
		case 2:
			zombie="Deportista";
			break;
		default:
			zombie="ZombieComun";
			break;
		}
		return zombie;
	}

	public void addZombie(int x, int y,String tipoZombie) {

		Zombie z = ZombieFactory.getZombie(tipoZombie);
		zombieList.Add(x, y, z,this);
	}

	public void decreaseZombiesLeft()
	{
		zombieManager.decreaseZombiesLeft();
	}

	public boolean checkZombie(int x, int y){

		return zombieList.checkObject(x, y);
	}


	//ANIADIR PLANTAS
	public void addPlantToGame(Plant plant, int x, int y)
	{
		if(comprobarDentroTablero(x, y) && checkEmpty(x,y)) {
				//board update()
				if(plantList.Add(x,y,plant,this)) {
					addCycle();
					decreaseSuncoins(Plant.getCost());
				}
			}

	}

	private boolean comprobarDentroTablero(int x, int y) {
		//solo permite poner plantas hasta la penultima columna
		return x >=0 && x<FILAS && y >=0 && y <COLUMNAS-1;
	}

	public boolean checkEmpty(int x,int y) {
		boolean empty = false;
		if(!plantList.checkObject(x, y) && !zombieList.checkObject(x, y)) {
			empty = true;
		}
		return empty;
	}


	//SUNCOINS
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

	public void decreaseSuncoins(int cost)
	{

		suncoins.decreaseSuncoins(cost);
	}


	//COMANDOS Y EXECUTES
	public static void commandHelp() {
		System.out.println(CommandParser.commandHelp());
	}

	public void printList() {
		System.out.println( PlantFactory.listOfAvaiablePlants());
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


	//GETTERS Y SETTERS
	public LEVEL getLevel() {
		return level;
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

	public void setGamePrinter(GamePrinter gamePrinter) {
		this.gamePrinter = gamePrinter;
	}

	public int getNumZombiesLista()
	{
		return zombieList.getContador();
	}

	public int getNumPlantasLista()
	{

		return plantList.getContador();
	}
}
