package tp.p1.command;

import tp.p1.game.Game;

public class NoParamsCommand extends Command{

	public NoParamsCommand(String commandText, String commandTextMsg, String helpTextMsg) {
		super(commandText, commandTextMsg, helpTextMsg);
	}

	public Command parse(String[] commandWords) throws CommandParseException{
		Command c=null;
		
		if(commandWords[0].equals(commandName))
		{
			c = this;
			if(commandWords.length!=1) {
				throw new CommandParseException(commandName+" command has no arguments");
			} 
			

		}else {
			c = null;
		}

		return c;
	}

	public boolean execute(Game game) {
		return false;
	}

}
