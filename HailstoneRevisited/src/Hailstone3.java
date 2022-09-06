import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * ask the user for a positive integer and then compute and output the
 * corresponding Hailstone series.
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
     * integer and record the length of this series and output the maxium value
     * of the series
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int len = 1;
        int max = n;
        while (n != 1) {
            out.print(n + " ");
            len++;
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 2 == 1) {
                n = 3 * n + 1;
            }
            if (n > max) {
                max = n;
            }
        }
        out.print(n + " ");
        out.println();
        out.println("The length of series is " + len);
        out.println("The max value is " + max);

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here, ask the user for a positive integer
         */
        out.print("Please input a positive integer number:");
        int input = in.nextInteger();
        generateSeries(input, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
