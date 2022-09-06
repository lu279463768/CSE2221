import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program with implementation of {@code NaturalNumber} secondary operation
 * {@code root} implemented as static method.
 *
 * @author Vivian Lu
 *
 */
public final class NaturalNumberRoot {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private NaturalNumberRoot() {
    }

    /**
     * Updates {@code n} to the {@code r}-th root of its incoming value.
     *
     * @param n
     *            the number whose root to compute
     * @param r
     *            root
     * @updates n
     * @requires r >= 2
     * @ensures n ^ (r) <= #n < (n + 1) ^ (r)
     */
    public static void root(NaturalNumber n, int r) {
        assert n != null : "Violation of: n is  not null";
        assert r >= 2 : "Violation of: r >= 2";

        /**
         * the root area is [0,n+1) :the IntegerRoot code is:
         *
         * int low = 0; int high = n + 1;
         *
         * while (low + 1 < high) { int g = (low + high) / 2; if (power(g, r) >
         * n) { high = g; } else { low = g; } } return low;
         */
        /**
         * copy n's value here so that can compare
         */
        NaturalNumber copyN = new NaturalNumber2(n);
        /**
         * set root area: high = n+1, low = 0
         */
        n.increment();
        NaturalNumber low = new NaturalNumber2(0);

        /**
         * copy low's value so that it can be used as the condition in while
         */
        NaturalNumber tempLow = new NaturalNumber2(low);
        NaturalNumber two = new NaturalNumber2(2);

        while (tempLow.compareTo(n) < 0) {
            NaturalNumber sum = new NaturalNumber2(n);
            sum.add(low);
            sum.divide(two);

            NaturalNumber tempPow = new NaturalNumber2(sum);
            tempPow.power(r);
            if (tempPow.compareTo(copyN) > 0) {
                /**
                 * update n directly as the next high boundary
                 */
                n.add(low);
                n.divide(two);
            } else {
                /**
                 * update low directly as the next low boundary
                 */
                low.add(n);
                low.divide(two);
            }
            tempLow = new NaturalNumber2(low);
            tempLow.increment();
            /**
             * so that it can be used in testing if low+1<n
             */
        }
        /**
         * the value of low should be the root,but when while loop stops,low + 1
         * =n therefore the n-1 is the correct root;
         */
        n.decrement();
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        final String[] numbers = { "0", "1", "13", "1024", "189943527", "0",
                "1", "13", "4096", "189943527", "0", "1", "13", "1024",
                "189943527", "82", "82", "82", "82", "82", "9", "27", "81",
                "243", "143489073", "2147483647", "2147483648",
                "9223372036854775807", "9223372036854775808",
                "618970019642690137449562111",
                "162259276829213363391578010288127",
                "170141183460469231731687303715884105727" };
        final int[] roots = { 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 15, 15, 15, 15, 15,
                2, 3, 4, 5, 15, 2, 3, 4, 5, 15, 2, 2, 3, 3, 4, 5, 6 };
        final String[] results = { "0", "1", "3", "32", "13782", "0", "1", "2",
                "16", "574", "0", "1", "1", "1", "3", "9", "4", "3", "2", "1",
                "3", "3", "3", "3", "3", "46340", "46340", "2097151", "2097152",
                "4987896", "2767208", "2353973" };

        for (int i = 0; i < numbers.length; i++) {
            NaturalNumber n = new NaturalNumber2(numbers[i]);
            NaturalNumber r = new NaturalNumber2(results[i]);
            root(n, roots[i]);
            if (n.equals(r)) {
                out.println("Test " + (i + 1) + " passed: root(" + numbers[i]
                        + ", " + roots[i] + ") = " + results[i]);
            } else {
                out.println("*** Test " + (i + 1) + " failed: root("
                        + numbers[i] + ", " + roots[i] + ") expected <"
                        + results[i] + "> but was <" + n + ">");
            }
        }

        out.close();
    }

}