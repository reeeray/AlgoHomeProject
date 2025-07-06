package leetcode.structures;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.07.2025
 **/
public class FindingPairsWithACertainSum_1865 {

    private static int[] nums1;
    private static int[] nums2;
    private static Map<Integer, Integer> frequency;
    public static void main(String[] args) {

    }

    public FindingPairsWithACertainSum_1865(final int[] nums1, final int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        frequency = new HashMap<>();
        for(final int num : nums2) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
    }

    public static void add(final int index, final int val) {
        final int oldValue = nums2[index];
        nums2[index]+= val;
        frequency.put(oldValue, frequency.get(oldValue) - 1);
        if(frequency.get(oldValue) == 0) {
            frequency.remove(oldValue);
        }
        frequency.put(nums2[index], frequency.getOrDefault(nums2[index], 0) + 1);
    }

    public static int count(final int tot) {
        int res = 0;
        for(final int num : nums1) {
            res += frequency.getOrDefault(tot - num, 0);
        }
        return res;
    }
}
