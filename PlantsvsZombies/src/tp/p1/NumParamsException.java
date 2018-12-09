package tp.p1;

public class NumParamsException extends Exception{
public NumParamsException() { super(); }
	
	public NumParamsException(String message){ super(message); }
	
	public NumParamsException(String message, Throwable cause){
	super(message, cause);
	}
	
	public NumParamsException(Throwable cause){ super(cause); }
}
