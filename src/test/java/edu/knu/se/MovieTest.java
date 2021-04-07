package edu.knu.se;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class MovieTest {
	MovieScoreMatrix ms1;
	Movie m1;
		@Test
		public void test_loadMovieInfo() {
			Movie m1 = new Movie("movie1","Romance" ,"Director");
			MovieScoreMatrix ms1 = new MovieScoreMatrix(1, 4);
			assertEquals("movie1RomanceDirector",m1.loadMovieInfo());
		}
		@Test
		public void test_matching() {
			Movie m1 = new Movie("movie1","Romance" ,"Director");
			MovieScoreMatrix ms1 = new MovieScoreMatrix(1, 4);
			assertEquals(ms1.matching(1,4), false);
		}
}
