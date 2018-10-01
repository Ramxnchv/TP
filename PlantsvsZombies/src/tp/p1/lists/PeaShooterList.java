package tp.p1.lists;

import tp.p1.plants.PeaShooter;

public class PeaShooterList {
	private PeaShooter[] list;
	private static final int TAMAÑO_TABLERO=32;
	
	public PeaShooterList() {
		list=new PeaShooter[TAMAÑO_TABLERO];
	}
	
	public boolean Add(PeaShooter peashooter) {
		if(list.length<TAMAÑO_TABLERO) {
			list[list.length]=peashooter;
		}
		return list.length<TAMAÑO_TABLERO;
	}
	
	public boolean Delete(int pos) {
		for(int i=pos;i<list.length;i++) {
			list[i]=list[i+1];
		}
		return true;
	}
	public int searchPosition(int x,int y) {
		int i=0;
		boolean encontrado=false;
		while(i<list.length&&!encontrado) {
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
}
