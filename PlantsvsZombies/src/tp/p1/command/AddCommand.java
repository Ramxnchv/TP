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
		super("Add","A","Add <plant> <x> <y>: Adds a plant in position x, y.");
	}

	public Command parse(String[] commandWords, Controller controller) {
		Command c = null;
		//AddCommand add = new AddCommand();
		if(commandWords[0].equals("a")||commandWords[0].equals("add")) {
			c = this; // = add;
			if (commandWords[1].equals("p") || commandWords[1].equals("peashooter"))
			{
				this.setPlant("peashooter");
			}
			else if(commandWords[1].equals("s") || commandWords[1].equals("sunflower")) {
				this.setPlant("sunflower");
			}
			else if(commandWords[1].equals("c") || commandWords[1].equals("petacereza")) {
				this.setPlant("petacereza");
			}
			else if(commandWords[1].equals("n") || commandWords[1].equals("nuez")){
				this.setPlant("nuez");
			}

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
			if(!game.addPlantToGame(plant, this.getX(), this.getY())){
				controller.setNoPrintGameState();
			}
			
		} else {
			System.out.println("You don't have enough coins");
			controller.setNoPrintGameState();
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
