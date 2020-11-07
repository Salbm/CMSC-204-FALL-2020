package assignment4;

/**
 * Course data estructure element class
 * @author steph
 *
 */
public class CourseDBElement {

	protected int courseCredits;
	protected int courseCRN;
	protected String courseID;
	protected String courseRoomNumber;
	protected String courseInstructorName;
	
	/**
	 * Default Constructor 
	 */
	
	public CourseDBElement(){
		
		this(null,00000,0,null,null);
	}

	/**Constructor that assigns values accordingly
	 * 
	 * @param ID
	 * @param crn
	 * @param credits
	 * @param prof
	 * @param room
	 */
	public CourseDBElement(String ID, int crn, int credts, String prof, String room) {
		// TODO Auto-generated constructor stub
		
		courseID=ID;
		courseRoomNumber=room;
		courseInstructorName=prof;
		this.courseCRN= crn;
		this.courseCredits=credts;
		
	}
	
	/**
	 * sets crn
	 * @param courseCrn
	 */
	public void setCRN(int courseCRN) {
		this.courseCRN=courseCRN;
	}
	
	/**
	 *returns crn
	 * @return courseCRN
	 */
	public int getCRN() {
		return courseCRN;
	}

	/**
	 * Compares CRN of 2 different course elements
	 * @param courseElement
	 */
	public int compareTo(CourseDBElement courseElement) {
		
		if (courseElement.courseCRN==courseCRN) {
			
			return 0;
		}
		else if (courseElement.courseCRN<courseCRN) {
			
			return -1;
		}
		else {
			
			return 1;
		}
		
	}
	
	/**
	 * Parse crn from int to string
	 * @return hashcode
	 */
	public int hashCode() {
		
		String crn =Integer.toString(courseCRN);
		
		return crn.hashCode();
	}
	
	/**
	 * @return string courseInfo
	 */
	
	public String toString() {
		
		String courseInfo=" Course ID : "+courseID+" Course CRN: "+courseCRN+" Course Credits: "+courseCredits+" Course Instructor: "+courseInstructorName+"  Room Number:  "+courseRoomNumber;
		
		return courseInfo;
	}
}

