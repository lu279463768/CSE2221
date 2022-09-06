import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Homework # 12
 *
 * @author Vivian Lu
 */
public final class RecursionOne {

    private static final int NaturalNumber = 0;

    /**
     * No-argument constructor--private to prevent instantiation.
     */
    private RecursionOne() {
        // no code needed here
    }

    /**
     * Returns the number of digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to count
     * @return the number of digits of {@code n}
     * @ensures numberOfDigits = [number of digits of n]
     */
    private static int numberOfDigits(NaturalNumber n) {
        int count = 1;
        n.divideBy10();
        if (!n.isZero()) {
            count += numberOfDigits(n);
        }
        return count;
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static int sumOfDigits(NaturalNumber n) {
        int sum = n.divideBy10();
        if (!n.isZero()) {
            sum += sumOfDigits(n);
        }
        return sum;
    }

    /**
     * In addition to the kernel methods, for this question (only!) you are
     * allowed to use the NaturalNumber method add. Returns the sum of the
     * digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static NaturalNumber sumOfDigits2(NaturalNumber n) {
        NaturalNumber sum = new NaturalNumber2(n.divideBy10());
        if (!n.isZero()) {
            sum.add(sumOfDigits2(n));
        }
        return sum;
    }

    /**
     * Divides {@code n} by 2.
     *
     * @param n
     *            {@code NaturalNumber} to be divided
     * @updates n
     * @ensures 2 * n <= #n < 2 * (n + 1)
     */
    private static void divideBy2(NaturalNumber n) {
        NaturalNumber two = new NaturalNumber2(2);
        if (!n.isZero()) {
            n.divide(two);
            divideBy2(n);
        }
    }

    /**
     * Checks whether a {@code String} is a palindrome.
     *
     * @param s
     *            {@code String} to be checked
     * @return true if {@code s} is a palindrome, false otherwise
     * @ensures isPalindrome = (s = rev(s))
     */
    private static boolean isPalindrome(String s) {
        boolean isPalindrome;

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            if (s.length() > 2) {
                String sub = s.substring(1, s.length() - 1);
                isPalindrome = isPalindrome(sub);
            } else {
                isPalindrome = true;
            }
        } else {
            isPalindrome = false;
        }

        return isPalindrome;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();
        out.println("Please input a NaturalNumber n1: ");
        NaturalNumber n1 = new NaturalNumber1L(in.nextLine());
        int k = numberOfDigits(n1);
        out.println("The number of digits in this NaturalNumber is: " + k);

        out.println("Please input a NaturalNumber n2: ");
        NaturalNumber n2 = new NaturalNumber1L(in.nextLine());
        int sum = sumOfDigits(n2);
        out.println("The sum of digits in this NaturalNumber is: " + sum);

        out.println("Please input a NaturalNumber n3: ");
        NaturalNumber n3 = new NaturalNumber1L(in.nextLine());
        int sum2 = sumOfDigits(n3);
        out.println("The sum of digits in this NaturalNumber is: " + sum2);

        out.println("Please input a NaturalNumber n4: ");
        NaturalNumber n4 = new NaturalNumber1L(in.nextLine());
        divideBy2(n4);
        out.println(
                "The value of this NaturalNumber continuely divided by 2 is: "
                        + n4);

        out.println("Please input a string n5: ");
        String n5 = in.nextLine();
        boolean isPalindrome = isPalindrome(n5);
        out.println("This string isPalindrome: " + isPalindrome);

        out.close();
    }

}
