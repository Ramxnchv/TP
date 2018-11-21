package tp.p1.printer;

import tp.p1.game.Game;
import tp.p1.util.MyStringUtils;

public class Debug extends BoardPrinter{

	private String[] objectsArray;
	int cont;

	public Debug(Game game, int dimX, int dimY) {
		super(game,dimX,dimY);
		encodeGame(game);
		}

	public void encodeGame(Game game) {
		int totalObjects = dimX*dimY;
		objectsArray = new String [totalObjects] ;
		cont=0;

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
			int cellSize = 22;
			String vDelimiter = "|";
			String hDelimiter = "-";
			String rowDelimiter = MyStringUtils.repeat(hDelimiter, (cont * cellSize));

			StringBuilder sb=new StringBuilder();

			sb.append(rowDelimiter).append("\n");

			for(int i=0;i<cont;i++) {

				sb.append(vDelimiter).append(space).append(objectsArray[i]).append(space);
			}

			sb.append("\n").append(rowDelimiter);

			return game.printPromptDebug()+"\n"+sb.toString();
		}
}
