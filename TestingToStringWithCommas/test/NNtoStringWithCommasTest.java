import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

public class NNtoStringWithCommasTest {

    /*
     * boundary case for the test,0 is the smallest NaturalNumber
     */
    @Test
    public void test1() {
        NaturalNumber n1 = new NaturalNumber2(0);
        NaturalNumber temp = new NaturalNumber2(n1);

        String s = redirectToMethodUnderTest(new NaturalNumber2(n1));
        /*
         * Assert that values of variables match expectations
         */
        assertEquals("0", s);
        assertEquals(temp, n1);

    }

    /*
     * routine case for the test,0 is the smallest NaturalNumber
     */
    @Test
    public void test2() {
        NaturalNumber n1 = new NaturalNumber2(12345678);
        NaturalNumber temp = new NaturalNumber2(n1);
        String s = redirectToMethodUnderTest(n1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals("12,345,678", s);
        assertEquals(temp, n1);
    }

    /*
     * challenging case for the test,0 is the smallest NaturalNumber
     */
    @Test
    public void test3() {
        NaturalNumber n1 = new NaturalNumber2(10004);
        NaturalNumber temp = new NaturalNumber2(n1);

        String s = redirectToMethodUnderTest(n1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals("10,004", s);
        assertEquals(temp, n1);
    }

    /*
     * another routine case for the test,0 is the smallest NaturalNumber
     */
    @Test
    public void test4() {
        NaturalNumber n1 = new NaturalNumber2(Integer.MAX_VALUE);
        n1.increment();
        NaturalNumber temp = new NaturalNumber2(n1);
        String s = redirectToMethodUnderTest(new NaturalNumber2(n1));
        /*
         * Assert that values of variables match expectations
         */
        assertEquals("2,147,483,648", s);
        assertEquals(temp, n1);

    }

    /*
     * another routine case for the test,0 is the smallest NaturalNumber
     */
    @Test
    public void test5() {
        NaturalNumber n1 = new NaturalNumber2(4);
        NaturalNumber temp = new NaturalNumber2(n1);
        String s = redirectToMethodUnderTest(n1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals("4", s);
    }

    /*
     * another challenging case for the test,0 is the smallest NaturalNumber
     */
    @Test
    public void test6() {
        NaturalNumber n1 = new NaturalNumber2(1000);
        NaturalNumber temp = new NaturalNumber2(n1);

        String s = redirectToMethodUnderTest(n1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals("1,000", s);
    }

    /*
     * In the contract,it doesn't have a parameter mode,and the default
     * parameter mode is restores mode so this n should be restored here routine
     * case for the test,0 is the smallest NaturalNumber
     */
    @Test
    public void test7() {
        NaturalNumber n1 = new NaturalNumber2(10000);
        NaturalNumber temp = new NaturalNumber2(n1);

        String s = redirectToMethodUnderTest(n1);
        /*
         * Assert that values of variables match expectations
         */

        assertEquals("10,000", s);
        assertEquals(temp, n1);
    }

    /**
     * Calls the method under test.
     *
     * @param n
     *            the number to pass to the method under test
     * @return the {@code String} returned by the method under test
     * @ensures <pre>
     * redirectToMethodUnderTest = [String returned by the method under test]
     * </pre>
     */
    private static String redirectToMethodUnderTest(NaturalNumber n) {
        return NNtoStringWithCommas5.toStringWithCommas(n);
    }

}
