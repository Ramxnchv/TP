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

	public Command parse (String[] commandWords) throws CommandParseException {
		try {
		Command c = null;
		//AddCommand add = new AddCommand();
		if(commandWords.length!=4) {
			throw new CommandParseException("Incorrect number of arguments for add command");
		}
		if(commandWords[0].equals(commandName)) {
			c = this; // = add;

			this.setPlant	(commandWords[1]); //almacenamos plantas

			//almacenamos coordenadas
			this.setX(Integer.parseInt(commandWords[2]));
			this.setY(Integer.parseInt(commandWords[3]));
		}
		
		return c;
		
		}catch(NumberFormatException e) {
			throw new CommandParseException("Invalid argument for add command, number expected");
		}
		
	}

	public boolean execute(Game game) throws CommandExecuteException {
		boolean added=false;
		try {
			Plant plant = PlantFactory.getPlant(this.plant,x,y,game);
			if(plant==null) {
				throw new CommandExecuteException("Unknown Plant Name");
			}
		
			added=game.addPlantToGame(plant, x, y);
			
		}
		catch(NoSuncoinsException e) {
			System.out.println(e.getMessage());
			game.setSameCycle(true);
			added= false;
		}
		catch(NotEmptyPositionException em) {
			System.out.println(em.getMessage());
			game.setSameCycle(true);
			added= false;
		}
		catch(OutOfBoardException ob) {
			System.out.println(ob.getMessage()+ "is an invalid position");
			game.setSameCycle(true);
			added= false;
		}
		return added;
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
