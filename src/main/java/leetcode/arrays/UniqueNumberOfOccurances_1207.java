package leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.11.2022
 **/
public class UniqueNumberOfOccurances_1207 {

    public static void main(String[] args) {
        final int[] input = {1,2,2,1,1,3};
        assert Boolean.TRUE == uniqueOccurrences(input);
    }

    //Time O(n) and Space O(n)
    private static boolean uniqueOccurrences(final int[] arr) {
        final Map<Integer, Integer> occurrences = new HashMap<>();
        for(int val : arr) {
            occurrences.put(val, occurrences.getOrDefault(val, 0) + 1);
        }

        final Set<Integer> uniq = new HashSet<>();
        for(final int occ : occurrences.values()) {
            if(!uniq.add(occ)) {
                return false;
            }
        }
        return true;
    }
}
