package leetcode.arrays;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.11.2022
 **/
public class SumOfSubArrayMins_907 {

    public static void main(String[] args) {
        final int[] input = {11, 81, 94, 43, 3};
        assert 444 == sumSubarraysMins(input);
    }

    private static int sumSubarraysMins(final int[] arr) {
        final int MOD = 1000000007;

        final Stack<Integer> stack = new Stack<>();
        long sumOfMins = 0;

        for(int i=0; i<=arr.length; i++) {

            while(!stack.isEmpty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {
                // Notice the sign ">=", This ensures that no contribution
                // is counted twice. rightBoundary takes equal or smaller
                // elements into account while leftBoundary takes only the
                // strictly smaller elements into account
                int mid = stack.pop();
                int leftBoundary = stack.empty() ? -1 : stack.peek();
                int rightBoundary = i;

                // count of subarrays where mid is the minimum element
                long count = (mid - leftBoundary) * (rightBoundary - mid) % MOD;

                sumOfMins += count * arr[mid] % MOD;
                sumOfMins %= MOD;
            }
            stack.push(i);
        }
        return (int)sumOfMins;
    }
}
