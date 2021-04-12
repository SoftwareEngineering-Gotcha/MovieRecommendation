package edu.knu.se;

import static org.junit.Assert.*;
import org.junit.*;



public class MovieTest{
	public static Movie mv = null;
	
	@Before
	public void setUp(){ // int movieId, String title, int genre, String director
		mv = new Movie(11, "testMovieTitle", 5, "TestDirector");
	}
	@Test
	public void TestgetMovieId(){
		assertEquals("getMovieId is not successful", 11, mv.getMovieId());
	}
	
	@Test
	public void TestgetTitle(){
		assertEquals("getTitle is not successful", "testMovieTitle", mv.getTitle());
	}
	
	@Test
	public void TestgetGenreId(){
		assertEquals("getGenreId is not successful", 5, mv.getGenre());
	}
	
	@Test
	public void TestgetDirector(){
		assertEquals("getDirector is not successful", "TestDirector", mv.getDirector());
	}
}
