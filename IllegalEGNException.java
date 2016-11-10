
public class IllegalEGNException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllegalEGNException(){
		super();
	}
	
	public String getMessage(){
		return "EGN should contain 10 numbers!";
	}
}
