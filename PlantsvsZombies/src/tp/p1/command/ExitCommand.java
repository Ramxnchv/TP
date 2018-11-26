package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class ExitCommand extends NoParamsCommand {
	public ExitCommand() {
		super("exit", "E", "Exit: finish the program");
	}

	public void execute(Game game, Controller controller) {
		controller.setExit(true);
		controller.setNoPrintGameState();
	}


}
