package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.11.2023
 **/
public class MaxElementAfterDecreasingAndRearranging_1846 {

    public static void main(String[] args) {

    }

    //Greedy Time O(n*log(n)) Space O(n)
    public static int maximumElementAfterDecrementingAndRearranging(final int[] arr) {
        Arrays.sort(arr);
        int ans = 1;

        for(int i=1; i<arr.length; i++) {
            if(arr[i] >= ans + 1) {
                ans++;
            }
        }
        return ans;
    }

    //O(n) Space O(n) without sort
    public static int maximumElementAfterDecrementingAndRearrangingOptimized(int[] arr) {
        int n = arr.length;
        int[] counts = new int[n + 1];

        for (int num : arr) {
            counts[Math.min(num, n)]++;
        }

        int ans = 1;
        for (int num = 2; num <= n; num++) {
            ans = Math.min(ans + counts[num], num);
        }

        return ans;
    }
}
