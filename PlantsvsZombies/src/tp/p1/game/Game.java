package tp.p1.game;

import java.util.Random;

import tp.p1.command.CommandParser;
import tp.p1.lists.*;
import tp.p1.objects.Plant;
import tp.p1.plants.*;
import tp.p1.zombies.ZombieManager;

public class Game {
	//ATRIBUTOS
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

	//CONSTRUCTOR
	public Game(LEVEL level,Random rand) {
		this.level=level;
		this.rand=rand;
		this.inicializar();
	}

	//UPDATE Y CICLOS
	public void update() {
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
		zombieList =new ZombieList();
		plantList=new PlantList();
		numCiclos=0;
		this.gamePrinter=new GamePrinter(this,FILAS,COLUMNAS);
		this.suncoins=new SunCoinManager(this);
		suncoins.setSunCoins(50);
		this.zombieManager=new ZombieManager(this);
	}


	//PRINT GAME
	public String toString() {
		return gamePrinter.toString();
	}

	public String printPrompt() {
		StringBuilder sb= new StringBuilder();
		String salida1="Number of cycles: "+numCiclos;
		String salida2="\nSun coins: "+suncoins.getSunCoins();
		String salida3="\nRemaining zombies: "+zombieManager.getZombiesRestantes();
		return sb.append(salida1).append(salida2).append(salida3).toString();
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


	//ATTACK ZOMBIES Y PLANTAS

		/*public void attackPlant(int x,int y,int damage) {
		//si esta vacia la casilla
		if(game.checkEmpty(x, y-1)&&internalCycle%frequency==0) {
			//avanzar
			this.y=this.y-speed;
		}
		else if (game.checkEmpty(x, y-1) && internalCycle%frequency!=0 ){
			this.y = this.y;
		}
		else {
			if(!game.checkZombie(x, y-1)) {
			//atacar
			game.attackPlant(x,y-1,damage);
			}
		}
	}*/

	public void attackZombie(String plantName,int x,int y) {
		if(plantName.equals("PeaShooter")) {
			int i = 0;
			//recorremos las columnas en busca de un zombie
			while (i < COLUMNAS && !zombieList.checkZombie(x, i))
			{
				i++;
			}
			//si sale porque encuentra un zombie -> dispara
			if(zombieList.checkZombie(x,i))
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
		return zombieManager.getZombiesRestantesVivos() > 0 && !zombieManager.zombiGanador();
	}

	public boolean checkWinnerZombie()
	{
		boolean found = false;
		if(zombieList.checkWinnerZombie())
			found = true;
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
		zombieList.Add(x, y, tipoZombie,this);
	}

	public void decreaseZombiesLeft()
	{
		zombieManager.decreaseZombiesLeft();
	}

	public boolean checkZombie(int x, int y){

		return zombieList.checkZombie(x, y);
	}


	//ANIADIR PLANTAS
	public boolean addPlantToGame(String plantName, int x, int y)
	{
		if(comprobarDentroTablero(x, y) && checkEmpty(x,y)) {
			if(enoughMoney(plantName)) {
				plantList.Add(x,y,plantName,this);
			}
		}
		return enoughMoney(plantName);
	}

	private boolean comprobarDentroTablero(int x, int y) {
		//solo permite poner plantas hasta la penultima columna
		return x >=0 && x<FILAS && y >=0 && y <COLUMNAS-1;
	}

	private boolean checkEmpty(int x,int y) {
		boolean empty = false;
		if(!plantList.checkPlant(x, y) && !zombieList.checkZombie(x, y)) {
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


	//GETTERS Y SETTERS
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

	public int getNumZombiesLista()
	{
		return zombieList.getContador();
	}

	public int getNumPlantasLista()
	{

		return plantList.getContador();
	}
}
