package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class ListCommand extends NoParamsCommand {


	public ListCommand() {
		super("List", "L", "List: Prints the list of available plants.");
	}

	public void execute(Game game, Controller controller) {

		game.printList();

	}

	public static Command createListCommand()
	{
		ListCommand lC = new ListCommand();

		return lC;
	}
}
