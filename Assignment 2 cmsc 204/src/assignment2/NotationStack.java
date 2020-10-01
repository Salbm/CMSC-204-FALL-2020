package assignment2;

import java.util.ArrayList;

import java.util.Collections;
/**
 * 
 * @author steph
 *
 * @param <T>
 */
public class NotationStack<T> implements StackInterface {

	private ArrayList<T> stackElements;
	private int maxSize= 100;
	
	/** Constructor sets size
	 * @param stackSize
	 */
	
	public NotationStack(int stackSize) {
		
		this.maxSize = stackSize;
		stackElements = new ArrayList<T>(stackSize);
	}
	
	/**
	 * normal constructor
	 */
	public NotationStack() {
		this(100);
	}
	
	/**copies arraylist for stack
	 * 
	 * @param list array to be copied
	 */
		public NotationStack(ArrayList<T> list) {
			this.stackElements=(ArrayList<T>) list;
			
		}
	
	/**
	 * checks if the stack is empty
	 * @return true if empty, false if not
	 * 
	 */
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		if(stackElements.size() == 0)
			
			return true;
		else
			
		return false;
	}

	/**checks if the stack is full
	 * @return true if full, false if not
	 */
	
	public boolean isFull() {
		// TODO Auto-generated method stub
		
		if(stackElements.size()== maxSize) 
			
			return true;
					
		else
				
		return false;
	}

	/**
	 * removes an object from the stack if used
	 * @return object that was removed
	 * @throws StackUnderflowExcepetion
	 */
	
	public Object pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		
		if(this.isEmpty()) {
			
			throw new StackUnderflowException();
		}
		
		else {
			
			T result = stackElements.get(stackElements.size()-1);
			
			stackElements.remove(stackElements.size()-1);
			
		return result;
				
			
		}
	}

	/**
	 * gives a glimpse at the top of the stack
	 * @return top of the stack
	 */
	
	public Object top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		
		if(this.isEmpty()) {
			
			throw new StackUnderflowException();
			
		}
		
		else {
			return stackElements.get(stackElements.size()-1);
		}
		
	}

	/**
	 * checks size of stack
	 * @return size of stack
	 */
	
	public int size() {
		// TODO Auto-generated method stub
		return stackElements.size();
	}

	/**
	 * adds object
	 * @returns true if added successfully
	 * @throws StackOverflowException
	 */
	
	public boolean push(Object e) throws StackOverflowException {
		// TODO Auto-generated method stub
		
		if(this.isFull()) {
			
			throw new StackOverflowException();
		}
		
		else
			stackElements.add((T)e);
		
		return true;
	}

	/**
	 * String method of stack
	 * @returns string of stack
	 */
	
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		
		String stackString ="";
		for( T elements: stackElements) {
			if (stackElements.indexOf(elements)==stackElements.size()-1) {
				
				stackString +=elements;
			}
		}
		return stackString;
	}

	/**
	 * Fills stack with the elements from the arrayList
	 * @param list elements to be added to the stack
	 */
	
	public void fill(ArrayList list) {
		// TODO Auto-generated method stub
		ArrayList<T> listCopy=new ArrayList<T>(list);
		stackElements.addAll(listCopy);
	}
	

	
}
