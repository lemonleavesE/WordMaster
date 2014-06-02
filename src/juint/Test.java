package juint;

import static org.junit.Assert.*;

import java.io.IOException;

import controller.Action;

public class Test {

	@org.junit.Test
	public void testConfig() throws IOException 
	{
		Action.getInstance().chooseLexicon("a");
		assertEquals("abandon", Action.getInstance().getLastWord());
	}

}
