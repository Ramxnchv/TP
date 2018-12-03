package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class ListCommand extends NoParamsCommand {


	public ListCommand() {
		super("list", "L", "List: Prints the list of available plants.");
	}

	public boolean execute(Game game) {
		game.printList();
		game.setSameCycle(true);
		return false;
	}

}
