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
public final class Hailstone1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone1() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        while (n != 1) {
            out.print(n + " ");
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 2 == 1) {
                n = 3 * n + 1;
            }
        }
        out.print(n + " ");

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
