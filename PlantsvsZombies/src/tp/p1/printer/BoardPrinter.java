package tp.p1.printer;

import tp.p1.game.Game;

public abstract class BoardPrinter implements GamePrinter{
	protected int dimX;
	protected int dimY;
	protected final String space = " ";

	public BoardPrinter(Game game, int dimX, int dimY) {
		this.dimX = dimX;
		this.dimY = dimY;

		encodeGame(game);
	}

	public abstract void encodeGame(Game game);
	public abstract String printGame(Game game);

}
