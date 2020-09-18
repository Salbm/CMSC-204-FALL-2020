package project1;

public class LengthException extends Exception{
	
	/**
	 * Exception when the password is too short
	 * (Less than 6 characters)
	 * @author Stephanie Albornoz
	 */
	public LengthException() {
		
		super("Password is too short");
	}
}
