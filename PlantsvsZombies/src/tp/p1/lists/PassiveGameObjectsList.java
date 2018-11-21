package tp.p1.lists;


import tp.p1.objects.PassiveGameObject;

public class PassiveGameObjectsList {
	
	private PassiveGameObject[] list;
	private int contador=0;
	private static final int BOARD_SIZE=32;
	
	public PassiveGameObjectsList() {
		list=new PassiveGameObject[BOARD_SIZE];
	}
	
	public boolean Add(PassiveGameObject object) {
		if(contador<BOARD_SIZE) {
			list[contador]=object;
			contador++;
		}
		return contador<BOARD_SIZE;
}
	
	public boolean isPositionEmpty(int x, int y) {
		
		int i=0;
		boolean empty=true;
		while(i<contador&&!empty) {
			if((list[i].getX()==x)&&(list[i].getY()==y)) {
				empty=false;
			}
			else {
				i++;
			}
		}
		return empty;
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
	
	public String printPosition(int i) {
		
		return list[i].printInfo().toString();
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
	
	
}
