package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class HelpCommand extends NoParamsCommand {
	public HelpCommand() {
		super("help", "H", "Help: Prints this help message");
	}

	public boolean execute(Game game) {
		Game.commandHelp();
		game.setSameCycle(true);
		return false;
	}



}
