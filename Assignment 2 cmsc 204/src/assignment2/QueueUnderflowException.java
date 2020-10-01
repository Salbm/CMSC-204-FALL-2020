package assignment2;

/**
 * QueueUnderflowException exception
 * @author steph
 *
 */
public class QueueUnderflowException extends Exception {

	/**
	 * constructor of QueueUnderflowException
	 */
	QueueUnderflowException(){
		
		super("Error queue is empty ");
	}
}
