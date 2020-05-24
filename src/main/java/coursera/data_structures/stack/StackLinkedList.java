package coursera.data_structures.stack;

import coursera.data_structures.stack.Stack;

import java.util.Iterator;

public class StackLinkedList <T> implements Stack<T>, Iterable<T>{

    private Node first = null;

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class Node {
        T item;
        Node next;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void push(final T t) {
        final Node oldFirst = first;
        first = new Node();
        first.item = t;
        first.next = oldFirst;
    }

    @Override
    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }

    private class ListIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
        }
    }
}
