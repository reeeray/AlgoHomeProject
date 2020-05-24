package coursera.data_structures.queue;

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

    private class Node {
        T item;
        Node next;
    }
}
