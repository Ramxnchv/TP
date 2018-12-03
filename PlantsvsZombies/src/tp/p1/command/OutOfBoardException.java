package tp.p1.command;

public class OutOfBoardException extends Exception {
	public OutOfBoardException() { super(); }
	
	public OutOfBoardException(String message){ super(message); }
	
	public OutOfBoardException(String message, Throwable cause){
	super(message, cause);
	}
	
	public OutOfBoardException(Throwable cause){ super(cause); }
}
