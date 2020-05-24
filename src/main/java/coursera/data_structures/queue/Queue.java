package coursera.data_structures.queue;

public interface Queue<T> {

    void enqueue(T item);

    T dequeue();

    boolean isEmpty();

}
