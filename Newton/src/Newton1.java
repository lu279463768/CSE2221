import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * repeatedly asks the user whether they wish to calculate another square root.
 *
 * @author Vivian Lu
 *
 */
public final class Newton1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double r = x;
        while (Math.abs((r * r - x) / x) >= Math.pow(1E-4, 2)) {
            r = (r + x / r) / 2;
        }
        return r;
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

        out.print("Do you want to calculate a square root?");
        String input = in.nextLine();
        while (input.equals("y")) {
            out.print("Please input  a number: ");
            double number = in.nextDouble();
            double square_root = sqrt(number);
            out.println("The square root of this number is " + square_root);

            out.print("Do you want to calculate another square root?");
            input = in.nextLine();
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
