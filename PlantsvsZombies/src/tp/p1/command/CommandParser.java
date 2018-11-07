package tp.p1.command;

import tp.p1.game.Controller;

public class CommandParser extends Command {
	private static Command[] avaiableCommand = {
		new AddCommand(),
		new HelpCommand(),
		new ResetCommand(),
		new ExitCommand(),
		new ListCommand(),
		new NoneCommand()
	}
	
	public Command parse(String[] commandWords, Controller controller) {
		boolean found=false;
		int i=0;
		Command c;
		while(i<avaiableCommand.length&&!found) {
			c=avaiableCommand[i].parse(commandWords, controller);
			if(c!=null) {
				found=true;
			}
			else {
				i++;
			}
		}
		return c;
	}
	
}
