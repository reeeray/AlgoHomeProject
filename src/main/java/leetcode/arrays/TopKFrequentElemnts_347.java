package leetcode.arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.05.2023
 **/
public class TopKFrequentElemnts_347 {

    public static void main(String[] args) {

    }

    private static int[] topKFrequent(final int[] nums, final int k) {
        final Map<Integer, Integer> countMap = new HashMap<>();
        for(final int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return countMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.<Integer, Integer>comparingByValue())).limit(k).mapToInt(Map.Entry::getKey).toArray();
    }
}
