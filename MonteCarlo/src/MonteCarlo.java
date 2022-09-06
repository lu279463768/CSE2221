import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: compute percentage of pseudo-random points in [0.0,1.0)
 * interval that fall in the left half subinterval [0.0,0.5).
 */
public final class MonteCarlo {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private MonteCarlo() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        /*
         * Open input and output streams
         */
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        /*
         * Ask user for number of points to generate
         */
        output.print("Number of points: ");
        int n = input.nextInteger();
        /*
         * Declare counters and initialize them
         */
        int ptsInInterval = 0, ptsInSubinterval = 0;
        /*
         * Create pseudo-random number generator
         */
        Random rnd = new Random1L();
        /*
         * Generate points and count how many fall in [0.0,2.0) x [0.0,2.0)
         * square
         */
        while (ptsInInterval < n) {
            /*
             * Generate a pair of position pseudo-random number in [0.0,2.0)
             * interval
             */
            double x = 2.0 * rnd.nextDouble();
            double y = 2.0 * rnd.nextDouble();
            /*
             * Increment total number of generated points
             */
            ptsInInterval++;
            /*
             * Check if point is in the unit circle and increment counter if it
             * is
             */
            if ((x - 1) * (x - 1) + (y - 1) * (y - 1) <= 1) {
                ptsInSubinterval++;
            }
        }
        /*
         * Estimate percentage of points generated in [0.0,1.0) interval that
         * fall in the [0.0,0.5) subinterval
         */
        double estimate = (4.0 * ptsInSubinterval) / ptsInInterval;
        output.println("Estimate of π : " + estimate + "%");
        /*
         * Close input and output streams
         */
        input.close();
        output.close();
    }

}