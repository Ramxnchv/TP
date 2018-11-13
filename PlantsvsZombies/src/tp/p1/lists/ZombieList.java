package tp.p1.lists;

import tp.p1.game.Game;
import tp.p1.objects.Zombie;
import tp.p1.zombies.*;

public class ZombieList {
	private Zombie[] list;
	int contador=0;
	private static final int NUM_MAX_ZOMBIES=10;

	public ZombieList() {
		list=new Zombie[NUM_MAX_ZOMBIES];
	}

	public boolean Add(int x, int y,String zomb, Game game) {
		Zombie zb = getZombie(x,y,zomb,game);
		if(contador<NUM_MAX_ZOMBIES) {
			list[contador]=zb;
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

	private Zombie getZombie(int x,int y,String zomb,Game game) {
		Zombie zb;
		if(zomb.equals("ZombieComun")) {
			zb=new ZombieComun(x,y,game);
		}
		else if(zomb.equals("Caracubo")){
			zb= new Caracubo(x,y,game);
		}
		else {
			zb= new Deportista(x,y,game);
		}
		return zb;
	}
	
	public void update() {
		for(int i=0;i<contador;i++) {
			list[i].update();
		}
	}

	public void decreaseHealth(int x, int y, int damage)
	{
		int pos = searchPosition(x,y);
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
	
	public String printPosition(int x, int y)
	{
		return list[searchPosition(x, y)].toString();
	}
	
	//metodo privado para buscar en la lista
	private int searchPosition(int x,int y) {
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
	
	public int getContador() {
		return contador;
	}
	
}