import java.util.Comparator;

import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Layered implementations of secondary method {@code sort} for
 * {@code Queue<String>}.
 */
public final class Queue1LSort1 extends Queue1L<String> {

    /**
     * No-argument constructor.
     */
    public Queue1LSort1() {
        super();
    }

    /**
     * Removes and returns the minimum value from {@code q} according to the
     * ordering provided by the {@code compare} method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to compare entries
     * @return the minimum value from {@code q}
     * @updates q
     * @requires <pre>
     * q /= empty_string  and
     *  [the relation computed by order.compare is a total preorder]
     * </pre>
     * @ensures <pre>
     * (q * <removeMin>) is permutation of #q  and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     * </pre>
     */
    private static String removeMin(Queue<String> q, Comparator<String> order) {
        assert q != null : "Violation of: q is not null";
        assert order != null : "Violation of: order is not null";

        String min = q.dequeue();
        q.enqueue(min);
        //first find and update the minimum
        for (String s : q) {
            if (order.compare(min, s) > 0) {
                min = s;
            }
        }
        //then find and remove this minimum
//i am not sure currently this q has been sorted or not

        Queue<String> temp = new Queue1L<>();
        for (String element : q) {
            if (element != min) {
//            if (!element.equals(min)) {
                //there is only one unique min string that i don't want to add
                //so it is correct to use "!= " instead of using "equal"
                temp.enqueue(element);
                //therefore this temp doesn't contain the min String
            }
        }
        q.transferFrom(temp);

        return min;
    }

    @Override
    public void sort(Comparator<String> order) {
        assert order != null : "Violation of: order is not null";

        Queue<String> temp = new Queue1L<>();
        while (this.length() > 0) {
            String min = removeMin(this, order);
            //this q current min

            temp.enqueue(min);
            //so that every time this temp add element from the smallest to biggest
        }
        this.transferFrom(temp);
    }

}
