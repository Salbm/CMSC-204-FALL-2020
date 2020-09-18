package project1;

public class NoDigitException extends Exception {


	/**
	 * Exception when the password is doesn't have a numerical digit
	 * @author Stephanie Albornoz
	 */
		public NoDigitException() {
			super("Password should contain at least one digit");
		}
		
}
