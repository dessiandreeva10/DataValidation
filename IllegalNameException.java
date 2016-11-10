
public class IllegalNameException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllegalNameException(){
		super();
	}
	
	public String getMessage(){
		return "Wrong name entered! Make sure that every part of your name starts with capital letter and it contains more than one letter!";
	}
}
