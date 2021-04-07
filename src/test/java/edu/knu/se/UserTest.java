package org.example;

import static org.junit.Assert.*;

import org.junit.*;

public class UserTest {
    @Test
    public void testAskPreference() {
        int[][] initScore = {{5, 4}, {4, 3}};
        String[] initList = {"abc", "def", "ghi"};
        User testUser = new User(1, "knucse", initScore, initList); // dummy class identification
        boolean result;
        result = testUser.askPreference(); // if askPreference is success, return true.
        assertTrue( "Successfully asked perference of movie.", result); // ask success
    }
    @Test
    public void testRecommendationInfo() {
        int[][] initScore = null;
        String[] initList = {"abc", "def", "ghi"};
        User testUser = new User(1, "knucse", initScore, initList); // dummy class identification
        String[] dummyList = null;
        dummyList = testUser.recommendationInfo(); // if recommendationInfo is ended, return dummyList.
        assertNotNull("Successfully loaded list.",dummyList); // successfully load data
    }
    @Test
    public void testProvideMovieInfo() {
        int[][] initScore = {{5, 4}, {4, 3}};
        String[] initList = {"abc", "def", "ghi"};
        User testUser = new User(1, "knucse", initScore, initList); // dummy class identification
        boolean result = testUser.provideMovieInfo(); // if provideMovieInfo is success, return true.
        assertTrue( "Successfully asked perference of movie.", result); // ask success
    }
}
