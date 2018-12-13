package tp.p1.command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import tp.p1.game.Game;
import tp.p1.util.MyStringUtils;

public class SaveCommand extends Command {

	private String file;
	final String header="“Plants Vs Zombies v3.0”";
	
	public SaveCommand() {
		super("save","S","Save <filename>: Save the state of the game to a file.");
	}
	
	public Command parse(String[] commandWords) throws CommandParseException{
		Command c=null;
		
		if(commandWords[0].equals(commandName)) {
			c=this;
			if(commandWords.length!=2) {
				throw new CommandParseException("Incorrect number of arguments for save command: Save <filename>");
			}
			
			file = commandWords[1];
			
			if(!MyStringUtils.isValidFilename(file)) {
				throw new CommandParseException("Invalid filename: the filename contains invalid characters");
			}
		}else {
			c = null;
		}
		return c;
	}
	public boolean execute(Game game) throws CommandExecuteException{
		
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(file))){
			bw.write(header);
			bw.newLine();
			bw.newLine();
			game.store(bw);
			System.out.println("Game successfully saved in file "+ this.file +".dat. Use the load command to reload it");
			return false;
			
		}catch(IOException e) {
			throw new CommandExecuteException();
		}
	}
}
