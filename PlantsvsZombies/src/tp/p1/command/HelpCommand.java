package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class HelpCommand extends NoParamsCommand {
	public HelpCommand() {
		super("help", "H", "Help: Prints this help message");
	}

	public void execute(Game game, Controller controller) {
		Game.commandHelp();
		controller.setNoPrintGameState();
		game.setSameCycle(true);
	}



}
