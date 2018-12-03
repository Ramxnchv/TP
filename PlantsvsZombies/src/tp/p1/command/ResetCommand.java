package tp.p1.command;

import tp.p1.game.Game;

public class ResetCommand extends NoParamsCommand {
	public ResetCommand() {
		super("reset", "R", "Reset: Starts a new game.");
		// TODO Auto-generated constructor stub
	}


	public boolean execute(Game game) {
		game.inicializar();
		return true;
	}


}
