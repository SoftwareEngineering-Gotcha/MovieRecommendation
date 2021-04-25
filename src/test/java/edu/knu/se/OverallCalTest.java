package edu.knu.se;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;

public class OverallCalTest {
    public static OverallCal testCal = null; // OverallCal class for test
    public static ArrayList<Integer> testGenreScore = null;

    @Before
    public void makeTestClass() {
        testCal = new OverallCal();
        testGenreScore = new ArrayList();
    }

    @Test
    public void testCalculate() {
        assertNotNull("result is not successful", testCal.calculate(testGenreScore));
    }
}
