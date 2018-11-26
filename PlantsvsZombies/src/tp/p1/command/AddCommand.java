package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;
import tp.p1.game.PlantFactory;
import tp.p1.objects.*;



public class AddCommand extends Command {
	String plant;
	int x;
	int y;

	public AddCommand() {
		super("add","A","Add <plant> <x> <y>: Adds a plant in position x, y.");
	}

	public Command parse(String[] commandWords, Controller controller) {
		Command c = null;
		//AddCommand add = new AddCommand();
		if(commandWords[0].equals(commandName)) {
			c = this; // = add;

			this.setPlant	(commandWords[1]); //almacenamos plantas

			//almacenamos coordenadas
			this.setX(Integer.parseInt(commandWords[2]));
			this.setY(Integer.parseInt(commandWords[3]));

		}else {
			c = null;
		}

		return c;
	}

	public void execute(Game game, Controller controller) {

		Plant plant = PlantFactory.getPlant(this.getPlant(),x,y,game);
		if(game.enoughMoney(Plant.getCost())){
			game.setSameCycle(false);
			if(!game.addPlantToGame(plant, this.getX(), this.getY())){
				controller.setNoPrintGameState();
				game.setSameCycle(true);
			}

		} else {
			System.out.println("You don't have enough coins");
			controller.setNoPrintGameState();
			game.setSameCycle(true);
		}

	}


	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
