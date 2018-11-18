
package tp.p1.game;

import java.util.Scanner;
import tp.p1.command.*;


public class Controller {
	
	private Game game;
	private Scanner in;
	private boolean exit;
	
	
	public Controller(Game game,Scanner in) {
		this.game=game;
		this.in=in;
		exit=false;
	
	}
	

	public void run() {

		String unknownCommandMsg="Comando incorrecto";
		while (game.isNotFinished() && !exit) {
			game.draw();
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandParser.parseCommand(words, this);
			if (command != null) {
				command.execute(game, this);
			}
			else {
				System.err.println (unknownCommandMsg);
				setNoPrintGameState();
			}
		}
		
		if(exit) {
			System.out.println("Thanks for playing Plants vs Zombies");
		}
	}
		
		private void setNoPrintGameState() {
		
		}
		
		public boolean isExit() {
			return exit;
		}

		public void setExit(boolean exit) {
			this.exit = exit;
		}
		
}

