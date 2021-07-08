package leetcode.arrays;

import java.util.*;

/**
 * 1338. Reduce array size to the half.
 * <p>
 * Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
 * <p>
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 06.07.2021
 **/
public class ReduceArraySizeToTheHalf_1338 {

    public static void main(String[] args) {
        System.out.println(minSetSize(new int[]{1000, 1000, 3, 7}));
    }

    private static int minSetSize(final int[] arr) {
        int halfL = arr.length / 2;
        final Map<Integer, Integer> freq = new HashMap<>();
        for (final int val : arr) {
            freq.putIfAbsent(val, 0);
            freq.put(val, freq.get(val) + 1);
        }
//        final Map<Integer, Integer> sorted = freq.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByKey().reversed()).collect(Collectors.toMap(
//                Map.Entry::getKey,
//                Map.Entry::getValue,
//                (oldValue, newValue) -> oldValue,
//                LinkedHashMap::new
//        ));
        final List<Integer> sorted = new ArrayList<>(freq.values());
        Collections.sort(sorted, Collections.reverseOrder());
        int sum = 0, res = 0;
        for (final int val : sorted) {
            sum += val;
            res++;
            if (sum >= halfL)
                break;
        }
        return res;
    }


}
