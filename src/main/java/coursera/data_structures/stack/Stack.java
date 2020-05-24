package coursera.data_structures.stack;

/**
 * you can implement Dexters algorithm about calculation of math expression by using two stacks
 * @param <T>
 */
public interface Stack<T> {

    boolean isEmpty();

    void push(final T t);

    T pop();
}
