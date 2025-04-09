package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.04.2025
 **/
public class MinOperationsToMakeArrayValuesEqualToK_3375 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public static int minOperations(final int[] nums, final int k) {
        final Set<Integer> unique = new HashSet<>();
        for(final int num : nums) {
            if(num < k) {
                return -1;
            }
            if(num > k) {
                unique.add(num);
            }
        }
        return unique.size();
    }
}
