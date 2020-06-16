package coursera.data_structures.priority_queues;

/**
 * Priority Queue based on binary tree.
 * *                     insert  delMax  max
 * * unordered array      1        N     N
 * * ordered   array      N        1     1
 * * binary heap        logN     logN   logN
 * User : Shein G.A.{@reeeray}
 * Date : 31.05.2020
 **/
public class HeapMaxPQ<Item extends Comparable<Item>> {

    private Item[] pqueue;
    private int N;

    public HeapMaxPQ(final int capacity) {
        pqueue = (Item[]) new Comparable[capacity + 1]; //we don't use position 0
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * At most 1 + logN compares
     *
     * @param item
     */
    public void insert(final Item item) {
        pqueue[++N] = item; //put item into last node
        swim(N); // exchange nodes if needed
    }

    /**
     * Exchange key in child with key in parent. Repeat until heap order restored
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k, k / 2); //k/2 - parent of the node k
            k = k / 2;
        }
    }

    /**
     * Exchange key in parent node with a larger child.
     * Repeat untill heap order restored.
     */
    private void sink(int k) {
        while (2 * k <= N) { //children of node k are 2*k and 2*k + 1
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    public Item delMax() {
        final Item max = pqueue[1];
        exchange(1, N--);
        sink(1);
        pqueue[N + 1] = null; //prevent loitering
        return max;
    }

    private boolean less(final int i, final int j) {
        return pqueue[i].compareTo(pqueue[j]) < 0;
    }

    private void exchange(final int index1, final int index2) {
        final Item item = pqueue[index1];
        pqueue[index1] = pqueue[index2];
        pqueue[index2] = item;
    }

}
