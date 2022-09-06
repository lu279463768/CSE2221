import components.set.Set;
import components.set.Set1L;

/**
 * Layered implementations of secondary methods {@code add} and {@code remove}
 * for {@code Set}.
 *
 * @param <T>
 *            type of {@code Set} elements
 */
public final class SetSecondary1L<T> extends Set1L<T> {
    /**
     * No-argument constructor.
     */
    public SetSecondary1L() {
        super();
    }

    /**
     * Removes from this all elements of s that are also in this, leaving s
     * unchanged, and returns the elements actually removed.
     */

    @Override
    public Set<T> remove(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        Set<T> removed = new Set1L<>();
        for (T element : s) {
            if (this.contains(element)) {
                this.remove(element);
                removed.add(element);
            }
        }

        return removed;
    }

    /**
     * Adds to this all elements of s that are not already in this, also
     * removing just those elements from s.
     */
    @Override
    public void add(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        for (T element : s) {
            if (!this.contains(element)) {
                this.add(element);
                s.remove(element);
            }
        }

    }

}