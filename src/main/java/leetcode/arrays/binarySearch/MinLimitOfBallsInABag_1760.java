package leetcode.arrays.binarySearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.12.2024
 **/
public class MinLimitOfBallsInABag_1760 {

    public static void main(String[] args) {
        System.out.println(minimumSize(new int[] {9}, 2));
        System.out.println(minimumSize(new int[] {2, 4, 8, 2}, 4));
    }

    public static int minimumSize(final int[] nums, final int maxOperations) {
//        Arrays.sort(nums);
        int left = 1;
//        int right = Arrays.stream(nums).max().getAsInt();
        int right = Integer.MIN_VALUE;
        for(final int num : nums) {
            right = Math.max(right, num);
        }
        while (left < right) {
            final int mid = (left + right) / 2;
            if(isValidNonOrdered(nums, mid, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isValidOrdered(final int[] nums, final int maxSize, int maxOperations) {
        for(int i = nums.length - 1; i>=0; i--) {
            if(nums[i] == maxSize) {
                return true;
            }
            maxOperations -= Math.ceil(nums[i]*1.0 / maxSize) - 1;
            if(maxOperations < 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidNonOrdered(final int[] nums, final int maxSize, int maxOperations) {
        for (final int num : nums) {
//            maxOperations -= Math.ceil(num*1.0 / maxSize) - 1;
            maxOperations-=(num-1)/maxSize;
            if (maxOperations < 0) {
                return false;
            }
        }
        return true;
    }
}
