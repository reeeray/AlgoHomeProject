package leetcode.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * All the operations should be O(1)
 * User : Shein G.A.{@reeeray}
 * Date : 29.11.2022
 **/
public class InsertDeleteGetRandom_380 {


    private static class RandomizedSet {
        final ArrayList<Integer> random;
        final Map<Integer, Integer> indexes;
        final Random rand;

        public RandomizedSet() {
            this.random = new ArrayList<>();
            this.indexes = new HashMap<>();
            this.rand = new Random();
        }

        public boolean insert(final int val) {
            if(indexes.containsKey(val)) {
                return false;
            }
            indexes.put(val, random.size());
            random.add(val);
            return true;
        }

        public boolean remove(final int val) {
            if(indexes.containsKey(val)) {
                final int index = indexes.get(val);
                random.set(index, random.get(random.size()-1));
                indexes.put(random.get(index), index);
                random.remove(random.size()-1);
                indexes.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            return random.get(rand.nextInt(random.size()));
        }
    }
}
