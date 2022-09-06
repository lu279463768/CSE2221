import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

public class ABCDGuesser1 {

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        out.print(
                "Please tell what constant μ should be approximated(must be a positive real number):");

        String input = in.nextLine();

        while (!FormatChecker.canParseDouble(input)
                || (FormatChecker.canParseDouble(input)
                        && Double.parseDouble(input) < 0.0)) {
            out.print("Invalid input.Please input a positive real number:");
            input = in.nextLine();
        }
        double number = Double.parseDouble(input);

        return number;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        out.print(
                "Please tell a personal number(must be a positive real number not equal to 1.0):");

        String input = in.nextLine();
        while (FormatChecker.canParseDouble(input) != true
                || (FormatChecker.canParseDouble(input)
                        && Double.parseDouble(input) == 1.0)
                || (FormatChecker.canParseDouble(input)
                        && Double.parseDouble(input) < 0.0)) {
            out.print(
                    "Invalid input.Please input a positive real number not equal to 1.0:");
            input = in.nextLine();
        }
        double number = Double.parseDouble(input);

        return number;
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
//        int[] arr = { -5, -4, -3, -2, -1, -1 / 2, -1 / 3, -1 / 4, 0, 1 / 4,
//                1 / 3, 1 / 2, 1, 2, 3, 4, 5 };
        //!!!!!I realized i made a stupid mistake!! i should use int array!it's a double array!!!
        double[] arr = { -5, -4, -3, -2, -1, -1.0 / 2, -1.0 / 3, -1.0 / 4, 0,
                1.0 / 4, 1.0 / 3, 1.0 / 2, 1, 2, 3, 4, 5 };
        double μ = getPositiveDouble(in, out);

        double w = getPositiveDoubleNotOne(in, out);

        double x = getPositiveDoubleNotOne(in, out);

        double y = getPositiveDoubleNotOne(in, out);

        double z = getPositiveDoubleNotOne(in, out);

        int i = 0;
//        double multiplier1 = 0;
//        double multiplier2 = 0;
//        double multiplier3 = 0;
//        double multiplier4 = 0;

        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;

        double minRelativeErrrorResult = 0;

        //There are 4 multipliers in the formula (w^a)*(x^b)*(y^c)*(z^d) and I called them multiplier1 to multiplier4
        //use 4 nested while loops:so that every multiplier can use every element in the array as exponent
        //(every exponent has arr.length possibilities so we have to loop every possibility in a new while loop to calculate all possibilities of a multiplier)

        while (i < arr.length) {
            //while i am calculating multiplier1,i can also start loop all the possibilities of multiplier2
            int j = 0;
            while (j < arr.length) {
                //while i am calculating multiplier2,i can also start loop all the possibilities of multiplier3
                int k = 0;
                while (k < arr.length) {

                    //while i am calculating multiplier3,i can also start loop all the possibilities of multiplier4
                    int l = 0;
                    while (l < arr.length) {
                        double multiplier1 = Math.pow(w, arr[i]);
                        double multiplier2 = Math.pow(x, arr[j]);
                        double multiplier3 = Math.pow(y, arr[k]);
                        double multiplier4 = Math.pow(z, arr[l]);

                        //then in this innermost layer loop,i can get all the possibilities of every multipliers
                        //so i multiple them together i can get all the possibilities of the result of (w^a)*(x^b)*(y^c)*(z^d)
                        double res = multiplier1 * multiplier2 * multiplier3
                                * multiplier4;
                        //but at present this result might cannot satisfy the relative error requirement
                        //so i will need to update the new minimum relative error
                        if (Math.abs(res - μ) <= Math
                                .abs(minRelativeErrrorResult - μ)) {
                            minRelativeErrrorResult = res;//continuously update the good current one as minRelativeErrror
                            //and if it's the minRelativeErrror,we can also get the best combination of exponents
                            //which are the  elements at the corresponding indexes in the array
                            a = arr[i];
                            b = arr[j];
                            c = arr[k];
                            d = arr[l];
                        }
                        l++;
                    }
                    k++;

                }
                j++;

            }
            i++;

        }
        double minRelativeErrror = Math.abs((μ - minRelativeErrrorResult) / μ);
        out.println(
                "The values of the exponents a, b, c, and d are respectively: "
                        + a + ", " + b + ", " + c + ", " + d);
        out.print("The value of the formula (w^a)*(x^b)*(y^c)*z^d = ");
        out.println(minRelativeErrrorResult, 2, false);

        out.print(
                "The relative error of the approximation to the nearest hundredth of one percent: ");
        out.print(minRelativeErrror * 100.0, 2, false);
        out.println("%");

    }

}
