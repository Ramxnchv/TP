package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class HelpCommand extends NoParamsCommand {
	public HelpCommand() {
		super("Help", "H", "Help: Prints this help message");
	}

	public void execute(Game game, Controller controller) {

		Game.commandHelp();
	}

	public static Command createHelpCommand() {

		HelpCommand hC = new HelpCommand();

		return hC;

	}

}
