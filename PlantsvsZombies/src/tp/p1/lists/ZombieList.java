package tp.p1.lists;

import tp.p1.zombies.Zombie;

public class ZombieList {
	private Zombie[] list;
	int contador=0;
	private static final int NUM_MAX_ZOMBIES=10;
	
	public ZombieList() {
		list=new Zombie[NUM_MAX_ZOMBIES];
	}
	
	public boolean Add(Zombie zombie) {
		if(contador<NUM_MAX_ZOMBIES) {
			list[contador]=zombie;
			contador++;
		}
		return contador<NUM_MAX_ZOMBIES;
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
	

	public Zombie getZombie(int pos) {
		return list[pos];
	}
	
	public Zombie[] getList() {
		return list;
	}

	public void setList(Zombie[] list) {
		this.list = list;
	}

	public static int getNumMaxZombies() {
		return NUM_MAX_ZOMBIES;
	}

	public int getContador() {
		return contador;
	}
	
}
