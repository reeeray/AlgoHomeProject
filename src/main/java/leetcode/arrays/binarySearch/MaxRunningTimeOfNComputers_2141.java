package leetcode.arrays.binarySearch;

import patterns.creational.factory.Page;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.07.2023
 **/
public class MaxRunningTimeOfNComputers_2141 {

    public static void main(String[] args) {

    }

    public static long maxRuntTime(final int n, final int[] battaries) {
        long sumPower = Arrays.stream(battaries).sum();
        long left = 0, right = (int)sumPower / n, mid;
        while(left < right) {
            mid = (left + right) / 2;
            long extra = 0;
            for(int val : battaries) {
                extra += Math.min(val, mid);
            }

            if(extra >= (long)(n * mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
