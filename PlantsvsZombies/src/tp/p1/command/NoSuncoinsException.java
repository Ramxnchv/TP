package tp.p1.command;

public class NoSuncoinsException extends Exception {
	public NoSuncoinsException() { super(); }
	
	public NoSuncoinsException(String message){ super(message); }
	
	public NoSuncoinsException(String message, Throwable cause){
	super(message, cause);
	}
	
	public NoSuncoinsException(Throwable cause){ super(cause); }
	
}
