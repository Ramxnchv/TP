package tp.p1.lists;

import tp.p1.plants.SunFlower;


public class SunFlowerList {
	private SunFlower[] list;
	int contador=0;
	private static final int BOARD_SIZE=32;
	
	public SunFlowerList() {
		list=new SunFlower[BOARD_SIZE];
	}
	
	public boolean Add(SunFlower sunflower) {
		if(contador<BOARD_SIZE) {
			list[contador]=sunflower;
			contador++;
		}
		return contador<BOARD_SIZE;
	}
	public void Delete(int pos) {
		for(int i=pos;i<contador;i++) {
			list[i]=list[i+1];
		}
	}
	
	
	public boolean checkSunflower(int x, int y)
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
	
	/*public void increaseCycleSunflowers()
	{
		for(int i = 0; i < contador; i++)
			list[i].setInternalCycle(list[i].getInternalCycle()+1);
	}*/
	
	public String printPosition(int i)
	{
		return list[i].toString();
	}
	
	//metodo comprobar casilla libre

	public SunFlower[] getList() {
		return list;
	}
	
	public SunFlower getSunFlower(int pos) {
		return list[pos];
	}


	public static int getBoardSize() {
		return BOARD_SIZE;
	}

	public int getContador() {
		return contador;
	}
	
}
