package edu.knu.se;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;

public class UserTest {
    public static ArrayList initMovieScore = null; // Declare initialized Score List
    public static ArrayList initMovieList = null; // Declare initialized MovieID List
    public static User testUser = null; // User class for test

    @Before
    public void makeTestUserClass() { // make initialized User Class
        initMovieScore = new ArrayList(); // make MovieScore object in form of ArrayList
        initMovieScore.add(5); // add genre score that user added
        initMovieScore.add(4);
        initMovieScore.add(3);
        initMovieScore.add(2);
        initMovieScore.add(1);

        initMovieList = new ArrayList(); // make MovieList object in form of ArrayList
        for(int i = 1; i <= 5; i++){
            initMovieList.add(10 + i);
        }
        testUser = new User("admin", "qwer1234", initMovieScore, initMovieList); // dummy class identification
    }

    @Test
    public void testAskPreference() {
        boolean result;
        result = testUser.askPreference(); // if askPreference is success, return true.
        assertTrue( "Successfully asked preference of movie.", result); // ask success
    }

    @Test
    public void testGetID() {
        assertEquals("Id is not equal", "admin", testUser.getUid());
    }

    @Test
    public void testGetPasswd() {
        assertEquals("Name is not equal", "qwer1234", testUser.getPasswd());
    }

    @Test
    public void testSetMovieList() {
        boolean result;
        ArrayList<Integer> testMovieList = new ArrayList<Integer>();
        testMovieList.add(1);
        testMovieList.add(2);
        testMovieList.add(3);
        testMovieList.add(4);
        testMovieList.add(5);
        result = testUser.setMovieList(testMovieList);
        assertTrue("Set MovleList is not successful", result);
    }
}