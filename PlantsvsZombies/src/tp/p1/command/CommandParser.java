package tp.p1.command;

import tp.p1.game.Controller;

public class CommandParser {
	
	private static Command[] avaiableCommand = {
		new AddCommand(),
		new HelpCommand(),
		new ResetCommand(),
		new ExitCommand(),
		new ListCommand(),
		new NoneCommand()
	};
	
	public static Command parseCommand(String[] commandWords, Controller controller) {
		boolean found=false;
		int i=0;
		Command c=null;
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
	
	public static String commandHelp() {
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<avaiableCommand.length;i++) {
			sb.append(avaiableCommand[i].helpText());
		}
		
		return sb.toString();
	}
	
}
