package tp.p1.suns;

import tp.p1.game.Game;
import tp.p1.objects.PassiveGameObject;
import tp.p1.objects.Sun;
import tp.p1.lists.PassiveGameObjectsList;

public class SunManager {
	
	private PassiveGameObjectsList suns;
	private int contador=0;
	private Game game;
	private static final int BOARD_SIZE=32;
	private int sunCoins;

	public SunManager(Game game) {
		this.game = game;
		suns=new PassiveGameObjectsList();
	}
	
	public void update() {
		if(game.getNumCiclos() != 0 && game.getNumCiclos()%5==0) {
			int x = game.getRand().nextInt(game.getFILAS());
			
			int y = game.getRand().nextInt(game.getCOLUMNAS());
			while(!suns.isPositionEmpty(x,y)) {
				x = game.getRand().nextInt(game.getCOLUMNAS());
				y = game.getRand().nextInt(game.getFILAS());
			}
			
			Sun sun = new Sun(x, y, game);
			
			suns.Add(sun);
		}
	}
	
	public void Add(int x, int y) {
		Sun sun = new Sun(x, y, game);
		if(suns.isPositionEmpty(x, y)) {
			sun.setPosition(x, y);
			suns.Add(sun);
		}
	}
	
	public String positionToString(int x, int y)
	{
		
		int i = suns.searchPosition(x,  y);
		return suns.printPosition(i).toString();
	}
	
	public boolean checkSun(int x, int y) {
		return suns.checkObject(x, y);
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

