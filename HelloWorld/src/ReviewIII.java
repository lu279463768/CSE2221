import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree2;

public class ReviewIII {
    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @clears n
     * @ensures productOfDigits1 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits1(NaturalNumber n) {
        int lastDigit = n.divideBy10();
        NaturalNumber lDigit = new NaturalNumber2(lastDigit);

        if (!n.isZero()) {
            lDigit.multiply(productOfDigits1(n));
        }
        return lDigit;

    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @ensures productOfDigits2 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits2(NaturalNumber n) {
        NaturalNumber temp = new NaturalNumber2(n);
        int lastDigit = temp.divideBy10();
        NaturalNumber lDigit = new NaturalNumber2(lastDigit);

        if (!temp.isZero()) {
            lDigit.multiply(productOfDigits2(temp));
        }
        return lDigit;
    }

    /**
     * Reports the value of {@code n} as an {@code int}, when {@code n} is small
     * enough.
     *
     * @param n
     *            the given {@code NaturalNumber}
     * @return the value
     * @requires n <= Integer.MAX_VALUE
     * @ensures toInt = n
     */
    private static int toInt(NaturalNumber n) {
        int value = -1;
        if (n.isZero()) {
            //the smallest value of NaturalNumber n is zero
            //I am not sure what's this question trying to do...only return 0?
            value = 0;
        }
        return value;
    }

    /**
     * Reports whether the given tag appears in the given {@code XMLTree}.
     *
     * @param xml
     *            the {@code XMLTree}
     * @param tag
     *            the tag name
     * @return true if the given tag appears in the given {@code XMLTree}, false
     *         otherwise
     * @ensures <pre>
     * findTag =
     *    [true if the given tag appears in the given {@code XMLTree}, false otherwise]
     * </pre>
     */
    private static boolean findTag(XMLTree xml, String tag) {
        boolean flag = true;
        if (!xml.label().equals(tag)) {
            flag = false;
        }
        if (xml.isTag()) {
            //also need to determine if its any subtree has this tag
            for (int i = 0; !flag && i < xml.numberOfChildren(); i++) {
                flag = findTag(xml.child(i), tag);
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();
//        out.print("Please input a NaturalNumber n1: ");
//        NaturalNumber n1 = new NaturalNumber1L(in.nextLine());
//        NaturalNumber p1 = productOfDigits1(n1);
//        out.println("The product of digits in this NaturalNumber is: " + p1);
//        out.println("The current value of n1 is: " + n1);
//
//        out.print("Please input a NaturalNumber n2: ");
//        NaturalNumber n2 = new NaturalNumber1L(in.nextLine());
//        NaturalNumber p2 = productOfDigits2(n2);
//        out.println("The product of digits in this NaturalNumber is: " + p2);
//        out.print("The current value of n1 is: " + n2);

        out.print("Enter a URL or file name for an XML source: ");
        String url = in.nextLine();
        XMLTree xml = new XMLTree2(url);

        out.print("Enter the name of a tag: ");
        String tag = in.nextLine();
        boolean flag = findTag(xml, tag);

        out.println("This XMLTree has this tag: " + flag);

    }
}
