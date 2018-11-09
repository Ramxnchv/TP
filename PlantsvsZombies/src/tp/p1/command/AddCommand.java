package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class AddCommand extends Command {
	String plant;
	String x;
	String y;
	
	public AddCommand() {
		super("Add","A","Add <plant> <x> <y>: Adds a plant in position x, y.");
	}
	
	public Command parse(String[] commandWords, Controller controller) {
		
	}
	
	public void execute(Game game, Controller controller) {
		game.add(x, y);
	}
	
}
