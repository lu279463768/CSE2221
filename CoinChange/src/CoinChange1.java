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
public final class CoinChange1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange1() {
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

        int dollar = input / 100;
        input = input % 100;

        int half_dollar = input / 50;
        input = input % 50;

        int quarter = input / 25;
        input = input % 25;

        int dime = input / 10;
        input = input % 10;

        int nickel = input / 5;
        input = input % 5;

        int penny = input / 1;
        input = input % 1;

        out.println("Using greedy solution to make change,it is required: ");
        out.println("number of dollar: " + dollar + ",number of half_dollar: "
                + half_dollar + ",number of quarter: " + quarter
                + ",number of dime: " + dime + ",number of nickel: " + nickel
                + ",number of penny: " + penny);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
