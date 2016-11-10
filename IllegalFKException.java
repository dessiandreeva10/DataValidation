
public class IllegalFKException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllegalFKException(){
		super();
	}
	
	public String getMessage(){
		return "Facility number is not correct. It should have credit number and its type number.";
	}

}
