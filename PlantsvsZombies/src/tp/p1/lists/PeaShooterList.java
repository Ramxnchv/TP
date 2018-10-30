package tp.p1.lists;

import tp.p1.plants.PeaShooter;
import tp.p1.game.Game;


public class PeaShooterList {
	private PeaShooter[] list;
	private int contador=0;
	private static final int BOARD_SIZE=32;


	//constructor
	public PeaShooterList() {
		list=new PeaShooter[BOARD_SIZE];
	}

	//metodos principales
	public boolean Add(int x, int y, Game game) {
		PeaShooter ps = new PeaShooter(x, y, game);
		if(contador<BOARD_SIZE) {
			list[contador]=ps;
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

	public void decreaseHealth(int x, int y, int damage)
	{
    int pos = searchPosition(x,y);
		list[pos].decreaseHealth(damage);
	}

	public boolean checkPeashooter(int x, int y)
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

	public String printPosition(int x, y)
	{
    int pos = searchPosition(x,y);
		return list[pos].toString();
	}

	//getters y setters

	public int getContador() {
		return contador;
	}




}
