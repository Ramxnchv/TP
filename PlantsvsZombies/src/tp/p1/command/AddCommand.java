package tp.p1.command;

import tp.p1.game.Game;
import tp.p1.game.PlantFactory;
import tp.p1.objects.*;


public class AddCommand extends Command {
	private String plant;
	private int x;
	private int y;
	private String plantFullName;

	public AddCommand() {
		super("add","A","Add <plant> <x> <y>: Adds a plant in position x, y.");
	}

	public Command parse (String[] commandWords) throws CommandParseException {
		try {
			
		Command c = null;
		
		if(commandWords[0].equals(commandName)) {
			c = this;
			if(commandWords.length!=4) {
				throw new CommandParseException("Incorrect number of arguments for add command: Add <plant> <x> <y>");
			} else {
				this.setPlant	(commandWords[1]); //almacenamos plantas
			

				//almacenamos coordenadas
				this.setX(Integer.parseInt(commandWords[2]));
				this.setY(Integer.parseInt(commandWords[3]));
			}
				
		}else {
			c = null;
		}
		
		return c;
		
		}catch(NumberFormatException e) {
			throw new CommandParseException("Invalid argument for add command, number expected: Add <plant> <x> <y>");
		}
		
	}

	public boolean execute(Game game) throws CommandExecuteException {
		boolean added=false;
		try {
			Plant plant = PlantFactory.getPlant(this.plant,x,y,game);
			if(plant==null) {
				throw new CommandExecuteException("Unknown Plant Name");
			}
			
			//se guarda el nombre entero de la planta para darlo en los mensajes de error
			this.plantFullName=plant.getName();
			
			added=game.addPlantToGame(plant, x, y);
			
		}
		catch(NoSuncoinsException e) {
			game.setSameCycle(true);
			throw new CommandExecuteException("Failed to add "+plantFullName+":"+e.getMessage());
		}
		catch(NotEmptyPositionException em) {
			game.setSameCycle(true);
			throw new CommandExecuteException("Failed to add "+plantFullName+": position "+em.getMessage()+" is already occupied");
		}
		catch(OutOfBoardException ob) {
			game.setSameCycle(true);
			throw new CommandExecuteException("Failed to add "+plantFullName+": "+ob.getMessage()+" is an invalid position");
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
