package tp.p1.lists;

import tp.p1.plants.SunFlower;

public class SunFlowerList {
	private SunFlower[] list;
	int contador=0;
	private static final int TAMAÑO_TABLERO=32;
	
	public SunFlowerList() {
		list=new SunFlower[TAMAÑO_TABLERO];
	}
	
	public boolean Add(SunFlower sunflower) {
		if(contador<TAMAÑO_TABLERO) {
			list[contador]=sunflower;
			contador++;
		}
		return contador<TAMAÑO_TABLERO;
	}
	public void Delete(int pos) {
		for(int i=pos;i<contador;i++) {
			list[i]=list[i+1];
		}
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

	public SunFlower[] getList() {
		return list;
	}

	public static int getTamañoTablero() {
		return TAMAÑO_TABLERO;
	}

	public int getContador() {
		return contador;
	}
	
}
