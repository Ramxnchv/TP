package tp.p1.lists;

import tp.p1.zombies.Zombie;

public class ZombieList {
	private Zombie[] list;
	private static final int NUM_MAX_ZOMBIES=10;
	
	public ZombieList() {
		list=new Zombie[NUM_MAX_ZOMBIES];
	}
	
	public boolean Add(Zombie zombie) {
		if(list.length<NUM_MAX_ZOMBIES) {
			list[list.length]=zombie;
		}
		return list.length<NUM_MAX_ZOMBIES;
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
