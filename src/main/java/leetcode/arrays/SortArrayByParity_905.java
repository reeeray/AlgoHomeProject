package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.09.2023
 **/
public class SortArrayByParity_905 {

    public static void main(String[] args) {
        final int[] input = new int[] {1, 0, 3};
        System.out.println(Arrays.toString(sortArrayByParity(input)));
    }

    //using merge sort algo
    private static int[] sortArrayByParity(final int[] nums) {
        final int n = nums.length;
        if(n == 1) {
            return nums;
        }

        final int[] left = sortArrayByParity(Arrays.copyOfRange(nums, 0, n/2));
        final int[] right = sortArrayByParity(Arrays.copyOfRange(nums, n/2, n));
        final int[] merged = new int[n];
        int leftP = 0;
        int rightP = 0;
        for(int i=0; i<n; i++) {
            if(leftP < left.length && rightP < right.length) {
                if((left[leftP] % 2 == 0 && right[rightP] % 2 == 0) || (left[leftP] % 2 != 0 && right[rightP] % 2 != 0)) {
                    merged[i] = left[leftP] < right[rightP] ? left[leftP++] : right[rightP++];
                } else if(left[leftP] % 2 == 0) {
                    merged[i] = left[leftP++];
                } else {
                    merged[i] = right[rightP++];
                }
            } else if (leftP < left.length) {
                merged[i] = left[leftP++];
            } else {
                merged[i] = right[rightP++];
            }
        }
        return merged;
    }

    //sorting by parity but without ordering
    private static int[] sortArrayByParityWithoutOrder(final int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            while (i < j && nums[i] % 2 == 0)
                i++;
            while (i < j && nums[j] % 2 == 1)
                j--;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}
