package tp.p1.printer;

import tp.p1.game.Game;
import tp.p1.util.MyStringUtils;

public class Release extends BoardPrinter {

	private String[][] board;
	
	public Release(Game game, int dimX, int dimY) {
		super(game,dimX,dimY);
	}

	public void encodeGame(Game game) {
		board = new String[dimX][dimY];
		for(int i = 0; i < dimX; i++) {
			for(int j = 0; j < dimY; j++) {

				board[i][j] =  space;
				board[i][j] = game.positionToString(i, j);
				// TODO Fill the board with simulation objects

			}
		}
	}
	
	public String toString() {
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";

		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);

		StringBuilder str = new StringBuilder();

		str.append(lineDelimiter);

		for(int i=0; i<dimX; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<dimY; j++) {
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
		}
		
		return str.toString();
	}

	public String printGame(Game game) {
		encodeGame(game);
		return game.printPromptRelease()+"\n"+this.toString();
	}

}
