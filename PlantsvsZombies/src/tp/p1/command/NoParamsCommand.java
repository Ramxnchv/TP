package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class NoParamsCommand extends Command{

	public NoParamsCommand(String commandText, String commandTextMsg, String helpTextMsg) {
		super(commandText, commandTextMsg, helpTextMsg);
	}

	public Command parse(String[] commandWords, Controller controller) {
		Command c;

		if(commandWords[0].equals("h") || commandWords[0].equals("help"))
		{
			c = HelpCommand.createHelpCommand();

		} else if (commandWords[0].equals("r")||commandWords[0].equals("reset")) {

			c = ResetCommand.createResetCommand();

		} else if (commandWords[0].equals("l")||commandWords [0].equals("list")) {

			c = ListCommand.createListCommand();
		} else if (commandWords[0].equals("e") || commandWords[0].equals("exit")) {
			c = ExitCommand.creatExitCommand();
		}
		else if (commandWords[0].equals("") || commandWords[0].equals("none")) {
			c = NoneCommand.createNoneCommand();
		} else {
			c = null;
		}

		return c;
	}

	@Override
	public void execute(Game game, Controller controller) {
		// TODO Auto-generated method stub

	}

}
