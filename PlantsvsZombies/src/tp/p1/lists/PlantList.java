package tp.p1.lists;

import tp.p1.game.Game;
import tp.p1.game.PlantFactory;
import tp.p1.objects.Plant;
import tp.p1.plants.PeaShooter;

public class PlantList {
	private Plant[] list;
	private int contador=0;
	private static final int BOARD_SIZE=32;
	
	public PlantList() {
		list=new Plant[BOARD_SIZE];
	}
	
	public boolean Add(int x, int y, String plantName,Game game) {
		Plant plant = PlantFactory.getPlant(plantName, x, y, game);
		if(contador<BOARD_SIZE) {
			list[contador]=plant;
			contador++;
		}
		return contador<BOARD_SIZE;
	}

	public void Delete() {
		for(int i=0;i<contador;i++) {
			if(contador > 0 && list[i].getHealthPoints() <= 0) {
				list[i]=list[i+1];
				contador--;
			}
		}
	}

	public void update() {
		for(int i=0;i<contador;i++) {
			list[i].update();
		}
	}
	
	public boolean checkPlant(int x, int y)
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

	public void decreaseHealth(int x, int y, int damage)
	{
		int pos = searchPosition(x,y);
		list[pos].decreaseHealth(damage);
	}
	
	
	public String printPosition(int x, int y)
	{
		return list[searchPosition(x,y)].toString();
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
	
	
	public boolean checkPlantToPrint(int x, int y) {
		
	int i=0;
	boolean encontrado=false;
	while(i<contador&&!encontrado) {
		if((list[i].getX()==x)&&(list[i].getY()==y)) {
			encontrado=true;
		} else {
			i++;
		}
		}
		
		
	return encontrado;
	}
	
}
