package project1;

public class NoSpecialSymbolException extends Exception {
	/**
	 * Exception when the password doesn't have any character lower case
	 * 
	 * @author Stephanie Albornoz
	 */
		public NoSpecialSymbolException() {
			super("Password should have at least one special symbol");
			
		}
}
