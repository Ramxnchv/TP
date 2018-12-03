package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class ExitCommand extends NoParamsCommand {
	public ExitCommand() {
		super("exit", "E", "Exit: finish the program");
	}

	public boolean execute(Game game) {
		controller.setExit(true);
	}


}
