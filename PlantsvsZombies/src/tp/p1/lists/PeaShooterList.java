package tp.p1.lists;

import tp.p1.plants.PeaShooter;
 

public class PeaShooterList {
	private PeaShooter[] list;
	private int contador=0;
	private static final int BOARD_SIZE=32;
	
	
	//constructor
	public PeaShooterList() {
		list=new PeaShooter[BOARD_SIZE];
	}
	
	//metodos principales
	public boolean Add(PeaShooter peashooter) {
		if(contador<BOARD_SIZE) {
			list[contador]=peashooter;
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
	
	public void decreaseHealth(int i, int x, int y, int damage)
	{
		list[i].decreaseHealth(damage);
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
	
	public int searchPosition(int x,int y) {
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
	
	public String printPosition(int i)
	{
		return list[i].toString();
	}

	//getters y setters
	
	public static int getBoardSize() {
		return BOARD_SIZE;
	}

	public PeaShooter[] getList() {
		return list;
	}

	public int getContador() {
		return contador;
	}
	

	
	
}