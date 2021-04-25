package edu.knu.se;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;


public class UITest{
	public static UI testUI = null;
	public static ArrayList<Integer> initUserGenreScore = null;

	@Before
	public void makeUITestClass() { // make initialized UI Class
		initUserGenreScore = new ArrayList(); // make UserGenreScore object in form of ArrayList
		initUserGenreScore.add(5);
		initUserGenreScore.add(4);
		initUserGenreScore.add(3);
		initUserGenreScore.add(2);
		initUserGenreScore.add(1);

		testUI = new UI();
	}

	@Test
	public void TestProvideMovieInfo(){
		assertTrue("result is not successful", testUI.provideMovieInfo(initUserGenreScore));
	}
	
	@Test
	public void TestAskPreferenceWindow(){
		assertNotNull("result is not successful", testUI.askPreferenceWindow());
	}
}
