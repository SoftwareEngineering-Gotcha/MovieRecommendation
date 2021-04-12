package edu.knu.se;

import static org.junit.Assert.*;

import org.junit.*;

public class OverallCalTest {
    public static OverallCal testCal = null; // User class for test

    @Before
    public void makeTestUserClass() { // make initialized User Class
        testCal = new OverallCal(); // make MovieScore object in form of ArrayList
    }

    @Test
    public void calculate() {
        boolean result;
        result = testCal.calculate(); // if askPreference is success, return true.
        assertTrue( "Successfully calculated.", result); // ask success
    }
}
