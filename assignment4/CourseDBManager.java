package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Database manager class
 * @author steph
 *
 */
public class CourseDBManager implements CourseDBManagerInterface{

	CourseDBStructure courseStructure =new CourseDBStructure(20);
	
	/**
	 * Creates course object and adds it to the hash table
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		// TODO Auto-generated method stub
		
		CourseDBElement courseElement = new CourseDBElement(id,crn,credits,roomNum,instructor);
		courseStructure.add(courseElement);
		
	}

	@Override
	public CourseDBElement get(int crn) {
		// TODO Auto-generated method stub
		
		try {
			
			return courseStructure.get(crn);
		}
		catch(IOException x){
			
			System.out.println(x.getMessage());
			
		}
		  
		return null;

	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(input);
		
		int credits,CRN;
		
		CourseDBElement courseElement;
		
		String courseInfo;
		
		String[] course;
		
		while (sc.hasNextLine()) {
			
			courseInfo = sc.nextLine();	
			course = courseInfo.split(" ",5);
			CRN = Integer.parseInt(course[1]);
			credits = Integer.parseInt(course[2]);
			courseElement =  new CourseDBElement(course[0],CRN,credits,course[3],course[4]);
			
			courseStructure.add(courseElement);
		}
		
	}

	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		
		return courseStructure.showAll();
	}

}
