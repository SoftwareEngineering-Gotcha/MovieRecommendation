package edu.knu.se;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;

public class UserTest {
    private static ArrayList initMovieScore = null; // Declare initialized Score List
    private static ArrayList initMovieList = null; // Declare initialized Movie List
    private static Movie[] movieArray = new Movie[5]; // Movie class array to put Movie class object to initMovieList
    private static User testUser = null; // User class for test

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
            movieArray[i - 1] = new Movie(i, "testTitle" + i, "testGenreName" + i, "testDirectorName" + i);
            // System.out.println(movieArray[i - 1].toString());
            initMovieList.add(movieArray[i - 1]);
        }

        testUser = new User("admin", "TestName", initMovieScore, initMovieList); // dummy class identification
    }

    @Test
    public void testAskPreference() {
        boolean result;
        result = testUser.askPreference(); // if askPreference is success, return true.
        assertTrue( "Successfully asked preference of movie.", result); // ask success
    }
    /*
    @Test
    public void testRecommendationInfo() {
        int[][] initScore = null;
        String[] initList = {"abc", "def", "ghi"};
        User testUser = new User(1, "knucse", initScore, initList); // dummy class identification
        String[] dummyList = null;
        dummyList = testUser.recommendationInfo(); // if recommendationInfo is ended, return dummyList.
        assertNotNull("Successfully loaded list.",dummyList); // successfully load data
    }
    */
    /*
    @Test
    public void testProvideMovieInfo() {
        int[][] initScore = {{5, 4}, {4, 3}};
        String[] initList = {"abc", "def", "ghi"};
        User testUser = new User(1, "knucse", initScore, initList); // dummy class identification
        boolean result = testUser.provideMovieInfo(); // if provideMovieInfo is success, return true.
        assertTrue( "Successfully asked perference of movie.", result); // ask success
    }
    */
}
