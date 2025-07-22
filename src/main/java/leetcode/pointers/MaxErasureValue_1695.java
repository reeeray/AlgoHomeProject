package leetcode.pointers;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.07.2025
 **/
public class MaxErasureValue_1695 {

    public static void main(String[] args) {
        maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5});
    }

    public static int maximumUniqueSubarray(final int[] nums) {
        final Set<Integer> unique = new HashSet<>();
        int currMaxScore = 0;
        int res = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if(!unique.add(nums[right])) {
                while (nums[left] != nums[right]) {
                    currMaxScore -= nums[left];
                    unique.remove(nums[left++]);
                }
                currMaxScore -= nums[left++];
            }
            currMaxScore += nums[right++];
            res = Math.max(res, currMaxScore);
        }
        return res;
    }
}
