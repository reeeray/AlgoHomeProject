package leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 658. Find K closest elements.
 * <p>
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <p>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 02.07.2021
 **/

public class FindKClosestElements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findKClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9).toArray()));
    }


    private static List<Integer> findKClosestElements(final int[] arr, final int k, final int x) {
        final List<Integer> res = new ArrayList<>();

        int lIndex = findCrossOver(arr, 0, arr.length - 1, x), rIndex = lIndex + 1;
        for (int i = k; i > 0; i--) {
            int lVal = Integer.MIN_VALUE;
            int rVal = Integer.MAX_VALUE;
            if (lIndex >= 0)
                lVal = arr[lIndex];
            if (rIndex < arr.length)
                rVal = arr[rIndex];
            if (lVal != Integer.MIN_VALUE && rVal != Integer.MAX_VALUE) {
                final int exp1 = Math.abs(lVal - x);
                final int exp2 = Math.abs(rVal - x);
                if (exp1 < exp2 || (exp1 == exp2 && lVal < rVal)) {
                    res.add(lVal);
                    lIndex--;
                } else {
                    res.add(rVal);
                    rIndex++;
                }
            } else {
                if (lVal != Integer.MIN_VALUE) {
                    res.add(lVal);
                    lIndex--;
                } else {
                    res.add(rVal);
                    rIndex++;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    /* Function to find the cross over point (the point before
    which elements are smaller than or equal to x and after
    which greater than x)*/
    private static int findCrossOver(int arr[], int low, int high, int x) {
        // Base cases
        if (arr[high] <= x) // x is greater than all
            return high;
        if (arr[low] > x)  // x is smaller than all
            return low;

        // Find the middle point
        int mid = (low + high) / 2;  /* low + (high - low)/2 */

        /* If x is same as middle element, then return mid */
        if (arr[mid] <= x && arr[mid + 1] > x)
            return mid;

        /* If x is greater than arr[mid], then either arr[mid + 1]
          is ceiling of x or ceiling lies in arr[mid+1...high] */
        if (arr[mid] < x)
            return findCrossOver(arr, mid + 1, high, x);

        return findCrossOver(arr, low, mid - 1, x);
    }
}
