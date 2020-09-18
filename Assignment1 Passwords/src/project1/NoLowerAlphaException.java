package project1;

public class NoLowerAlphaException extends Exception{

	/**
	 * Exception when the password doesn't have any character lower case
	 * 
	 * @author Stephanie Albornoz
	 */
		public NoLowerAlphaException() {
			super("Password should have at least one lowercase character");
}
}
