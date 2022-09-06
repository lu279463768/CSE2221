import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    @Test
    public void test_overlap_1() {
        /*
         * Set up variables and call method under test
         */
        String s1 = "ACCCCGTT";
        String s2 = "GTTACTC";
        int res = StringReassembly.overlap(s1, s2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(3, res);
    }

    @Test
    public void test_overlap_2() {
        /*
         * Set up variables and call method under test
         */
        String s1 = "A";
        String s2 = "C";
        int res = StringReassembly.overlap(s1, s2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, res);
    }

    @Test
    public void test_overlap_3() {
        /*
         * Set up variables and call method under test
         */
        String s1 = "AA";
        String s2 = "AC";
        int res = StringReassembly.overlap(s1, s2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(1, res);
    }

    @Test
    public void test_addToSetAvoidingSubstrings_1() {
        /*
         * Set up variables and call method under test
         */
        Set<String> strSet = new Set1L();
        strSet.add("AG");
        strSet.add("GCT");
        strSet.add("CA");

        String s1 = "AGC";
        Set<String> res = strSet.newInstance();
        res.add("CA");
        res.add("GCT");
        res.add(s1);

        StringReassembly.addToSetAvoidingSubstrings(strSet, s1);

        /*
         * Assert that values of variables match expectations
         */

        assertEquals(res, strSet);
    }

    @Test
    public void test_addToSetAvoidingSubstrings_2() {
        /*
         * Set up variables and call method under test
         */
        Set<String> strSet = new Set1L();
        strSet.add("TA");
        strSet.add("GCT");
        strSet.add("CA");

        String s1 = "GC";
        Set<String> res = strSet.newInstance();
        res.add("TA");
        res.add("GCT");
        res.add("CA");

        StringReassembly.addToSetAvoidingSubstrings(strSet, s1);

        /*
         * Assert that values of variables match expectations
         */

        assertEquals(res, strSet);
    }

    @Test
    public void test_addToSetAvoidingSubstrings_3() {
        /*
         * Set up variables and call method under test
         */
        Set<String> strSet = new Set1L();

        String s1 = "GC";
        Set<String> res = strSet.newInstance();
        res.add(s1);

        StringReassembly.addToSetAvoidingSubstrings(strSet, s1);

        /*
         * Assert that values of variables match expectations
         */

        assertEquals(res, strSet);
    }

    @Test
    public void test_linesFromInput_1() {
        /*
         * Set up variables and call method under test
         */
        SimpleReader input = new SimpleReader1L("data/cheer-8-2.txt");

        Set<String> set = StringReassembly.linesFromInput(input);
        Set<String> res = set.newInstance();
        res.add("Bucks -- Beat");
        res.add("Go Bucks");
        res.add("o Bucks -- B");
        res.add("Beat Mich");
        res.add("Michigan~");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(res, set);
    }

    @Test
    public void test_linesFromInput_2() {
        /*
         * Set up variables and call method under test
         */
        SimpleReader input = new SimpleReader1L("data/testText.txt");

        Set<String> set = StringReassembly.linesFromInput(input);
        Set<String> res = set.newInstance();
        res.add("hello");
        res.add("my name is");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(res, set);
    }

    @Test
    public void test_linesFromInput_3() {
        /*
         * Set up variables and call method under test
         */
        SimpleReader input = new SimpleReader1L("data/empty.txt");

        Set<String> set = StringReassembly.linesFromInput(input);
        Set<String> res = set.newInstance();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(res, set);
    }

    @Test
    public void test_printWithLineSeparators_1() {
        /*
         * Set up variables and call method under test
         */
        String text = "Buckeyes~Beat Michigan";
        SimpleWriter out = new SimpleWriter1L("result.txt");

        StringReassembly.printWithLineSeparators(text, out);

        SimpleWriter res = new SimpleWriter1L("expected.txt");
        res.println("Buckeyes");
        res.println("Beat Michigan");

        /*
         * Assert that values of variables match expectations
         */
        SimpleReader in1 = new SimpleReader1L("result.txt");
        SimpleReader in2 = new SimpleReader1L("expected.txt");

        while (!in1.atEOS() && !in2.atEOS()) {
            String actual = in1.nextLine();
            String expect = in2.nextLine();
            assertEquals(expect, actual);
        }
        in1.close();
        in2.close();
        res.close();
    }

    @Test
    public void test_printWithLineSeparators_2() {
        /*
         * Set up variables and call method under test
         */
        String text = "~Buckeyes~";
        SimpleWriter out = new SimpleWriter1L("result.txt");

        StringReassembly.printWithLineSeparators(text, out);

        SimpleWriter res = new SimpleWriter1L("expected.txt");
        res.println("");
        res.println("Buckeyes");

        /*
         * Assert that values of variables match expectations
         */
        SimpleReader in1 = new SimpleReader1L("result.txt");
        SimpleReader in2 = new SimpleReader1L("expected.txt");

        while (!in1.atEOS() && !in2.atEOS()) {
            String actual = in1.nextLine();
            String expect = in2.nextLine();
            assertEquals(expect, actual);
        }
        in1.close();
        in2.close();
        res.close();
    }
}
