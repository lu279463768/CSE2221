import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Debugging program
 *
 * @author Vivian Lu
 */
public final class Oddity {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private Oddity() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        final int[] values = { 8, -4, 3, 0, -5 };
        int i = 0;
        while (i < values.length) {
            int remainder = values[i] % 2;
            if (remainder < 0) {
                remainder += 2;
            }
            if (remainder == 1) {
                out.println("odd");
            } else {
                out.println("even");
            }
            i = i + 1;
        }
        out.close();
    }

}
