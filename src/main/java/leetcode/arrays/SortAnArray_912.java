package leetcode.arrays;

import leetcode.structures.Pair;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.03.2023
 **/
public class SortAnArray_912 {

    public static void main(String[] args) {
        final int[] toSort = {5, 1, 1, 2, 0, 0};

        System.out.println(Arrays.toString(mergeSort(toSort)));
    }

    public static int[] mergeSort(final int[] array) {
        final int left = 0;
        final int right = array.length - 1;
        if(left >= right) {
            return array;
        }
        final int mid = (left + right) / 2;
        final int[] leftHalf = mergeSort(Arrays.copyOfRange(array, left, mid + 1));
        final int[] rightHalf = mergeSort((Arrays.copyOfRange(array, mid + 1, right + 1)));
        return merge(leftHalf, rightHalf);
    }

    //Time O(nlog) and Space O(n)
    private static int[] merge(final int[] left, final int[] right) {
        final int[] res = new int[left.length + right.length];
        int p1 = 0, p2 = 0;
        for(int i=0; i<res.length; i++) {
            if(left.length > p1 && right.length > p2) {
                if(left[p1] < right[p2]) {
                    res[i] = left[p1++];
                } else {
                    res[i] = right[p2++];
                }
            } else {
                if(left.length > p1) {
                    System.arraycopy(left, p1, res, i, left.length - p1);
                    break;
                } else {
                    System.arraycopy(right, p2, res, i, right.length - p2);
                    break;
                }
            }
        }
        return res;
    }

    //Time O(n) and Space O(1) but it's only because of constraints on number of elements which is -5*10^4 to 5*10^4
    public int[] sortArray(final int[] nums) {
        final int[] counts = new int[2 * 50000 + 1];
        for (int num : nums) {
            counts[num + 50000]++;
        }
        int idx = 0;
        for (int n = 0; n < counts.length; n++) {
            int count = counts[n];
            while (count-- != 0) {
                nums[idx++] = n - 50000;
            }
        }
        return nums;
    }


}
