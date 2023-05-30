package leetcode.structures;

import java.util.Arrays;
import java.util.HashSet;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.05.2023
 **/
public class DesignHashSet_705 {

    private final int[] STORAGE;

    public DesignHashSet_705() {
        STORAGE = new int [1<<20];
        Arrays.fill(STORAGE, -1);
    }

    public void add(final int key) {
        STORAGE[key] = key;
    }

    public boolean contains(final int key) {
        return STORAGE[key] == -1 ? false : true;
    }

    public void remove(final int key) {
        STORAGE[key] = -1;
    }
}
