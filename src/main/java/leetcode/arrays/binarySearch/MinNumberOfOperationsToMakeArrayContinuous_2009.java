package leetcode.arrays.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.10.2023
 **/
public class MinNumberOfOperationsToMakeArrayContinuous_2009 {

    public static void main(String[] args) {

    }

    private static int minOperations(final int[] nums) {
        final int n = nums.length;
        final Set<Integer> uniqe = new HashSet<>();

        for(int num : nums) {
            uniqe.add(num);
        }

        final int[] uniqeNums = new int[uniqe.size()];
        int index = 0;
        for(int num : uniqe) {
            uniqeNums[index++] = num;
        }

        Arrays.sort(uniqeNums);
        int answ = -1;
        for(int i=0; i<uniqeNums.length; i++) {
            final int left = uniqeNums[i];
            final int right = left + n - 1;
            final int j = binarySearch(uniqeNums, right);
            answ = Math.min(answ, n - (j - i));
        }
        return answ;
    }

    final static int binarySearch(final int[] nums, final int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            final int mid = (left + right) / 2;
            if(nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int minOperationsSlidingWindow(final int[] nums) {
        final int n = nums.length;
        int ans = n;

        final HashSet<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }

        final int[] newNums = new int[unique.size()];
        int index = 0;

        for (int num : unique) {
            newNums[index++] = num;
        }

        Arrays.sort(newNums);

        int j = 0;
        for (int i = 0; i < newNums.length; i++) {
            while (j < newNums.length && newNums[j] < newNums[i] + n) {
                j++;
            }

            int count = j - i;
            ans = Math.min(ans, n - count);
        }

        return ans;
    }
}
