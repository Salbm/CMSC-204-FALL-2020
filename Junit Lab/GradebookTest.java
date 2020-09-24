package lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradebookTest {

	GradeBook goo, boo;
	
	@Before
	public void setUp() throws Exception {
		
			goo = new GradeBook(5);
			goo.addScore(75);
			goo.addScore(89);
			goo.addScore(64);
			
			boo = new GradeBook(5);
			boo.addScore(56);
			boo.addScore(82);
	}
	


	@After
	public void tearDown() throws Exception{
	goo = null;
	boo = null;
	}

	@Test 
	public void testAddScoreMethod() {
	assertTrue(boo.toString().equals("56 82 "));
	assertTrue(goo.toString().equals("75 89 64 "));
	}
	
	@Test
	public void testSumMethod() {
		assertEquals(228,goo.sum(),.0001);
		assertEquals(138,boo.sum(),.0001);
		
	}
	
	@Test
	public void testMinimumMethod() {
		assertEquals(64,goo.minimum(),.0001);
		assertEquals(56,boo.minimum(),.0001);
	}
 
	@Test
	public void testFinalScoreMethod() {
		assertEquals(164,goo.finalScore(),.0001);
		assertEquals(82,boo.finalScore(),.0001);
	}

}