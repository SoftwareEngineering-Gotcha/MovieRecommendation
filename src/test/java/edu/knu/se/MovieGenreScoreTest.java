package edu.knu.se;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;


public class MovieGenreScoreTest {
	public static MovieGenreScore mgs = null;

	@Before
	public void Setup(){
		ArrayList<Integer> genreScore = new ArrayList();
		mgs = new MovieGenreScore(genreScore);
	}
	
	@Test
	public void TestgetGenreScore(){
		assertNotNull("Result is not successful", mgs.getGenreScore());
	}
		
}
