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
			c = new HelpCommand();

		} else if (commandWords[0].equals("r")||commandWords[0].equals("reset")) {

			c = new ResetCommand();

		} else if (commandWords[0].equals("l")||commandWords [0].equals("list")) {

			c = new ListCommand();
			
		} else if (commandWords[0].equals("e") || commandWords[0].equals("exit")) {
			
			c = new ExitCommand();
			
		}
		else if (commandWords[0].equals("") || commandWords[0].equals("none")) {
			
			c = new NoneCommand();
			
		} else if (commandWords[0].equals("p") || commandWords[0].equals("print")) {
			c = new PrintModeCommand();
			
		} else {
			
			c = null;
			
		}

		return c;
	}

	
	public void execute(Game game, Controller controller) {
		// TODO Auto-generated method stub

	}

}
