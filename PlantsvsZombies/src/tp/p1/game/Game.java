package tp.p1.game;

import java.util.Random;

import tp.p1.command.CommandParser;
import tp.p1.lists.*;
import tp.p1.objects.Plant;
import tp.p1.objects.Sun;
import tp.p1.plants.*;
import tp.p1.printer.Debug;
import tp.p1.printer.GamePrinter;
import tp.p1.printer.Release;
import tp.p1.suns.SunManager;
import tp.p1.zombies.ZombieManager;
import tp.p1.objects.Zombie;
import tp.p1.suns.SunManager;

public class Game {
	//ATRIBUTOS
	private GameObjectList zombieList;
	private GameObjectList plantList;
	private LEVEL level;
	private Random rand;
	private int seed;
	private int numCiclos;
	private GamePrinter gamePrinter;
	private ZombieManager zombieManager;
	private SunManager sunManager;
	private String printMode;
	private final int FILAS=4;
	private final int COLUMNAS=8;
		private boolean sameCycle = false;

	//CONSTRUCTOR
	public Game(LEVEL level,Random rand,int seed) {
		this.level=level;
		this.rand=rand;
		this.seed=seed;
		this.inicializar();
	}

	//UPDATE Y CICLOS
	private void update() {


		if(!isSameCycle()) {

			//genera soles aleatorios
			sunManager.update();

			//actualizar plantas
			plantList.update();

			//avanzar y atacar zombies
			zombieList.update();


			//limpiar sin vida
			this.eliminarSinVida();
		}
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
		this.sunManager=new SunManager(this);
		numCiclos=0;
		this.printMode="Release";
		this.gamePrinter=new Release(this,FILAS,COLUMNAS);
		sunManager.setSunCoins(50);
		this.zombieManager=new ZombieManager(this);

	}


	//PRINT GAME

	public void draw() {
		if(printMode.equals("Release")) {
			this.gamePrinter=new Release(this,FILAS,COLUMNAS);
		}
		else {
			this.gamePrinter=new Debug(this,FILAS,COLUMNAS);
		}
		System.out.println(gamePrinter.printGame(this));
	}

	public String printPromptRelease() {
		StringBuilder sb= new StringBuilder();
		String salida1="Number of cycles: "+numCiclos;
		String salida2="\nSun coins: "+sunManager.getSunCoins();
		String salida3="\nRemaining zombies: "+zombieManager.getZombiesRestantes();
		return sb.append(salida1).append(salida2).append(salida3).toString();
	}

	public String printPromptDebug() {
		StringBuilder sb= new StringBuilder();
		String salida1="Number of cycles: "+numCiclos;
		String salida2="\nSun coins: "+sunManager.getSunCoins();
		String salida3="\nRemaining zombies: "+zombieManager.getZombiesRestantes();
		String salida4="\nLevel: "+level;
		String salida5="\nSeed: "+seed;
		return sb.append(salida1).append(salida2).append(salida3).append(salida4).append(salida5).toString();
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

	public void changePrintMode(String mode) {
		if(mode.equals("Release")) {
			printMode="Release";
		}
		else {
			printMode="Debug";
		}
	}

	public String getPlantInfo(int i) {

	String str = plantList.printInfoDebug(i);

	return str;
	}

	public String positionToString(int i,int j) {
		String sunString="";
		String str;

		if(sunManager.checkSun(i,j)) {
			sunString = sunManager.positionToString(i, j);
		}
		if(plantList.checkObject(i, j))
		{
			str = plantList.printPosition(i, j);
		}
		else if (zombieList.checkObject(i, j))
		{
			str = zombieList.printPosition(i, j);
		}
		else {
			str = " ";
		}

		return str + sunString;
	}

public String getZombieInfo(int i) {

	String str = zombieList.printInfoDebug(i);

	return str;
}



	//ATTACK ZOMBIES Y PLANTAS

	public void attackZombie(String plantName,int x,int y) {
		if(plantName.equals("Peashooter")) {
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

	public boolean isNotFinished(boolean noPrint) {
		if(!noPrint) {
			update();
			draw();
		}
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

		Zombie z = ZombieFactory.getZombie(tipoZombie,x,y,this);
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
	public boolean addPlantToGame(Plant plant, int x, int y)
	{
		boolean added = false;
		if(comprobarDentroTablero(x, y) && checkEmpty(x,y)) {
				//board update()
				if(plantList.Add(x,y,plant,this)) {
					addCycle();
					decreaseSuncoins(Plant.getCost());
					added = true;
				}
			} else {
				System.out.println("Plant can't be added");
				added = false;
			}

		return added;

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


	//SUNCOINS y SUNS
	public boolean enoughMoney(int plantCost) {

		return sunManager.getSunCoins() >= plantCost;

	}
	public void addSun(int x, int y) {

		sunManager.Add(x, y);

	}

	public boolean catchSun(int x,int y) {
		return sunManager.catchSun(x, y);
	}

	public void decreaseSuncoins(int cost)
	{

		sunManager.decreaseSuncoins(cost);
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

	public SunManager getSuncoins() {
		return sunManager;
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

	public boolean isSameCycle()
	{
		return sameCycle;
	}

	public void setSameCycle(boolean cycle) {
		this.sameCycle = cycle;
	}

}
