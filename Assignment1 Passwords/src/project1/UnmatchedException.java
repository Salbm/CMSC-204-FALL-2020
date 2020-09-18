package project1;

public class UnmatchedException extends Exception{

	/**
	 * Exception when the passwords do not match
	 * @author Stephanie Albornoz
	 */
	public UnmatchedException() {
		
		super("Passwords do not match");
	}
}
