package tp.p1.printer;

import tp.p1.game.Game;

public class Debug extends BoardPrinter{
	
	public Debug(Game game, int dimX, int dimY) {
		super(game,dimX,dimY);
	}
	
	public void encodeGame(Game game) {
		
	}
	
	public String printGame(Game game) {
		return super.toString();
	}
	
}
