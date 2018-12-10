
package tp.p1.game;

import java.util.Scanner;
import tp.p1.command.*;


public class Controller {

	private Game game;
	private Scanner in;


	public Controller(Game game,Scanner in) {
		this.game=game;
		this.in=in;
	}


	public void run() {
		String unknownCommandMsg="Comando incorrecto";
		game.draw();
		while (game.isNotFinished()&&!game.commandExit()) {
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
			
		}
		if(game.commandExit()) {
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
