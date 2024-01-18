package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.01.2024
 **/
public class ClimbingStairs_70 {

    public static void main(String[] args) {

    }

    public static int climbStairs(final int n) {
        final int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    //Space O(1) and Time O(n)
    public static int climbStairsOptimized(final int n) {
        int c =0, a = 0, b = 1;

        for(int i=0; i<n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    //Space O(1) and Time O(n^2). Combinatorian C(n, k) = n! / k! (n-k)!
    public static int climbStairsMath(final int n) {
        int ways = 1;

        for (int i = 1; i <= n / 2; i++) {
            double sum = 1;

            for (int j = i; j < 2 * i; j++) {
                sum *= (double)(n - j) / (j - i + 1);
            }

            ways += sum;
        }

        return ways;
    }
}
