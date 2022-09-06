import components.stack.Stack;
import components.stack.Stack1L;

/**
 * Model class.
 *
 * @author Vivian Lu
 */
public final class AppendUndoModel1 implements AppendUndoModel {

    /**
     * Model variables.
     */
    private String input, output;

    /**
     * Default constructor.
     */
    public AppendUndoModel1() {
        /*
         * Initialize model; both variables start as empty strings
         */
        this.input = "";
        this.output = "";
    }

    @Override
    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String input() {
        return this.input;
    }

    @Override
    public Stack<String> output() {
        Stack<String> stack = new Stack1L<>();
        stack.push(this.output);
        return stack;
    }

}
