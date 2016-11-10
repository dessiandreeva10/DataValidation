
public class IllegalBulstatException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	
	public IllegalBulstatException(){
		super();
	}
	
	public String getMessage(){
		return "Bulstat should start with BG and should contain nine numbers. Example: BG123456789;";
	}
	
}
