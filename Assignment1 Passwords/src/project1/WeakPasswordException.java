package project1;

public class WeakPasswordException extends Exception{
	/**
	 * Exception when the password is too 
	 * @author Stephanie Albornoz
	 */
		public WeakPasswordException() {
			super("Password is too weak");
		}
	
}
