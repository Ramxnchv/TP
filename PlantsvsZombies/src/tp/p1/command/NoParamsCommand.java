package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class NoParamsCommand extends Command{

	public NoParamsCommand(String commandText, String commandTextMsg, String helpTextMsg) {
		super(commandText, commandTextMsg, helpTextMsg);
	}

	public Command parse(String[] commandWords) {
		Command c=null;

		if(commandWords[0].equals(commandName))
		{
			c = this;

		}

		return c;
	}


	public boolean execute(Game game) {
		return true;
	}

}
