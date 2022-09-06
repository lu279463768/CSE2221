import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program to test arrays, references, and arrays of references.
 *
 * @author Put your name here
 *
 */
public final class ArraysAndReferences {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ArraysAndReferences() {
    }

    /**
     * Computes the product of the {@code NaturalNumber}s in the given array.
     *
     * @param nnArray
     *            the array
     * @return the product of the numbers in the given array
     * @requires nnArray.length > 0
     * @ensures <pre>
     * productOfArrayElements =
     *    [nnArray[0] * nnArray[1] * ... * nnArray[nnArray.length-1]]
     * </pre>
     */
    private static NaturalNumber productOfArrayElements(
            NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";

        NaturalNumber res = new NaturalNumber1L(nnArray[0]);
        if (nnArray.length > 1) {
            NaturalNumber[] tempArray = new NaturalNumber[nnArray.length - 1];
            for (int i = 0; i < tempArray.length; i++) {
                tempArray[i] = new NaturalNumber1L(nnArray[i + 1]);
            }
            res.multiply(productOfArrayElements(tempArray));
        }
        return res;
    }

    /**
     * Replaces each element of {@code nnArray} with the partial product of all
     * the elements in the incoming array, up to and including the current
     * element.
     *
     * @param nnArray
     *            the array
     * @updates nnArray
     * @requires nnArray.length > 0
     * @ensures <pre>
     * for all i: integer where (0 <= i < nnArray.length)
     *   (nnArray[i] = [#nnArray[0] * #nnArray[1] * ... * #nnArray[i]])
     * </pre>
     */
    private static void computePartialProducts(NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";

        if (nnArray.length > 0) {
            for (int i = 1; i < nnArray.length; i++) {
                nnArray[i].multiply(nnArray[i - 1]);
            }
        }
    }

    /**
     * Creates and returns a new array of {@code NaturalNumber}s, of the same
     * size of the given array, containing the partial products of the elements
     * of the given array.
     *
     * @param nnArray
     *            the array
     * @return the array of partial products of the elements of the given array
     * @requires nnArray.length > 0
     * @ensures <pre>
     * partialProducts.length = nnArray.length  and
     *  for all i: integer where (0 <= i < partialProducts.length)
     *    (partialProducts[i] = [nnArray[0] * nnArray[1] * ... * nnArray[i]])
     * </pre>
     */
    private static NaturalNumber[] partialProducts(NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";

        NaturalNumber[] tempArray = new NaturalNumber[nnArray.length];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = new NaturalNumber1L(nnArray[i]);
        }
        computePartialProducts(tempArray);
        return tempArray;

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        /*
         * Initialize an array of NaturalNumbers with values 1 through 42.
         */
        NaturalNumber[] array = new NaturalNumber1L[42];
        NaturalNumber count = new NaturalNumber2(1);
        for (int i = 0; i < array.length; i++) {
            array[i] = new NaturalNumber1L(count);
            count.increment();
        }
        /*
         * Initialize an array of NaturalNumbers with values 1 through 5.
         */
        NaturalNumber[] array2 = new NaturalNumber1L[5];
        NaturalNumber count2 = new NaturalNumber2(1);
        for (int i = 0; i < array2.length; i++) {
            array2[i] = new NaturalNumber1L(count2);

            count2.increment();
        }
        /*
         * Compute and output the product of the numbers in the array (should be
         * 42!, i.e., the factorial of 42).
         */
        NaturalNumber product = productOfArrayElements(array);
        out.println(product);

        /*
         * Compute and output the product of the numbers in the array (should be
         * 5!, i.e., the factorial of 5).
         */
        NaturalNumber product2 = productOfArrayElements(array2);
        out.println(product2);
        /*
         * Compute and output the partial product of the numbers in the new
         * array (should be 5!).
         */

        NaturalNumber[] array3 = partialProducts(array2);
        for (NaturalNumber i : array3) {
            out.println(i + " ");
        }

        out.close();
    }

}