package tp.p1.command;

public class NotEmptyPositionException extends Exception{
	public NotEmptyPositionException() { super(); }
	
	public NotEmptyPositionException(String message){ super(message); }
	
	public NotEmptyPositionException(String message, Throwable cause){
	super(message, cause);
	}
	
	public NotEmptyPositionException(Throwable cause){ super(cause); }
}
