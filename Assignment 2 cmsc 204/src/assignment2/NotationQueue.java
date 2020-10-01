package assignment2;

import java.util.ArrayList;
/**
 * Implements QueueInterface
 * @author steph
 *
 * @param <T>
 */

public class NotationQueue<T> implements QueueInterface <T> {

	int front,back,elements = 0;
	private ArrayList<T>queueList;
	private int queueSize;
	
	/**
	 * Constructor that sets the size of the queue
	 */
	public NotationQueue() {
		
		queueSize = 5;
		queueList =new ArrayList<T>(queueSize);
	}
	
	public NotationQueue(int size) {
		
		queueSize = size;
		
		queueList =new ArrayList<T>(queueSize);
	}
	/**
	 * method to see if queue is empty or not
	 * @return true if empty, false if not
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		if(elements == 0)
			return true;
		else
			
		return false;
	}

	/**
	 * Determines if the queue is full or not
	 * @return true if full, false if not
	 */
	public boolean isFull() {
		// TODO Auto-generated method stub
		
		if(elements == queueSize)
			return true;
		
		else
			
		return false;
	}

	/**
	 * Deletes an item from the queue and returns it 
	 * @return said element
	 */

	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		
		if(elements == 0) {
			throw new QueueUnderflowException();
			
		}
		else {
			
			queueList.set(front, null);
			front++;
			
			elements--;
		}
		return queueList.get(front);
	}

	/**
	 * Tells number of elements in queue
	 * @return number of elements in queue
	 */
	public int size() {
		// TODO Auto-generated method stub
		return elements;
	}

	/**
	 * Adds an element to the queue
	 * @param e element added to the queue
	 * @return true if element was added successfully, false if not
	 */
	
	public boolean enqueue(T e) throws QueueOverflowException {
		// TODO Auto-generated method stub
		
		if(elements ==queueSize) {
			throw new QueueOverflowException();
		}
		
		else {
			queueList.add(back,e);
			back++;
			elements++;
			
			return true;
		}
		
	}

	
	/**
	 * String representation of the elements in the queue
	 * @returns string representation of the queue
	 */
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		
		String stringQueue ="";
		
		for (T k : queueList) {
			
			stringQueue +=k+delimiter;
		}
		return stringQueue;
	}

	
	/**
	 * fills queue with elements from the arraylist
	 * @param list of elements that are added to the queue
	 */
	
	public void fill(ArrayList<T> list) {
		// TODO Auto-generated method stub
		
		ArrayList<T> copy = new ArrayList<T>(list);
		
		queueList.addAll(copy);
		
		
		
	}

}
