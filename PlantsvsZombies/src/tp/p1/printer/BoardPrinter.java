package tp.p1.printer;

import tp.p1.game.Game;

public abstract class BoardPrinter implements GamePrinter{
	int dimX; 
	int dimY;
	String[][] board;
	final String space = " ";
	
	public BoardPrinter(Game game, int dimX, int dimY) {
		this.dimX = dimX;
		this.dimY = dimY;
		
		encodeGame(game);
	}
	
	public abstract void printGame();
	
	private void encodeGame(Game game) {
		board = new String[dimX][dimY];
		for(int i = 0; i < dimX; i++) {
			for(int j = 0; j < dimY; j++) {

				board[i][j] =  space;
				board[i][j] = game.getObject(i, j);
				// TODO Fill the board with simulation objects
				
			}
		}
	}
}
