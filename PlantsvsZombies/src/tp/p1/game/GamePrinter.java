package tp.p1.game;

import tp.p1.lists.*;
import tp.p1.plants.*;
import tp.p1.util.MyStringUtils;
import tp.p1.zombies.Zombie;

public class GamePrinter {
	int dimX; 
	int dimY;
	String[][] board;
	final String space = " ";
	
	
	public GamePrinter(Game game, int dimX, int dimY) {
		this.dimX = dimX;
		this.dimY = dimY;
		
		encodeGame(game);
	}
	
	private void encodeGame(Game game) {
		board = new String[dimX][dimY];
		for(int i = 0; i < dimX; i++) {
			for(int j = 0; j < dimY; j++) {

				board[i][j] =  space;
				
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private String [][] tablero;
	private final int NUM_FILAS=4;
	private final int NUM_COLUMNAS=8;
	private Game game;
	
	public GamePrinter(Game game) {
		this.tablero=new String[NUM_FILAS][NUM_COLUMNAS];
		this.game=game;
	}
	
	public void actualizarTablero() {
		for(int i=0;i<NUM_FILAS;i++) {
			for(int j=0;j<NUM_COLUMNAS;j++) {
				tablero[i][j]="       ";
			}
		}
		for(int i=0;i<game.getPeashooterList().getContador();i++){
			PeaShooter[] ps = game.getPeashooterList().getList();
			tablero[ps[i].getX()][ps[i].getY()]= " P ["+ps[i].getHealthPoints()+"] ";
		}
		for(int i=0;i<game.getSunflowerList().getContador();i++){
			SunFlower[] sf = game.getSunflowerList().getList();
			tablero[sf[i].getX()][sf[i].getY()]= " S ["+sf[i].getHealthPoints()+"] ";
		}
		for(int i=0;i<game.getZombieList().getContador();i++) {
			Zombie[] zb = game.getZombieList().getList();
			tablero[zb[i].getX()][zb[i].getY()]=" Z ["+zb[i].getHealthPoints()+"] ";
		}
	}
	
	public String dibujarTablero() {
		String tableroDibujado="-";
		for(int i=0;i<NUM_FILAS;i++) {
		tableroDibujado=" --------------------------------------------------------------\n ";	
			for(int j=0;j<NUM_COLUMNAS;j++) {
				tableroDibujado+="|";
				tableroDibujado+=tablero[i][j];
			}
			tableroDibujado+="|";
		}
		return tableroDibujado;
	}
	*/	
}
