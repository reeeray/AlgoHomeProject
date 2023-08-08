package leetcode.search;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.08.2023
 **/
public class SearchInRotatedSortedArray_33 {

    public static void main(String[] args) {
        final int[] input = {4,5,6,7,0,1,2};
        System.out.println(search(input, 0));
    }

    public static int search(final int[] sum, final int target) {
        int left = 0, right =sum.length-1;
        if(sum[right] < sum[left]) {
            while (left < right) {
                int mid = (left + right) / 2;
                if (sum[0] <= sum[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
//        final int[] sorted = new int[sum.length];
//        System.arraycopy(sum, left, sorted, 0, sum.length - left);
//        System.arraycopy(sum, 0, sorted, sum.length - left, left);
        int l=0,r;
        if(sum[sum.length - 1] >= target) {
            l = left;
            r = sum.length - 1;
        } else {
            r = left - 1;
        }
        while(l <= r) {
            final int mid = (l + r)/2;
            if(sum[mid] == target) {
                return mid;
            } else if(sum[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
