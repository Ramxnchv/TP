package tp.p1.printer;

import tp.p1.game.Game;
import tp.p1.util.MyStringUtils;

public abstract class BoardPrinter implements GamePrinter{
	protected int dimX; 
	protected int dimY;
	protected String[][] board;
	protected final String space = " ";
	
	public BoardPrinter(Game game, int dimX, int dimY) {
		this.dimX = dimX;
		this.dimY = dimY;
		
		encodeGame(game);
	}
	
	public abstract void encodeGame(Game game);
		
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
	
}
