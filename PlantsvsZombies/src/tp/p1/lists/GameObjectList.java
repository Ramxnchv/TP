package tp.p1.lists;

import tp.p1.game.Game;
import tp.p1.objects.*;

public class GameObjectList {
	private GameObject[] list;
	private int contador=0;
	private static final int BOARD_SIZE=32;

	public GameObjectList() {
		list=new GameObject[BOARD_SIZE];
	}
	
	public boolean Add(int x, int y, GameObject object,Game game) {
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
	
	public void decreaseHealth(int x, int y, int damage)
	{
		int pos = searchPosition(x,y);
		list[pos].decreaseHealth(damage);
	}
	
	
	public String printPosition(int x, int y)
	{
		return list[searchPosition(x,y)].toString();
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
}
