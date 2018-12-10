package tp.p1.suns;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import tp.p1.game.Game;
import tp.p1.objects.Sun;
import tp.p1.lists.PassiveGameObjectsList;

public class SunManager {

	private PassiveGameObjectsList suns;
	private Game game;
	private int sunCoins;

	public SunManager(Game game) {
		this.game = game;
		suns=new PassiveGameObjectsList();
	}

	//crear sun cada 5 ciclos
	public void update() {
		if(game.getNumCiclos() != 0 && game.getNumCiclos()%5==0) {
			int x = game.getRand().nextInt(game.getFILAS());

			int y = game.getRand().nextInt(game.getCOLUMNAS());
			while(!suns.isPositionEmpty(x,y)&&suns.isnotFull()) {
				x = game.getRand().nextInt(game.getCOLUMNAS());
				y = game.getRand().nextInt(game.getFILAS());
			}
			if(suns.isnotFull()) {
				Sun sun = new Sun("*",x, y, game);
				suns.Add(sun);
			}

		}
	}

	public void store(BufferedWriter bw) throws IOException {
		suns.store(bw);
	}

	//aniadir sun de un sunflower
	public void Add(int x, int y) {
		if(suns.isPositionEmpty(x, y)) {
			Sun sun = new Sun("*",x, y, game);
			sun.setPosition(x, y);
			suns.Add(sun);
		}
	}

	public String positionToString(int x, int y)
	{
		int i = suns.searchPosition(x,  y);
		return suns.printPosition(i).toString();
	}

	public boolean catchSun(int x,int y) {
		Sun sun= (Sun) suns.getPosition(x,y);
		if(sun != null) {
			sun.catchSun();
			sunCoins+=10;
			suns.removeDeadGameObjects();
			return true;
		}
		else {
		return false;
		}
	}

	public void loadFromFile(BufferedReader br, String [] line) {
		int x, y;

		for(int i = 0; i < line.length;i++) {
			String [] elemento = line[i].split(":");
			x = Integer.parseInt(elemento[1]);
			y = Integer.parseInt(elemento[2]);

			Add(x,y);


		}
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
