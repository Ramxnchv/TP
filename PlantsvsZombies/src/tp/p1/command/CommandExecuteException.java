package tp.p1.command;

public class CommandExecuteException extends Exception {
	public CommandExecuteException() { super(); }
	
	public CommandExecuteException(String message){ super(message); }
	
	public CommandExecuteException(String message, Throwable cause){
	super(message, cause);
	}
	
	public CommandExecuteException(Throwable cause){ super(cause); }
}
