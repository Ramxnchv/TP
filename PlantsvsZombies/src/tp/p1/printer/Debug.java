package tp.p1.printer;

import tp.p1.game.Game;
import tp.p1.util.MyStringUtils;

public class Debug extends BoardPrinter{

	private String[] objectsArray;
	int cont;
	
	public Debug(Game game, int dimX, int dimY) {
		super(game,dimX,dimY);
		int totalObjects = dimX*dimY;
		objectsArray = new String [totalObjects] ;
		cont=0;
	}

	public void encodeGame(Game game) {

		for(int i = 0; i < game.getNumPlantasLista(); i++) {
			objectsArray[cont] = game.getPlantInfo(i);
			cont++;
			}

		for(int i = 0; i < game.getNumZombiesLista(); i++) {
			objectsArray[cont] = game.getZombieInfo(i);
			cont++;
			}

		}

	public String printGame(Game game) {
		int cellSize = 7;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
		
		StringBuilder sb=new StringBuilder();
		
		sb.append(rowDelimiter);
		
		for(int i=0;i<cont;i++) {
			
			sb.append(vDelimiter).append(space).append(objectsArray[i]).append(space);
		}
		
		sb.append(vDelimiter).append(rowDelimiter);
		
		return game.printPromptDebug()+"\n"+sb.toString();
	}
}