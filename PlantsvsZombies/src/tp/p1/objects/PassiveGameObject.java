package tp.p1.objects;

import tp.p1.game.Game;

public abstract class PassiveGameObject extends GameObject {

	public PassiveGameObject(String symbol,int x, int y, Game game) {
		super(symbol, x, y, game);
	}

	@Override
	public abstract String printInfo();
	public abstract boolean isCatched();

}
