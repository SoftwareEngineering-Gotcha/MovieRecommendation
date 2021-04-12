package edu.knu.se;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;


public class MovieGenreScoreTest {
	public static MovieGenreScore mgs = null;

	@Before
	public void Setup(){
		ArrayList<Integer> genreScore = new ArrayList<Integer>();
		mgs = new MovieGenreScore(genreScore);
	}
	
	@Test
	public void TestgetGenreScore(){
		assertTrue("Result is not successful", mgs.getGenreScore());
	}
		
}
