package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class NoneCommand extends NoParamsCommand{
	public NoneCommand() {
		super("[none]", "", "[none]: Skips cycle.\n");
	}


	public void execute(Game game, Controller controller) {
		game.executeNoneCommand();
	}


	public static Command createNoneCommand() {

		NoneCommand nC = new NoneCommand();

		return nC;
	}
}
