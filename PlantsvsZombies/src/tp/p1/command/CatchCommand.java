package tp.p1.command;

import tp.p1.game.Game;

public class CatchCommand extends Command {

	private int x;
	private int y;

	public CatchCommand() {
		super("catch","C","Catch <x> <y>: Catches a sun in position x, y.");
	}

	public Command parse(String[] commandWords) throws CommandParseException {
		Command c = null;


		if(commandWords[0].equals(commandName)) {
			if(commandWords.length!=3) {
				throw new CommandParseException("Incorrect number of arguments for catch command: Catch <x> <y>");
			} else {

				c = this;
				this.setX(Integer.parseInt(commandWords[1]));
				this.setY(Integer.parseInt(commandWords[2]));
			}


		}else {
			throw new CommandParseException("Unknown command. Use ’help’ to see the available commands");
		}

		return c;
	}

	public boolean execute(Game game) throws CommandExecuteException {
		if(!game.isSameCycle()) {
			game.setSameCycle(true);
			if(!game.catchSun(x, y)) {
				throw new CommandExecuteException("Can't find a sun in that position or you're in the same cycle,try again");
			}
		} else {
			throw new CommandExecuteException("You already caught one sun: you can't get more than 1");
		}
		return true;
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
