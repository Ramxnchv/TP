package tp.p1.game;

import tp.p1.plants.PeaShooter;
import tp.p1.plants.SunFlower;
import tp.p1.lists.SunFlowerList;

public class SunCoinManager {
	private Game game;
	private int sunCoins;
	
	public SunCoinManager(Game game) {
		this.game=game;
	}

	
	public int calcularSuncoinsCiclo() {
		for(int i=0;i<game.getNumSunflowerLista();i++) {
			
		}
		return sunCoins+=50;
	}
	
	public void decreaseSuncoins(int cost)
	{
		sunCoins -= cost;
	}
	
	public int getSunCoins() {
		return sunCoins;
	}

	public void setSunCoins(int sunCoins) {
		this.sunCoins = sunCoins;
	}
}
