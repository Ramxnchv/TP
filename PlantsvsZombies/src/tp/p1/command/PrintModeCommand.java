package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;
import tp.p1.printer.Debug;
import tp.p1.printer.GamePrinter;
import tp.p1.printer.Release;

public class PrintModeCommand extends Command {

	private String mode;
	private int x=4;
	private int y=8;

	public PrintModeCommand() {
		super("printmode", "P", "[P]rintMode: change print mode [Release|Debug].");
	}

	public boolean execute(Game game) throws CommandExecuteException {
		GamePrinter gp;
		if(mode.equals("debug")) {
			gp=new Debug(game,x,y);
		}
		else {
			gp=new Release(game,x,y);
		}
		game.setGamePrinter(gp);
		game.draw();
		game.setSameCycle(true);
		return true;
	}

	public Command parse(String[] commandWords) throws CommandParseException {
		Command c = null;

		if(commandWords[0].equals(commandName)) {
			if(commandWords.length!=2) {
				throw new CommandParseException("Unknown print mode: "+commandWords[1]);
			} else {
				
				c = this;

				mode = commandWords[1];
			}

		}else {
			c = null;
		}
		
		return c;
	}
}
