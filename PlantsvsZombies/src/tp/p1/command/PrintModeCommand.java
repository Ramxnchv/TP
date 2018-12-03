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
		super("printMode", "P", "[P]rintMode: change print mode [Release|Debug].");
	}

	public boolean execute(Game game) {
		GamePrinter gp;
		if(mode.equals("debug")) {
			gp=new Debug(game,x,y);
		}
		else {
			gp=new Release(game,x,y);
		}
		game.setGamePrinter(gp);
		game.draw();
		controller.setNoPrintGameState();
		game.setSameCycle(true);
	}

	public Command parse(String[] commandWords) {
		Command c = null;

		if(commandWords[0].equals(commandName)) {
			c = this;

			mode = commandWords[1];
		}
		else {
			c=null;
		}
		return c;
	}
}
