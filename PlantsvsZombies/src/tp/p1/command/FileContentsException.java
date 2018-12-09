package tp.p1.command;

public class FileContentsException extends Exception {
	public FileContentsException() { super(); }
	
	public FileContentsException(String message){ super(message); }
	
	public FileContentsException(String message, Throwable cause){
	super(message, cause);
	}
	
	public FileContentsException(Throwable cause){ super(cause); }
}
