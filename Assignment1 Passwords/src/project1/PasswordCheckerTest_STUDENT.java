package project1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {

	ArrayList<String> passwords;
	String password1, password2;
	
	@Before
	public void setUp() throws Exception {
		String[] x = {"444495CC", "Im4evertireD", "alexandra4LLL", "4ever", "samantha00", "4everSummer", 
				"august29", "ghijkl", "Samsungsuxx", "bb12n", "astronautProject", "insertPassword", 
				"insertPassword2"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(x)); 
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
	           
			   PasswordCheckerUtility.isValidPassword("puki3");
	          
	            assertTrue("LengthException isn't thrown", false);
	        } catch (LengthException e) {
	            
	        	assertTrue("LengthException successfully thrown", true);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	           
	            assertTrue("Wrong exception thrown", false);
	        }
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
	           
			 
			 PasswordCheckerUtility.isValidPassword("pockjdgcnm8la!");
	            
			 assertTrue("NoUpperAlphaException isn't thrown", false);
	        } catch (NoUpperAlphaException e) {
	            
	        	assertTrue("NoUpperAlphaException successfully thrown", true);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            
	            assertTrue("Wrong exception thrown", false);
	        }
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		 try {
	           
			  PasswordCheckerUtility.isValidPassword("K8MN2KW2NDNEKE!!");
	          
			  assertTrue("NoLowerAlphaException isn't thrown", false);
	        } catch (NoLowerAlphaException e) {
	           
	        	assertTrue("NoLowerAlphaException successfully thrown", true);
	        } catch (Exception e) {
	           
	        	System.out.println(e.getMessage());
	            
	        	assertTrue("Wrong exception thrown", false);
	        }
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		 try {
	            
		    	assertEquals(true, PasswordCheckerUtility.isValidPassword("Ace10!"));
		    	
	            assertTrue(PasswordCheckerUtility.isWeakPassword("Ace10!"));
	        } catch (Exception e) {
	           
	        	assertTrue("Unexpected exception thrown: " + e.getMessage(), false);
	        }
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{

try {
            
			PasswordCheckerUtility.isValidPassword("mLaaa7mNbdWk3lL!");
           
			assertTrue("InvalidSequenceException isn't thrown", false);
        } catch (InvalidSequenceException e) {
           
        	assertTrue("InvalidSequenceException successfully thrown", true);
        } catch (Exception e) {
           
        	System.out.println(e.getMessage());
           
        	assertTrue("Wrong exception is thrown", false);
        }
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
	           
			PasswordCheckerUtility.isValidPassword("dmcKOKlol");
           
			assertTrue("NoDigitException isn't thrown", false);
        } catch (NoDigitException e) {
            
        	assertTrue("NoDigitException successfully thrown", true);
        } catch (Exception e) {
            
        	System.out.println(e.getMessage());
            
        	assertTrue("Wrong exception thrown", false);
        }
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
            PasswordCheckerUtility.isValidPassword("ABCpLN28Sfk!"); 
            
            PasswordCheckerUtility.isValidPassword("9kL8a2N8zE0!"); 
            
            PasswordCheckerUtility.isValidPassword("VA3oOakkdFM!"); 
            
            PasswordCheckerUtility.isValidPassword("nN9KWlO8k8Y!");
            assertTrue("Valid password", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Unexpected exception thrown", false);
        }
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		Scanner scan = new Scanner(results.get(0)); //
		assertEquals(scan.next(), "444495CC");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("Im4evertireD"));
		//assertEquals(scan.nextLine(), " The password must contain at least one lowercase alphabetic character.");
		scan = new Scanner(results.get(1)); //
		assertEquals(scan.next(), "alexandra4LLL");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("4ever"));
		//assertEquals(scan.nextLine(), " The password cannot contain more than two of the same character in sequence.");
		scan = new Scanner(results.get(3)); //
		assertEquals(scan.next(), "samantha00");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("4everSummer"));
		//assertEquals(scan.nextLine(), " The password must contain at least one uppercase alphabetic character.");
		scan = new Scanner(results.get(5)); //
		assertEquals(scan.next(), "august29");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("astronautProject") || nextResults.contains("digit"));
		//assertEquals(scan.nextLine(), " The password must contain at least one digit.");
		scan = new Scanner(results.get(6)); //a
		assertEquals(scan.next(), "Samsungsuxx");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("ghijkl"));
		//assertEquals(scan.nextLine(), " The password must contain at least one digit.");
	}
	
}
