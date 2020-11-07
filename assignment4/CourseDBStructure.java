package assignment4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Structure class with data for the creation of the CourseDBStructure object in the manager class.
 * @author steph
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface{

	protected int hashSize = 0;
	protected int sizeElement = 0;
	
	protected LinkedList [] hashTable;
	
	
	/**
	 * Constructor that sets the size of the hash
	 * @param StructureSize
	 */
	public CourseDBStructure(int structureSize) {
		
		hashSize = structureSize;
		
		hashTable = new LinkedList[hashSize];
	}
	


	/**
	 * Constructor for testing
	 * @param structureSize
	 */
	public CourseDBStructure(String test, int structureSize) {
		// TODO Auto-generated constructor stub
		
        hashSize = structureSize;
		
		hashTable = new LinkedList[hashSize];
		
	}


	/**
	 * Uses hashcode to add elements to the table, if the element currently does not exist in the hash table.
	 * @param element to be added
	 */
	@Override
	public void add(CourseDBElement element) {
		// TODO Auto-generated method stub
		
		int x;
		
		x = Math.abs(element.hashCode())% hashSize;
		
		LinkedList <CourseDBElement>present = hashTable[x];
		
		if(present ==null) {
			
			hashTable[x]= new LinkedList<CourseDBElement>();
			
			
		}
		
		hashTable[x].add(element);
		
		sizeElement++;	
	}

	/**
	 * Uses hashcode to find if element is in the hashtable, if it's not throws IOException.
	 * @returns CRN
	 * @throws IOException when item is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		// TODO Auto-generated method stub
		
		String firstCrn = Integer.toString(crn);
		int x = Math.abs(firstCrn.hashCode())% hashSize;
		
		if(hashTable[x] == null){
			
			throw new IOException();
		}
				
		else {
			
			return (CourseDBElement) hashTable[x].get(0);
		}
	}

	/**
	 * returns size of table
	 *  
	 * @return hashSize
	 */
	@Override
	public int getTableSize() {
		// TODO Auto-generated method stub
		return hashSize;
	}



	/**
	 * Method that prints all data of courses
	 * 	
	 * @return courseData
	 */
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		
		
ArrayList<String>courseData =new ArrayList<String>();
		
		for(int k= 0; k<hashSize; k++) {
			
			while(hashTable[k] !=null) {
				
				for(int x=0; x < hashTable[k].size();x++) {
					
					CourseDBElement courseElement =(CourseDBElement)hashTable[k].get(x);
					
					courseData.add( "\n" + courseElement.toString());
				}
				
				break;
			}
		}
		
		return courseData;
	}
	
}

