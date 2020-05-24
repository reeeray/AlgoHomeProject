package coursera.data_structures.stack;

import coursera.data_structures.stack.Stack;

import java.util.Iterator;

/**
 *              best    worst   amortized
 * construct     1       1       1
 * push          1       N       1
 * pop           1       N       1
 * size          1       1       1
 * @param <T> parameter of the stack
 */
public class StackArray<T> implements Stack<T>, Iterable<T> {

    private T[] array;
    private int N;

    public StackArray() {
        array = (T[]) new Object[1];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void push(T t) {
        if(N == array.length)
            resize( 2 * array.length);
        array[N++] = t;
    }

    @Override
    public T pop() {
        T item = array[--N];
        array[N] = null;
        if(N>0 && N == array.length / 4)
            resize(array.length / 2);
        return item;
    }

    private void resize(final int capacity) {
        final T[] copy = (T[]) new Object[capacity];
        for(int i=0; i<array.length; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return array[--i];
        }

        @Override
        public void remove() {

        }
    }
}
