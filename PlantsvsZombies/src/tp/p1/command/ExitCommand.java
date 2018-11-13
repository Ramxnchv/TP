package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class ExitCommand extends NoParamsCommand {
	public ExitCommand() {
		super("Exit", "E", "Exit: finish the program");
	}

	public void execute(Game game, Controller controller) {
		game.setExitTrue(controller.getExit());
	}

	public static Command creatExitCommand() {

		ExitCommand eC = new ExitCommand();

		return eC;
	}


}
