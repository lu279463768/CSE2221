import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
 * @author Vivian Lu
 *
 */
public final class Hailstone3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone3() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * {@code NaturalNumber}.
     *
     * @param n
     *            the starting natural number
     * @param out
     *            the output stream
     * @updates out.content
     * @requires n > 0 and out.is_open
     * @ensures out.content = #out.content * [the Hailstone series starting with
     *          n]
     */
    private static void generateSeries(NaturalNumber n, SimpleWriter out) {
        NaturalNumber one = new NaturalNumber2(1);
        NaturalNumber two = new NaturalNumber2(2);
        NaturalNumber three = new NaturalNumber2(3);
        NaturalNumber temp = new NaturalNumber2(n);
        NaturalNumber max = new NaturalNumber2();

        out.println(temp);
        int count = 1;

        while (temp.compareTo(one) != 0) {
            if (temp.compareTo(max) > 0) {
                max.copyFrom(temp);
            }
            NaturalNumber r = temp.divide(two);//可以直接用dividedBy10()直接就可的得到int型的个位数 然后multiplyBy10(remainder)

            if (r.isZero()) {//then it's even
                out.println(temp);
                count++;
            } else if (!r.isZero()) {
                /**
                 * if it's not even we first should set temp back to its
                 * original
                 */
                temp.multiply(two);
                temp.add(r);

                temp.multiply(three);
                temp.add(one);
                out.println(temp);
                count++;

            }

        }
        out.println("The length of the series is " + count);
        out.println("The max value in the series is " + max);
    }

    /**
     * Main method. print the value of the NaturalNumber after the call to
     * generateSeries to confirm that the value was restored.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Please give a positive integer: ");
        int input = in.nextInteger();
        NaturalNumber n = new NaturalNumber2(input);

        generateSeries(n, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}