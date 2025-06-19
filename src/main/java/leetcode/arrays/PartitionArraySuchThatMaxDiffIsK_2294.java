package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.06.2025
 **/
public class PartitionArraySuchThatMaxDiffIsK_2294 {

    public static void main(String[] args) {
        partitionArray(new int[] {16,8,17,0,3,17,8,20}, 10);
    }

    //Time O)nlogn) and because in Java it's used Quick sort algorithm with extra Space O(logn)
    public static int partitionArray(final int[] nums, final int k) {
        int res = 0;
        Arrays.sort(nums);
        int start = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[start] > k) {
                res++;
                start = i;
            }
        }
        return ++res;
    }
}
