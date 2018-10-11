package tp.p1.lists;

import tp.p1.plants.PeaShooter;

public class PeaShooterList {
	private PeaShooter[] list;
	private int contador=0;
	private static final int TAMAÑO_TABLERO=32;
	
	public PeaShooterList() {
		list=new PeaShooter[TAMAÑO_TABLERO];
	}
	
	public boolean Add(PeaShooter peashooter) {
		if(contador<TAMAÑO_TABLERO) {
			list[contador]=peashooter;
			contador++;
		}
		return contador<TAMAÑO_TABLERO;
	}
	
	public void Delete(int pos) {
		for(int i=pos;i<contador;i++) {
			list[i]=list[i+1];
		}
		contador--;
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
	public int length() {
		return list.length;
	}

	public static int getTamañoTablero() {
		return TAMAÑO_TABLERO;
	}

	public PeaShooter[] getList() {
		return list;
	}

	public void setList(PeaShooter[] list) {
		this.list = list;
	}

	public int getContador() {
		return contador;
	}
	
}
