package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.10.2025
 **/
public class MaxNumberOfDistinctElementsAfterOperations_3397 {

    public static void main(String[] args) {

    }

    //Space O(logn) for sorting and Time O(nlogn)
    public static int maxDistinctElements(final int[] nums, final int k) {
        int counter = 0, prev = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i = 0;  i < nums.length; i++) {
            final int curr = Math.min(Math.max(nums[i] - k, prev + 1), nums[i] + k);
            if(curr > prev) {
                counter++;
                prev = curr;
            }
        }
        return counter;
    }
}
