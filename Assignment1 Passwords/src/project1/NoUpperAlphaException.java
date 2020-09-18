package project1;

public class NoUpperAlphaException extends Exception{

	/**
	 * Exception when the password doesn't have any character upper case
	 * 
	 * @author Stephanie Albornoz
	 * 
	 * 
	 */
	
	private static final long serialVersionUID = -2485490956722223156L;
			
		public NoUpperAlphaException() {
			super("Password should have at least one upper case character");
			
		}
}
