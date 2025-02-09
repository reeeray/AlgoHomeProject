package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.02.2025
 **/
public class CountNumberOfBadPairs_2364 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public static long countBadPairsOpt(final int[] nums) {
        long counter = 0;
        final Map<Integer, Integer> diffCounter = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            final int diff = nums[i] - i;
            final int diffNumberBefore = diffCounter.getOrDefault(diff, 0 );
            counter += i - diffNumberBefore;
            diffCounter.put(diff, diffNumberBefore + 1);
        }
        return counter;
    }

    //TLE
    public static long countBadPairs(final int[] nums) {
        long counter = 0;
        for(int i=1; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] != nums[i] + (j -i)) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
