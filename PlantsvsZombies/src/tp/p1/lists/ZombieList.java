package tp.p1.lists;

import tp.p1.zombies.Zombie;
import tp.p1.game.Game;

public class ZombieList {
	private Zombie[] list;
	int contador=0;
	private static final int NUM_MAX_ZOMBIES=10;
	
	public ZombieList() {
		list=new Zombie[NUM_MAX_ZOMBIES];
	}
	
	public boolean Add(int x, int y, Game game) {
		Zombie zomb=new Zombie(x, y, game);
		if(contador<NUM_MAX_ZOMBIES) {
			list[contador]=zomb;
			contador++;
		}
		return contador<NUM_MAX_ZOMBIES;
	}
	public boolean Delete() {
		boolean deleted = false;
		for(int i=0;i<contador;i++) {
			if(contador > 0  && list[i].getHealthPoints() <= 0) {
				list[i]=list[i+1];
				contador--;
				deleted = true;
			}
		}
		
		return deleted;
	}
	
	public void update() {
		for(int i=0;i<contador;i++) {
			list[i].update();
		}
	}
	
	public void decreaseHealth(int pos, int damage)
	{
		list[pos].decreaseHealth(damage);
	}
	
	public boolean checkZombie(int x, int y)
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
	
	public boolean checkWinnerZombie()
	{
		int i = 0;
		boolean found = false;
		while (i < contador && !found)
		{
			if(list[i].getY() == 0)
			{
				found = true;
			}
			i++;
		}
		
		return found;
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

	public int getContador() {
		return contador;
	}	
}
