package leetcode.structures;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.09.2024
 **/
public class DesignAStackWithIncrementOperation_1381 {

    private final int[] storage;
    private int pointer = 0;
    public DesignAStackWithIncrementOperation_1381(final int size) {
        this.storage = new int[size];
        pointer = 0;
    }

    public void push(final int x) {
        if(pointer < storage.length) {
            storage[pointer++] = x;
        }
    }

    public int pop() {
        if(pointer > 0) {
            return storage[--pointer];
        }
        return -1;
    }

    public void increment(final int k, final int val) {
        final int max = k > pointer ? pointer : k;
        for(int i=0; i<max; i++) {
            storage[i] += val;
        }
    }

}
