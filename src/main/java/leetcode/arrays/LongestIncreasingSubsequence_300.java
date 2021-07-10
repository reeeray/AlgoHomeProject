package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 300. Longest Increasing Subsequence.
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 09.07.2021
 **/
public class LongestIncreasingSubsequence_300 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    private static int lengthOfLIS(final int[] arr) {
        final List<Integer> sub = new ArrayList<>();
        sub.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > sub.get(sub.size() - 1)) {
                sub.add(arr[i]);
            } else {
                final int j = binarySearch(sub, arr[i]);

                sub.set(j, arr[i]);
            }
        }
        return sub.size();
    }

    private static int binarySearch(final List<Integer> sub, final int num) {
        int left = 0, right = sub.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (sub.get(mid) == num)
                return mid;
            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
