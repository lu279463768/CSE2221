import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * ask the user for a positive integer and then compute and output the
 * corresponding Hailstone series.
 *
 * @author Vivian Lu
 *
 */
public final class Hailstone5 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone5() {
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
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static int getPositiveInteger(SimpleReader in, SimpleWriter out) {
        boolean flag = false;
        while (flag != true) {//if it is not a positive number,do the loop
            out.print("Please input a positive integer number:");
            String input = in.nextLine();

            if (FormatChecker.canParseInt(input)
                    && Integer.parseInt(input) > 0) {
                flag = true;//then it is a positive number
                return Integer.parseInt(input);
            }
        }
        return -1;

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

            int input = getPositiveInteger(in, out);
            if (input > 0) {
                generateSeries(input, out);
                out.print("Do you want to calculate another series?");
                userChoice = in.nextLine();
            } else {
                out.print("wrong input,end program");
                return;
            }

        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
