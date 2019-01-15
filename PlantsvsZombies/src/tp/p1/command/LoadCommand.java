package tp.p1.command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tp.p1.game.Game;
import tp.p1.util.MyStringUtils;

public class LoadCommand extends Command {

	String fileName;
	final String header="“Plants Vs Zombies v3.0”";

	public LoadCommand() {
		super("load","l","Load <filename>: Save the state of the game to a file.");
	}

	public Command parse(String[] commandWords) throws CommandParseException{
		Command c=null;

		if(commandWords[0].equals(commandName)) {
			c=this;
			
			if(commandWords.length!=2) {
				throw new CommandParseException("Incorrect number of arguments for load command: Load <filename>");
			}
			
			fileName=commandWords[1];
			
			if(!MyStringUtils.isValidFilename(fileName)) {
				throw new CommandParseException("Invalid filename: the filename contains invalid characters");
			}
			if(!MyStringUtils.fileExists(fileName)) {
				throw new CommandParseException("File not found");
			}
			if(!MyStringUtils.isReadable(fileName)) {
				throw new CommandParseException("The file is not readable");
			}

		}else {
			throw new CommandParseException("Unknown command. Use help to see the available commands");
		}

		return c;

	}
	public boolean execute(Game game) throws CommandExecuteException{
		
		try (BufferedReader br = new BufferedReader (new FileReader(fileName))) {

			if(br.readLine().equals(header)) {
				if (game.load(br)) {
					game.setSameCycle(true);
					System.out.println("Game successfully loaded from file "+ this.fileName +".dat. Use the load command to reload it");
				}
			}	
			
		}catch(FileContentsException e) {
			throw new CommandExecuteException("Load failed: invalid file contents");
		}catch(NumberFormatException e) {
			throw new CommandExecuteException("The format of any values of the file are invalid");
		}catch(IOException e) {
			throw new CommandExecuteException(e.getMessage());
		}
		
		return true;

	}
}
