package leetcode.algos;

import java.util.Arrays;

/**
 *
 * Known problem. Resplution is Floyd's algorithm
 * User : Shein G.A.{@reeeray}
 * Date : 19.09.2023
 **/
public class FindTheDuplicateNumber_287 {

    public static void main(String[] args) {

    }

    //Floyds algo
    public int findDuplicates(final int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    //Space O(n) and Time O(n)
    public static int findDuplicatesNotOptimal(final int[] nums) {
        final boolean[] ref = new boolean[nums.length];
        for(int num : nums) {
            if(ref[num-1]) {
                return num;
            }
            ref[num-1] = true;
        }
        return -1;
    }
}
