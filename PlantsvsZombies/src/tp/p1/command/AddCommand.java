package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

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
			} else if(commandWords[1].equals("s") || commandWords[1].equals("sunflower")) {
				this.setPlant("sunflower");
			}

			this.setX(Integer.parseInt(commandWords[2]));
			this.setY(Integer.parseInt(commandWords[3]));

		}else {
			c = null;
		}

		return c;
	}

	public void execute(Game game, Controller controller) {
		game.add(this.getPlant(), this.getX(), this.getY());
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
