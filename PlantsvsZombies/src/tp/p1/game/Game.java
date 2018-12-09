package tp.p1.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

import tp.p1.command.CommandParser;
import tp.p1.command.FileContentsException;
import tp.p1.command.NoSuncoinsException;
import tp.p1.command.NotEmptyPositionException;
import tp.p1.command.OutOfBoardException;
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

public class Game {
	//ATRIBUTOS
	private GameObjectList zombieList;
	private GameObjectList plantList;
	
	private LEVEL level;
	private Random rand;
	private int seed;
	private int numCiclos;
	
	private boolean exit;
	private GamePrinter gamePrinter;
	private ZombieManager zombieManager;
	private SunManager sunManager;
	private final int FILAS=4;
	private final int COLUMNAS=8;
	private boolean sameCycle = false;
	public static final String wrongPrefixMsg = "unknown game attribute";
	public static final String lineTooLongMsg = "too many words on line commencing";
	public static final String lineTooShortMsg = "missing data on line commencing";
	
	//backup
	private int cyclesCopy;
	private int suncoinsCopy;
	private int remainingZombiesCopy;
	private int seedCopy;
	private LEVEL levelCopy;
	private GameObjectList zombieListCopy;
	private GameObjectList plantListCopy;

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
		this.exit=false;
		numCiclos=0;
		this.gamePrinter=new Release(this,FILAS,COLUMNAS);
		sunManager.setSunCoins(50);
		this.zombieManager=new ZombieManager(this);

	}


	//PRINT GAME

	public void draw() {
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

	public void decreaseHealthZombie(int x,int y,int damage) {
		zombieList.decreaseHealth(x, y, damage);
	}

	public void attackPlant(int x, int y, int damage)
	{
		plantList.decreaseHealth(x, y, damage);

	}

	public boolean comprobarDamagePetaCereza(int x, int y) {
		return x >=0 && x<FILAS && y >=0 && y <COLUMNAS;
	}

	//CHECK FINAL PARTIDA

	public boolean isNotFinished() {
		this.update();
		return zombieManager.getZombiesRestantesVivos() > 0 && !zombieManager.zombiGanador();
	}
	
	public void setExit() {
		this.exit=true;
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
	public boolean addPlantToGame(Plant plant, int x, int y) throws NotEmptyPositionException,NoSuncoinsException,OutOfBoardException
	{
		boolean added = false;

		if(!this.enoughMoney(Plant.getCost())) {
			throw new NoSuncoinsException("not enough suncoins to buy it");
		}
		this.setSameCycle(false);
		if(!checkEmpty(x,y)) {
			throw new NotEmptyPositionException("("+x+","+y+")");
		}
		if(!comprobarDentroTablero(x,y)) {
			throw new OutOfBoardException("("+x+","+y+")");
		}
			//board update()
		if(plantList.Add(x,y,plant,this)) {
			addCycle();
			decreaseSuncoins(Plant.getCost());
			added = true;
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

	private void gameBackUp() {
		//Hacemos una copia del estado actual del juego
		zombieListCopy =new GameObjectList();
		plantListCopy =new GameObjectList();

		cyclesCopy = this.numCiclos;

		suncoinsCopy = this.sunManager.getSunCoins();

		remainingZombiesCopy = this.zombieManager.getZombiesRestantes();

		levelCopy = this.level;

		seedCopy = this.seed;

		plantList = plantListCopy;
		zombieList = zombieListCopy;

	}


	//COMANDOS Y EXECUTES
	public static void commandHelp() {
		System.out.println(CommandParser.commandHelp());
	}

	public void printList() {
		System.out.println( PlantFactory.listOfAvaiablePlants());
	}

	public boolean commandExit() {
		return this.exit;
	}
	public void store(BufferedWriter bw) throws IOException {
		bw.write("cycle: "+this.numCiclos);
		bw.newLine();
		bw.write("sunCoins: "+this.sunManager.getSunCoins());
		bw.newLine();
		bw.write("level: "+this.level.name());
		bw.newLine();
		bw.write("remZombies"+this.zombieManager.getZombiesRestantes());
		bw.newLine();
		bw.write("plantList: ");
		this.plantList.store(bw);
		bw.newLine();
		bw.write("zombieList: ");
		this.zombieList.store(bw);
		bw.newLine();
		bw.write("sunList: ");
		this.sunManager.store(bw);
	}


	public boolean load (BufferedReader br) throws IOException,FileContentsException {

		String[] line;

		//copiar estado actual
		gameBackUp();
		
		//Cargamos ciclos
		line = loadLine(br, "cycle", false);
		numCiclos = Integer.parseInt(line[0]);

		//cargamos suncoins
		line = loadLine(br, "sunCoins", false);
		sunManager.setSunCoins(Integer.parseInt(line[0]));

		//zomies restantes
		line = loadLine(br, "remZombies", false);
		zombieManager.setZombiesRestantes(Integer.parseInt(line[0]));

		//cargamos listaPlantas
		line = loadLine(br, "plantList", true);
		plantList = new GameObjectList();
		plantList.loadFromFile(br, line, "plantList");



		//cargamos listaZombies
		line = loadLine(br, "zombieList", true);
		zombieList = new GameObjectList();
		zombieList.loadFromFile(br, line, "zombieList");

		//cargamos los soles
		line = loadLine(br, "sunList", true);
		sunManager = new SunManager(this);
		sunManager.loadFromFile(br, line);

		return false;

	}


	public String[] loadLine(BufferedReader inStream, String prefix, boolean isList) throws IOException,FileContentsException {
		String line = inStream.readLine().trim();
		if(!line.startsWith(prefix+ ":"))
			throw new FileContentsException(wrongPrefixMsg + prefix);
		String contentString = line. substring(prefix.length()+1).trim();
		String[]  words;

		if(!contentString.equals("")) {
			if(!isList) {
				words = contentString.split("\\s+");

				if(words.length != 1)
					throw new FileContentsException(lineTooLongMsg + prefix);

			} else {
				words = contentString.split(",\\s*");
				System.out.println(words[1]);
			}
		} else {
			if(!isList)
				throw new FileContentsException(lineTooShortMsg + prefix);

			words = new String[0];

		}
		return words;
	}
	
	public void executeBackUp() {
		this.numCiclos=this.cyclesCopy;
		this.sunManager.setSunCoins(this.suncoinsCopy);
		this.zombieManager.setZombiesRestantes(this.remainingZombiesCopy);
		this.seed=this.seedCopy;
		this.level=this.levelCopy;
		this.zombieList=this.zombieListCopy;
		this.plantListCopy=this.plantList;
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
