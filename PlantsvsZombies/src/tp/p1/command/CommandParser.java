package tp.p1.command;

import tp.p1.game.Controller;

public class CommandParser {
	
	private static Command[] avaiableCommand = {
		new AddCommand(),
		new HelpCommand(),
		new ResetCommand(),
		new ExitCommand(),
		new ListCommand(),
		new PrintModeCommand(),
		new CatchCommand(),
		new NoneCommand()

	};
	
	public static Command parseCommand(String[] commandWords) throws CommandParseException {
		boolean found=false;
		int i=0;
		Command c=null;
		while(i<avaiableCommand.length&&!found) {
			c=avaiableCommand[i].parse(commandWords);
			if(c!=null) {
				found=true;
			}
			else {
				i++;
			}
		}
		return c;
	}
	
	public static String commandHelp() {
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<avaiableCommand.length;i++) {
			sb.append(avaiableCommand[i].helpText()).append("\n");
		}
		
		return sb.toString();
	}
	
}
