package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class NoneCommand extends NoParamsCommand{
	public NoneCommand() {
		super("", "", "[none]: Skips cycle.\n");
	}


	public boolean execute(Game game) {
		game.executeNoneCommand();
		game.setSameCycle(false);
		return true;
	}



}
