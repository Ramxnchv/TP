package tp.p1.lists;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import tp.p1.game.Game;
import tp.p1.game.PlantFactory;
import tp.p1.game.ZombieFactory;
import tp.p1.objects.*;
public class GameObjectList {
	private ActiveGameObject[] list;
	private int contador=0;
	private static final int BOARD_SIZE=32;
	private Game game;

	public GameObjectList() {
		list=new ActiveGameObject[BOARD_SIZE];
	}

	public boolean Add(int x, int y, ActiveGameObject object,Game game) {
		if(contador<BOARD_SIZE) {
			list[contador]=object;
			contador++;
		}
		return contador<BOARD_SIZE;
}
	public boolean checkObject(int x, int y)
	{
		int i=0;
		boolean encontrado=false;
		while(i<contador&&!encontrado) {
			if((list[i].getX()==x)&&(list[i].getY()==y)) {
				encontrado=true;
			}
			else {
				i++;
			}
		}
		return encontrado;
	}

	public boolean Delete() {
		boolean deleted = false;
		for(int i=0;i<contador;i++) {
			if(contador > 0  && list[i].getHealthPoints() <= 0) {
				list[i]=list[i+1];
				contador--;
				deleted = true;
			}
		}
		return deleted;
	}

	public void update() {
		for(int i=0;i<contador;i++) {
			list[i].update();
		}
	}

	public void store(BufferedWriter bw) throws IOException {

		for (int i = 0; i < contador; i++) {
			list[i].store(bw);
		}

	}

	public void decreaseHealth(int x, int y, int damage)
	{
		int pos = searchPosition(x,y);
		list[pos].decreaseHealth(damage);
	}


	public String printPosition(int x, int y)
	{
		return list[searchPosition(x,y)].toString();
	}

	public String printInfoDebug(int i){

		return list[i].printInfo();
	}

	public boolean checkWinnerZombie(int i) {
		return list[i].getY() == 0;
	}

	//metodo privado para buscar en la lista
	private int searchPosition(int x,int y) {
		int i=0;
		boolean encontrado=false;
		while(i<contador&&!encontrado) {
			if((list[i].getX()==x)&&(list[i].getY()==y)) {
				encontrado=true;
			}
			else {
			i++;
			}
		}
		return i;
	}

	public int getContador() {
		return contador;
	}

	public int getYPosition(int i)
	{
		return list[i].getY();
	}

	public void modifyObject(int health, int timeToNextAction, int i) {
		list[i].setHealthPoints(health);
		list[i].setTimeToNextAction(timeToNextAction);

	}

	public void loadFromFile(BufferedReader br, String [] line, String listType) {
		String symbol;
		int x, y, life, timeAction;
		String [] elemento = line[0].split(":");

		for(int i =  0; i < line.length; i++) {
			symbol = elemento[0].toLowerCase();
			x = Integer.parseInt(elemento[2]);
			y = Integer.parseInt(elemento[3]);
			life = Integer.parseInt(elemento[1]);
			timeAction = Integer.parseInt(elemento[4]);

			if(listType.equals("plantList")) {

				Plant plant = PlantFactory.getPlant(symbol, x, y, game);
				list[i].setHealthPoints(life);
				list[i].setTimeToNextAction(timeAction);
				list[i] = plant;

			} else if (listType.equals("zombieList")) {

				Zombie zombie = ZombieFactory.getZombie(symbol, x, y, game);
				list[i].setHealthPoints(life);
				list[i].setTimeToNextAction(timeAction);
				list[i] = zombie;

			} else {
				//

			}
		}

	}
}
