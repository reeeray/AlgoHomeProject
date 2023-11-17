package leetcode.pureLogic;

import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.11.2023
 **/
public class MinPairSum_1877 {

    public static void main(String[] args) {

    }

    //Time complexity O(Nlogn) and O(lonN)
    public static int minPairSum(final int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        int max = 0;
        for(int i=0; i< n/2; i++) {
            max = Math.max(max, nums[i] + nums[n-1-i]);
        }
        return max;
    }
}
