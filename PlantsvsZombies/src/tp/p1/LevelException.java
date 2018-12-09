package tp.p1;

public class LevelException extends Exception {
	public LevelException() { super(); }
	
	public LevelException(String message){ super(message); }
	
	public LevelException(String message, Throwable cause){
	super(message, cause);
	}
	
	public LevelException(Throwable cause){ super(cause); }
}
