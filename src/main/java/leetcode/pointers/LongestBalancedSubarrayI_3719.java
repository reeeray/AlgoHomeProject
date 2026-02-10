package leetcode.pointers;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.02.2026
 **/
public class LongestBalancedSubarrayI_3719 {

    public static void main(String[] args) {

    }

    //Time O(n^2) and Space O(n)
    public int longestBalanced(final int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            final Set<Integer> odds = new HashSet<>();
            final Set<Integer> evens = new HashSet<>();
            for(int j = i; j< nums.length; j++) {
                var set = nums[j] % 2 == 0 ? evens : odds; // also to check whether it's even nums[j]&1 == 1
                set.add(nums[j]);
                if(odds.size() == evens.size()) {
                    res = Math.max(res, j - i);
                }
            }

        }
        return res;
    }
}
