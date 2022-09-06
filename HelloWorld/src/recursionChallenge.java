import components.queue.Queue;
import components.stack.Stack;

public class recursionChallenge {
    public static void removeString1(Queue<Stack<String>> q, String remove) {
        if (q.length() > 0) {
            Stack<String> entry = q.dequeue();
            removeString1(q, remove);

            Stack<String> temp = entry.newInstance();
            temp.transferFrom(entry);

            while (temp.length() > 0) {
                String stackString = temp.pop();
                if (!entry.equals(stackString)) {
                    entry.push(stackString);
                }
            }
            q.enqueue(entry);
        }

    }

    public static void removeString(Queue<String> q, String remove) {
        if (q.length() > 0) {
            String entry = q.dequeue();
            removeString(q, remove);

            if (!entry.equals(remove)) {
                q.enqueue(entry);
            }

        }
    }

}
