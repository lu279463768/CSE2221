import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Compute integer power with interval halving and test it.
 *
 * @author Put your name here
 *
 */
public final class IntegerRoot {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private IntegerRoot() {
    }

    /**
     * Returns {@code n} to the power {@code p}.
     *
     * @param n
     *            the number to which we want to apply the power
     * @param p
     *            the power
     * @return the number to the power
     * @requires Integer.MIN_VALUE <= n ^ (p) <= Integer.MAX_VALUE and p >= 0
     * @ensures power = n ^ (p)
     */
    private static int power(int n, int p) {
        int result = 1, count = 0;
        while (count < p) {
            result *= n;
            count++;
        }
        return result;
    }

    /**
     * Returns the {@code r}-th root of {@code n}.
     *
     * @param n
     *            the number to which we want to apply the root
     * @param r
     *            the root
     * @return the root of the number
     * @requires n >= 0 and r > 0
     * @ensures root ^ (r) <= n < (root + 1) ^ (r)
     */
    private static int root(int n, int r) {
        int low = 0;
        int high = n + 1;

        while (low + 1 < high) {
            int g = (low + high) / 2;
            if (power(g, r) > n) {
                high = g;
            } else {
                low = g;
            }

        }
        return low;
    }

    /**
     * because we want to round it down,floor to 4 so we should always return to
     * the left side there is no such case as"power(g,r) == n" 除了比其大的情况，其他都改low
     * 并且termination condition is low+1 = high
     * -----因为此时的情况是左闭右开！------多试几个二分查找今天！
     */

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        final int[] numbers = { 0, 0, 0, 1, 1, 1, 82, 82, 82, 82, 82, 3, 9, 27,
                81, 243 };
        final int[] roots = { 1, 2, 5, 1, 2, 17, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
        final int[] results = { 0, 0, 0, 1, 1, 1, 82, 9, 4, 3, 2, 3, 3, 3, 3,
                3 };

        for (int i = 0; i < numbers.length; i++) {
            int x = root(numbers[i], roots[i]);
            if (x == results[i]) {
                out.println("Test passed: root(" + numbers[i] + ", " + roots[i]
                        + ") = " + results[i]);
            } else {
                out.println("*** Test failed: root(" + numbers[i] + ", "
                        + roots[i] + ") expected <" + results[i] + "> but was <"
                        + x + ">");
            }
        }

        out.close();
    }

    /**
     *
     * NaturalNumber tempN = new NaturalNumber2(n); tempN.increment();
     *
     * NaturalNumber low = new NaturalNumber2(0); NaturalNumber high = new
     * NaturalNumber2(tempN);
     *
     * NaturalNumber two = new NaturalNumber2(2); NaturalNumber tempLow = new
     * NaturalNumber2(0); tempLow.increment();
     * 
     *
     *
     * while (tempLow.compareTo(high) < 0) {
     *
     * NaturalNumber sum = new NaturalNumber2(high); sum.add(low);
     * sum.divide(two); NaturalNumber mid = new NaturalNumber2(sum);
     * NaturalNumber tempMid = new NaturalNumber2(sum); tempMid.power(r); if
     * (tempMid.compareTo(n) > 0) { high = new NaturalNumber2(mid); } else { low
     * = new NaturalNumber2(mid); tempLow = new NaturalNumber2(low);
     * tempLow.increment(); }
     *
     * }
     *
     * n = low;
     **/

}