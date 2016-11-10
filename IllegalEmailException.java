
public class IllegalEmailException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllegalEmailException(){
		super();
	}
	
	public String getMessage(){
		return "Email is not correct! Try again!";
	}
}
