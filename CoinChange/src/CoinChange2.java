import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * ask the user for an amount (number of cents) to make change for and then use
 * the greedy solution to compute and output the numbers of coins of each kind
 * required to make that amount of change. (use coins of the following
 * denominations: dollar, half-dollar, quarter, dime, nickel, and penny)
 *
 * @author Vivian Lu
 *
 */
public final class CoinChange2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange2() {
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
         * my main program code:
         */
        out.print(
                "Please input an amount (number of cents) to make change for:");
        int input = in.nextInteger();

        int[] denominations = new int[] { 100, 50, 25, 10, 5, 1 };

        int[] count = new int[denominations.length];
        int i = 0;
        for (; i < 6; i++) {
            count[i] = input / denominations[i];
            input %= denominations[i];
        }

        out.println("Using greedy solution to make change,it is required: ");
        out.println("number of dollar: " + count[0] + ",number of half_dollar: "
                + count[1] + ",number of quarter: " + count[2]
                + ",number of dime: " + count[3] + ",number of nickel: "
                + count[4] + ",number of penny: " + count[5]);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
