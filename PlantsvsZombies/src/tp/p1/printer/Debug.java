package tp.p1.printer;

import tp.p1.game.Game;

public class Debug extends BoardPrinter{

	public Debug(Game game, int dimX, int dimY) {
		super(game,dimX,dimY);
	}

	public void encodeGame(Game game) {
		int totalObjects = game.getNumPlantasLista()+game.getNumZombiesLista();
		int cont = 0;

		String[] objectsArray = new String [totalObjects] ;

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
		return super.toString();
	}

}
