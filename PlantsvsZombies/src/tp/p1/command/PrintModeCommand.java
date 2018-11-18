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
		super("PrintMode", "P", "[P]rintMode: change print mode [Release|Debug].");
	}
	
	public void execute(Game game, Controller controller) {
		GamePrinter gp;
		if(mode.equals("debug")) {
			gp=new Debug(game,x,y);
		}
		else {
			gp=new Release(game,x,y);
		}
		game.setGamePrinter(gp);
	}
	
	public Command parse(String[] commandWords, Controller controller) {
		Command c;
		if(commandWords[1].equals("d")||commandWords[1].equals("debug")) {
			c=this;
			mode="debug";
		}
		else if(commandWords[1].equals("d")||commandWords[1].equals("debug")) {
			c=this;
			mode="release";
		}
		else {
			c=null;
		}
		return c;
	}
}
