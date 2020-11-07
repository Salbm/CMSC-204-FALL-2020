package assignment4;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 * @author steph
 *
 */
public class CourseDBManagerTest_StudentTEST {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC204",30504,4,"SC350","Momo Cashew Nut");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC204",30504,4,"SC450","Momo Cashew");
		dataMgr.add("CMSC207",30503,4,"SC450","Mr Whiskers");
		dataMgr.add("CMSC201",30559,4,"SC450","Chris Evans");
		ArrayList<String> list = dataMgr.showAll();
		
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:30503 Credits:4 Instructor:Mr Whiskers Room:SC450");
		assertEquals(list.get(1),"\nCourse:CMSC207 CRN:30504 Credits:4 Instructor:Momo Cashew Room:SC450");
		assertEquals(list.get(2),"\nCourse:CMSC201 CRN:30559 Credits:4 Instructor:Chris Evans Room:SC450");
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC207 30504 4 SC550 Aaron The Bio Major");
			inFile.print("CMSC184 30503 4 SC350 Mr Whiskers");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			//System.out.println(dataMgr.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
