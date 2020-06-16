package coursera.data_structures.priority_queues;

import books.Util;

/**
 * insert  delMax  max
 * unordered array      1        N     N
 * ordered   array      N        1     1
 * binary heap        logN     logN   logN
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 31.05.2020
 **/
public class UnorderedMaxPQ<Item extends Comparable<Item>> {

    private Item[] pqueue;
    private int N;

    public UnorderedMaxPQ(final int capacity) {
        this.pqueue = (Item[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(final Item item) {
        pqueue[N++] = item;
    }

    public Item delMax() {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (Util.less(pqueue[max], pqueue[i])) max = i;
        }
        Util.exchange(pqueue, max, N - 1);
        return pqueue[--N];
    }
}
