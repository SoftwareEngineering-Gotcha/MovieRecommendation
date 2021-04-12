package edu.knu.se;

import static org.junit.Assert.*;
import org.junit.*;


public class UITest{
	public static UI testUI = null;

	@Before
	public void createTestClass() {
		testUI = new UI();
	}

	@Test
	public void TestprovideMovieInfo(){
		assertTrue("result is not successful", testUI.provideMovieInfo());
	}
	
	@Test
	public void TestaskPreferenceWindow(){
		assertTrue("result is not successful", testUI.askPreferenceWindow());
	}
}
