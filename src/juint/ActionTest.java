package juint;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Action;
import controller.Lexicon;
import junit.framework.TestCase;

public class ActionTest extends TestCase{

	public static Action actionTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
        @Override
	public void setUp() throws Exception {
		actionTest = Action.getInstance();
	}

	@After
        @Override
	public void tearDown() throws Exception {
	}

	
	
	/**
	 * Fetch lexicons with head letter of a,b,c and d 
	 * to make up 4 groups of tests to calculate the correct rate. 
	 *
     * @throws java.io.IOException */
	
	@Test
	public void testChooseLexicon() throws IOException {
		
		actionTest.chooseLexicon("a");
		assertEquals("abandon", actionTest.getLastWord());
		actionTest.chooseLexicon("b");
		assertEquals("baby", actionTest.getLastWord());
		actionTest.chooseLexicon("c");
		assertEquals("cab", actionTest.getLastWord());
		actionTest.chooseLexicon("d");
		assertEquals("d/a", actionTest.getLastWord());
	}

	/**
	 * @throws IOException 
	 * */
	@Test
	public void testSetNum() throws IOException{
		actionTest.chooseLexicon("a");
		int setNum = actionTest.setNum(15);
		System.out.println("The set number is " + setNum);
		assertEquals(0,setNum);
	}

	
	/**
	 * Choose a lexicon and pick any word with the head letter as the parameter to cast 
	 * into the chooseWord() function, test whether the returning result match the expected
	 * word given in assertEquals()
	 *
     * @throws java.io.IOException */
	@Test
	public void testChooseWord() throws IOException {
		
		actionTest.chooseLexicon("a");
		actionTest.chooseWord("abbreviation");
		assertEquals("abbreviation",actionTest.getLastWord());
	}

	/**
	 * Choose a lexicon and pick any word with the head letter as the parameter to cast 
	 * into the nextWord() function 
	 * */
	@Test
	public void testNextWord() throws IOException {
		actionTest.chooseLexicon("a");
		int status = actionTest.nextWord("abandon");
		String next = actionTest.getLastWord();
		System.out.println(status);
		assertEquals("abandonment", next);
	}

	@Test
	public void testGetLexiconInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLexiconsInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastWord() {
		fail("Not yet implemented");
	}

}
