package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class NoParamsCommand extends Command{

	public NoParamsCommand(String commandText, String commandTextMsg, String helpTextMsg) {
		super(commandText, commandTextMsg, helpTextMsg);
	}

	public Command parse(String[] commandWords, Controller controller) {
		Command c;

		if(commandWords[0].equals(commandName))
		{
			c = this;

		} else {

			c = null;

		}

		return c;
	}


	public void execute(Game game, Controller controller) {
		// TODO Auto-generated method stub

	}

}
