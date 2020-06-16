package coursera.data_structures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueLinkedList <T> implements Queue<T>{

    private Node first, last;

    @Override
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    @Override
    public T dequeue() {
        final T item = first.item;
        first = first.next;
        if(isEmpty())
            last = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<T> iterator() {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<T> {
        private Node current;

        public LinkedIterator(Node first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        T item;
        Node next;
    }
}
