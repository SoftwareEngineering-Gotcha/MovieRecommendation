package edu.knu.se;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class MovieTest {
		@Test
		public void test_loadMovieInfo() {
			Movie m1 = new Movie(1,"movie1","Romance" ,"Director");
			ArrayList<Integer> genreTest = new ArrayList<>();
			genreTest.add(1);
			genreTest.add(4);
			MovieGenreScore ms1 = new MovieGenreScore(genreTest);
//			assertEquals("movie1RomanceDirector",m1.loadMovieInfo());
		}
//		@Test
//		public void test_matching() {
//			Movie m1 = new Movie("movie1","Romance" ,"Director");
//			MovieGenreScore ms1 = new MovieGenreScore(1, 4);
//			assertEquals(ms1.matching(1,4), false);
//		}
}
