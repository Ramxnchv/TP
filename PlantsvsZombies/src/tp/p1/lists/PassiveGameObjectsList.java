package tp.p1.lists;


import java.io.BufferedWriter;
import java.io.IOException;

import tp.p1.objects.PassiveGameObject;

public class PassiveGameObjectsList {
	
	private PassiveGameObject[] list;
	private int contador;
	private static final int BOARD_SIZE=32;
	
	public PassiveGameObjectsList() {
		list=new PassiveGameObject[BOARD_SIZE];
		contador=0;
	}
	
	public boolean Add(PassiveGameObject object) {
		if(contador<BOARD_SIZE) {
			list[contador]=object;
			contador++;
		}
		return contador<BOARD_SIZE;
	}
	
	public void Delete(int pos) {
		for(int i=pos;i<contador;i++) {
				list[i]=list[i+1];
				contador--;
		}
	}
	
	public void store(BufferedWriter bw) throws IOException{
		
	}
	
	public void removeDeadGameObjects() {
		for(int i=0;i<contador;i++) {
			if(list[i].isCatched()) {
				Delete(i);
			}
		}
	}
	
	public PassiveGameObject getPosition(int x,int y) {
		PassiveGameObject object=null;
		if(checkObject(x,y)) {
			object=list[searchPosition(x,y)];
		}
		return object;
	}
	
	public boolean isPositionEmpty(int x, int y) {
		
		int i=0;
		boolean empty=true;
		while(i<contador&&empty!=false) {
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

	public boolean isnotFull() {
		return contador<BOARD_SIZE-1;
	}
	
}
