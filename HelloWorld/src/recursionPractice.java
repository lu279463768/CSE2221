import java.util.Set;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.set.Set1L;
import components.stack.Stack;
import components.stack.Stack1L;

public class recursionPractice {
    Sequence<String> s = new Sequence1L<>();
    Stack<NaturalNumber> stack = new Stack1L<>();

    public boolean isSubsequence(Sequence<String> sub) {
        boolean result = false;
        if (sub.length() <= 0) {
            result = true;
        } else if (sub.length() <= this.s.length()) {
            String curSub = sub.remove(0);
            String cur = this.s.remove(0);

            if (curSub.equals(cur)) {
                result = this.isSubsequence(sub);
                //has found out if its is subsequence or not
                sub.add(0, curSub);
            } else {
                sub.add(0, curSub);
                result = this.isSubsequence(sub);
            }
            //把s 最后加回来的原因：
            this.s.add(0, cur);
        }
        return result;
    }

    public void fibStack(NaturalNumber n) {
        NaturalNumber one = new NaturalNumber2(1);
        NaturalNumber two = new NaturalNumber2(1);
        if (n.compareTo(one) <= 0) {
            this.stack.push(new NaturalNumber2(n));
        } else {
            NaturalNumber temp1 = new NaturalNumber2(n);
            NaturalNumber temp2 = new NaturalNumber2(n);
            temp1.divide(one);
            temp2.divide(two);

            this.fibStack(temp1);
            this.fibStack(temp2);

        }///不太对

    /**
     * Takes all of the numbers out of s and sums them.
     *
     * @clears s
     *
     * @ensures setSum = [sum of all NaturalNumbers in s]
     */
//    public NaturalNumber NaturalNumbersetSum(Set<NaturalNumber> set) {
//        NaturalNumber res = new NaturalNumber2();
//
//        Set<NaturalNumber> s = set.removeAny();
//        while(s.size()>0) {
//               res.add( s.removeAny() );
//            }
//        }
//
//        return res;
//    }

    public static void main(String[] args) {
        Sequence<Integer> s = new Sequence1L<>();
        Sequence<Integer> sub = new Sequence1L<>();

    }
}
