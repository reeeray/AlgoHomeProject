package coursera.deques_and_randomized_queues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] array;
    private int n;

    // construct an empty randomized queue
    public RandomizedQueue() {
        array = (Item[]) new Object[2];
        n = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if(item == null) throw new NullPointerException("Item must not be null");
        if (n == array.length) resize(array.length * 2);
        if(n == 0) {
            array[n++] = item;
            return;
        }
        int randomIndex = StdRandom.uniform(n);
        Item temp = array[randomIndex];
        array[randomIndex] = item;
        array[n++] = temp;
    }

    // remove and return a random item
    public Item dequeue() {
        if(isEmpty()) throw new NoSuchElementException();
        if(n == array.length / 4) resize(array.length / 2);
        int randomIndex = StdRandom.uniform(n);
        Item item = array[randomIndex];
        array[randomIndex] = array[--n];
        //to prevent loitering
        array[n] = null;
        return item;
    }

    private void resize(final int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        for(int i=0; i<array.length; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if(isEmpty()) throw new NoSuchElementException();
        return array[StdRandom.uniform(n)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i;
        private int[] randomIndices;

        public ArrayIterator() {
            i = 0;
            randomIndices = new int[n];
            for (int j = 0; j < n; j++) {
                randomIndices[j] = j;
            }
            StdRandom.shuffle(randomIndices);
        }

        @Override
        public boolean hasNext() {
            return i < n;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            return array[randomIndices[i++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.size());
        for (Integer i : queue) {
            System.out.println(i);
        }
        System.out.println("sample:" + queue.sample());
        System.out.println("dequeue");
        while (!queue.isEmpty()) System.out.println(queue.dequeue());
        System.out.println(queue.size());
    }
}
