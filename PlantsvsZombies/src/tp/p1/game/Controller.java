
package tp.p1.game;

import java.util.Scanner;
import tp.p1.command.*;


public class Controller {

	private Game game;
	private Scanner in;
	private boolean exit;
	private boolean noPrint;


	public Controller(Game game,Scanner in) {
		this.game=game;
		this.in=in;
		exit=false;
		noPrint=false;
	}


	public void run() {
		try {
			String unknownCommandMsg="Comando incorrecto";
			while (game.isNotFinished(noPrint) && !exit) {
				noPrint=false;
				System.out.println("Command >");
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
		}
		catch(CommandParseException p) {
			System.out.println(p.getMessage());
		}
		catch(CommandExecuteException e) {
			System.out.println(e.getMessage());
		}
		if(exit) {
			System.out.println("Thanks for playing Plants vs Zombies");
		}
		else if(game.checkWinnerZombie()) {
			System.out.println("Zombies win");
		}
		else {
			System.out.println("Plants win");
		}
	}




		//metodos para controlar print y exit

		public boolean isExit() {
			return exit;
		}

		public void setExit(boolean exit) {
			this.exit = exit;
		}

		public boolean getNoPrintGameState() {
			return noPrint;
		}


		public void setNoPrintGameState() {
			this.noPrint = true;
		}

}
