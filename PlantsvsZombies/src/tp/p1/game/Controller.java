
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
		while (game.isNotFinished()) {
			System.out.println("Command >");
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			try {
				Command command = CommandParser.parseCommand(words);
				if (command != null) {
					if(command.execute(game)) {
						game.draw();
					}
				}
				else {
					System.err.println (unknownCommandMsg);
					
				}
			} catch (CommandParseException | CommandExecuteException ex) {
			System.out.format(ex.getMessage() + "%n%n");
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
	}


		//metodos para controlar exit

		public boolean isExit() {
			return exit;
		}

		public void setExit(boolean exit) {
			this.exit = exit;
		}
}
