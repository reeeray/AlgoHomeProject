package leetcode.structures;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.05.2023
 **/
public class DesignUndergroundSystem_1396 {

    private final Map<Integer, Pair<String, Integer>> checkIn;
    private final Map<String, Pair<Integer, Integer>> stats;


    public DesignUndergroundSystem_1396() {
        this.checkIn = new HashMap<>();
        this.stats = new HashMap<>();
    }

    public void checkIn(final int id, final String stationName, final int time) {
        checkIn.put(id, new Pair<String, Integer>(stationName, time));
    }

    public void checkOut(final int id, final String stationName, final int time) {
        final Pair<String, Integer> pair = checkIn.get(id);
        checkIn.remove(id);
        final String key = pair.getLeft() + "_" + stationName;
        if(stats.containsKey(key)) {
            final Pair<Integer, Integer> statsPair = stats.get(key);
            stats.put(key, new Pair<Integer, Integer>(statsPair.getLeft() + (time - pair.getRight()), statsPair.getRight() + 1));
        } else {
            stats.put(key, new Pair<>((time - pair.getRight()), 1));
        }
    }

    public double getAverageTime(final String startStation, final String endStation) {
        final String key = startStation + "_" + endStation;
        final Pair<Integer, Integer> pair = stats.get(key);
        return pair.getLeft()/ (1.0 *pair.getRight());
    }


    private static class Pair<T, V> {
       final private T left;
       final private V right;

       public Pair(final T left, final V right) {
           this.left = left;
           this.right = right;
       }

       public T getLeft() {
           return this.left;
       }

       public V getRight() {
           return this.right;
       }
    }

}
