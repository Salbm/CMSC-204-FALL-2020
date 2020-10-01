package assignment2;

/**
 * Stack Underflow Exception
 * @author steph
 *
 */
public class StackUnderflowException extends Exception {

	/**
	 * constructor of StackUnderflowException
	 */
	StackUnderflowException(){
		
		super("Error stack is underflown ");
}
}