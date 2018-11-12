package tp.p1.objects;

import tp.p1.game.Game;

public abstract class Plant extends GameObject {
	private int cost;
	
	public Plant(int x, int y,int healthPoints, int frequency,int cost, Game game) {
		super(x,y,healthPoints,frequency,game);
		this.cost=cost;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
