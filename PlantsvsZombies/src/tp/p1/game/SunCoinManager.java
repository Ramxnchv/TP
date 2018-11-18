package tp.p1.game;

public class SunCoinManager {
	private Game game;
	private int sunCoins;
	
	public SunCoinManager(Game game) {
		this.game=game;
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
