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
public final class Hailstone4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone4() {
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
         * Change it so that it repeatedly asks the user whether they wish to
         * calculate another series. If the response is "y", then the program
         * should proceed; if it is anything else, then the program should quit.
         */
        out.print("Do you want to calculate another series?");
        String userChoice = in.nextLine();
        while (userChoice.charAt(0) == 'y') {
            /*
             * ask the user for a positive integer
             */
            out.print("Please input a positive integer number:");
            int input = in.nextInteger();
            generateSeries(input, out);
            out.print("Do you want to calculate another series?");
            userChoice = in.nextLine();
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
