package tp.p1.command;

import tp.p1.game.Controller;
import tp.p1.game.Game;

public class CatchCommand extends Command {

	private int x;
	private int y;

	public CatchCommand() {
		super("Catch","C","Catch <x> <y>: Catches a sun in position x, y.");
	}

	public Command parse(String[] commandWords, Controller controller) {
		Command c = null;
		//AddCommand add = new AddCommand();
		if(commandWords[0].equals("c")||commandWords[0].equals("catch")) {
			c = this; // = add;
			this.setX(Integer.parseInt(commandWords[1]));
			this.setY(Integer.parseInt(commandWords[2]));

		}else {
			c = null;
		}

		return c;
	}

	public void execute(Game game, Controller controller) {
		if(!game.isSameCycle()) {
			game.setSameCycle(true);
			if(!game.catchSun(x, y)) {
				System.out.println("Can't find a sun in that position or you're in the same cycle,try again");
				controller.setNoPrintGameState();
			}
		} else {
			System.out.println("You already caught one sun: you can't get more than 1");
			controller.setNoPrintGameState();
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
