package tp.p1.printer;

import tp.p1.game.Game;

public class Release extends BoardPrinter {
	
	public Release(Game game, int dimX, int dimY) {
		super(game,dimX,dimY);
	}
	
	public void encodeGame(Game game) {
		board = new String[dimX][dimY];
		for(int i = 0; i < dimX; i++) {
			for(int j = 0; j < dimY; j++) {

				board[i][j] =  space;
				board[i][j] = game.getObject(i, j);
				// TODO Fill the board with simulation objects
				
			}
		}
	}
	
	public String printGame(Game game) {
		return super.toString();
	}
	
}
