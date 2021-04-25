package edu.knu.se;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;


public class MovieTest{
	public static ArrayList initGenreId = null; // Declare initialized Score List
	public static Movie testMovie = null; // Movie class for test
	@Before
	public void makeTestMovieClass() { // make initialized movie Class
		initGenreId= new ArrayList(); // make MovieScore object in form of ArrayList
		initGenreId.add(1); // add genre score that user added
		initGenreId.add(2);
		initGenreId.add(3);
		initGenreId.add(4);
		initGenreId.add(5);

		testMovie = new Movie(10, "TestMovieName", initGenreId); // dummy class identification
	}

	@Test
	public void testGetMovieId(){
		assertEquals("getMovieId is not successful", 10, testMovie.getMovieId());
	}
	
	@Test
	public void testGetTitle(){
		assertEquals("getTitle is not successful", "TestMovieName", testMovie.getTitle());
	}
	
	@Test
	public void testGetGenreId(){
		ArrayList getResult = null;
		getResult = testMovie.getGenreId();
		for(int i = 0; i < 5; i++) {
			assertEquals("getGenreId is not successful", i + 1, getResult.get(i));
		}

	}

}
