package project1;

public class InvalidSequenceException extends Exception {

	/**
	 * Exception when the password contains two of the same characters sequentially
	 * (i.e aa or kk)
	 * @author Stephanie Albornoz
	 */
		public InvalidSequenceException() {
			super("Password can not have a sequence of two of the same characters one after another");
}
}
