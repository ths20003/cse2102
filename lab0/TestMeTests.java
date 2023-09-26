package u;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import c.TestMe;

public class TestMeTests {

    TestMe testMe;

    @Before
    public void setUp() throws Exception {
        testMe = new TestMe();
    }

    @Test
    public void squareTest() {
        double baseValue = 3.0;
        double expected = baseValue * baseValue;
        testMe.setValue(3.0);
        double actual = testMe.square();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void addTest() {
        double baseValue = 3.0;
        double x = 2.0;
        double expected = baseValue + x;
        testMe.setValue(baseValue);
        double actual = testMe.add(x);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void maximumTest() {
        double baseValue = 3.0;
        double x = 5.0;
        double expected = Math.max(baseValue, x);
        testMe.setValue(baseValue);
        double actual = testMe.maximum(x);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void subtractTest() {
        double baseValue = 3.0;
        double x = 2.0;
        double expected = baseValue - x;
        testMe.setValue(baseValue);
        double actual = testMe.subtract(x);
        assertEquals(expected, actual, 0.001);
    }
}
