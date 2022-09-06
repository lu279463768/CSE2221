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
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            a non-negative number to compute square root of
     * @param epsilon
     *            ask the user to give a epsilon
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilon) {
        double r = x;
        if (x == 0.0) {
            return 0.0;
        }
        while (Math.abs((r * r - x) / x) >= Math.pow(epsilon, 2)) {
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

        out.print("Please input a value of x: ");
        double number = in.nextDouble();

        out.print("Please input the value of ε: ");
        double epsilon = in.nextDouble();

        while (number >= 0.0) {

            double square_root = sqrt(number, epsilon);
            out.println("The square root of this number is " + square_root);

            out.print("Please input a new value of x: ");
            number = in.nextDouble();
        }
        out.println("Program ended.");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
