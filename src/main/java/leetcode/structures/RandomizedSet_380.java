package leetcode.structures;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.01.2024
 **/
public class RandomizedSet_380 {

    private final List<Integer> values;
    private final Map<Integer, Integer> hashIndexes;

    public RandomizedSet_380() {
        values = new ArrayList<>();
        hashIndexes = new HashMap<>();
    }

    public boolean insert(final int val) {
        if(hashIndexes.containsKey(val)) {
            return false;
        }

        values.add(val);
        hashIndexes.put(val, values.size() - 1);
        return true;
    }

    public boolean remove(final int val) {
        if(!hashIndexes.containsKey(val)) {
            return false;
        }

        final int index = hashIndexes.get(val);
        values.set(index, values.get(values.size() - 1));
        hashIndexes.put(values.get(index), index);
        values.remove(values.size() - 1);
        hashIndexes.remove(val);
        return true;
    }

    public int getRandom() {
        final Random rnd = new Random();
        return values.get(rnd.nextInt(values.size()));
    }
}
