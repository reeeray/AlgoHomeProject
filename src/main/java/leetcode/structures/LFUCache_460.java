package leetcode.structures;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.01.2023
 **/
public class LFUCache_460 {

    private int minFrequency;
    private int capacity;
    //key - key, value - pair of frequency and value
    private final Map<Integer, Pair> cache;
    //key - frequency, value - list of keys in order of invocation
    private final Map<Integer, LinkedHashSet<Integer>> frequencies;

    public LFUCache_460(final int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencies = new HashMap<>();
    }

    public int get(final int key) {
        final Pair freqAndValue = cache.get(key);
        if(freqAndValue == null) {
            return -1;
        }

        final int freq = freqAndValue.getKey();
        final Set<Integer> keysForThisFreq = frequencies.get(freq);
        keysForThisFreq.remove(key);

        if(minFrequency == freq && keysForThisFreq.isEmpty()) {
            minFrequency++;
        }
        insert(key, freq+1, freqAndValue.getValue());
        return freqAndValue.getValue();

    }

    private void insert(final int key, final int freq, final int value) {
        final Pair pair = new Pair(freq, value);
        cache.put(key, pair);
        frequencies.computeIfAbsent(freq, v -> new LinkedHashSet<>()).add(key);
    }

    public void put(final int key, final int value) {
        if (capacity <= 0) {
            return;
        }
        final Pair freqAndValue = cache.get(key);
        if (freqAndValue != null) {
            cache.put(key, new Pair(freqAndValue.getKey(), value));
            get(key);
            return;
        }
        if (capacity == cache.size()) {
            final Set<Integer> keys = frequencies.get(minFrequency);
            final int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
        }
        minFrequency = 1;
        insert(key, 1, value);
    }

    @AllArgsConstructor
    @Getter
    private static class Pair {
        private Integer key;
        private Integer value;

        public Pair(final int key, final int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}
