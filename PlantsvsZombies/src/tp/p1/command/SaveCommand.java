package tp.p1.command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import tp.p1.game.Game;
import tp.p1.util.MyStringUtils;

public class SaveCommand extends Command {

	private String file;
	
	public SaveCommand() {
		super("save","S","Save <filename>: Save the state of the game to a file.");
	}
	
	public Command parse(String[] commandWords) throws CommandParseException{
		Command c=null;
		if(commandWords.length!=2) {
			throw new CommandParseException("Incorrect number of arguments for save command: Save <filename>");
		}
		if(!MyStringUtils.isValidFilename(file)) {
			throw new CommandParseException("Invalid filename: the filename contains invalid characters");
		}
		if(commandWords[0].equals(commandName)) {
			c=this;
		}else {
			throw new CommandParseException("Unknown command. Use ’help’ to see the available commands");
		}
		return c;
	}
	public boolean execute(Game game) throws CommandExecuteException{
		final String header="plantVSZombies 3.0";
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(file))){
			bw.write(header);
			bw.newLine();
			bw.newLine();
			game.store();
			System.out.println("Game successfully saved in file "+ this.file +".dat. Use the load command to reload it");
			return false;
		}catch(IOException e) {
			throw new CommandExecuteException();
		}
	}
}
