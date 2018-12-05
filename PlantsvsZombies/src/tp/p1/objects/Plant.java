package tp.p1.objects;

import tp.p1.game.Game;

public abstract class Plant extends ActiveGameObject {
	private static int cost;
	protected String name;

	public Plant(String symbol, int x, int y,int healthPoints, int frequency,int cost, Game game) {
		super(symbol,x,y,healthPoints,frequency,game);
		Plant.cost=cost;
	}

	public abstract void update();

	public abstract String printInfo();

	public static int getCost() {
		return cost;
	}

	public String getName() {
		return name;
	}

}
