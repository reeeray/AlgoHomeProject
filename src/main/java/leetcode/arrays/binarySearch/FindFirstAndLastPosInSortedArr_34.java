package leetcode.arrays.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.10.2023
 **/
public class FindFirstAndLastPosInSortedArr_34 {

    public static void main(String[] args) {
        final int[] input = {5,7,7,8,8,10};
        final int[] input1 = {1, 3};
        System.out.println(Arrays.toString(searchRange(input1, 1)));
    }

    private static int[] searchRange(final int[] nums, final int target) {
        int right = nums.length;
        int left = 0;
        int pos = -1;
        while (left < right) {
            int mid = (right + left) / 2;
            if(nums[mid] == target) {
                pos = mid;
                break;
            } else if(nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (pos == -1) {
            return new int[]{-1, -1};
        }
        left = pos - 1;
        right = pos + 1;
        while ((left >= 0 && nums[left] == target) || (right < nums.length  && nums[right] == target)) {
            if(left >= 0 && nums[left] == target) {
                left--;
            }
            if(right < nums.length && nums[right] == target) {
                right++;
            }
        }
        return new int[] {left + 1, right -1};
    }
}
