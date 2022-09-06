import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * this program prompts the user for his/her name, inputs the name, and outputs
 * the message
 *
 * @author Vivian Lu
 *
 */
public final class HelloJack {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HelloJack() {
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
         * Put your main program code here
         */
        System.out.print("Please enter your name:");
        String input = in.nextLine();
        out.println("Hello, " + input);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
