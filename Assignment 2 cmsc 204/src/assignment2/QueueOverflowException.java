package assignment2;
/**
 * Queue over flow exception
 * @author steph
 *
 */
public class QueueOverflowException extends Exception {
	
	/**
	 * constructor of QueueOverflowException
	 */
	QueueOverflowException(){
		
		super("Error queue is full");
	}
}
