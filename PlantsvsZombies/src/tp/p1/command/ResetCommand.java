package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class ResetCommand extends NoParamsCommand {
	public ResetCommand() {
		super("reset", "R", "Reset: Starts a new game.");
		// TODO Auto-generated constructor stub
	}


	public void execute(Game game, Controller controller) {
		game.inicializar();
	}


}
