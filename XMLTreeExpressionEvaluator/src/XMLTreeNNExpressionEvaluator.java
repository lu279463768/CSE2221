import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Vivian Lu 2022/07
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"] and
     *  [the value is each node is non-negative]
     *  and [cannot be divided by 0]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        XMLTree root = exp;
        NaturalNumber res = new NaturalNumber2(0);
        if (!root.label().equals("number")) {
            NaturalNumber left = evaluate(root.child(0));
            NaturalNumber right = evaluate(root.child(1));
            if (root.label().equals("plus")) {
                left.add(right);
                res = new NaturalNumber2(left);
            } else if (root.label().equals("minus")) {
                if (right.compareTo(left) > 0) {
                    Reporter.fatalErrorToConsole(
                            "Cannot get a negative natural number!");
                }
                left.subtract(right);
                res = new NaturalNumber2(left);
            } else if (root.label().equals("times")) {
                left.multiply(right);
                res = new NaturalNumber2(left);
            } else if (root.label().equals("divide")) {
                if (right.isZero()) {
                    Reporter.fatalErrorToConsole(
                            "The number in the expression cannot divided by 0!");
                }
                left.divide(right);
                res = new NaturalNumber2(left);
            }
        } else {
            res = new NaturalNumber2(
                    Integer.parseInt(root.attributeValue("value")));
        }

        return res;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
