package leetcode.algos;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.05.2025
 **/
public class DivisibleAndNonDivisibleSumsDifference_2894 {

    public static void main(String[] args) {

    }

    //Time O(1) and Space O(1) based on the formula of arithmetic progression, S = n (n + 1) / 2, so from the whole sum we deduct 2 sums of devisible
    //num2 = m + 2m + 3m + ... +km = (1 + ... + k) m = (k (k + 1) / 2) * m - sum of divisible
    // num1 - sum of undivisible and num1 = num - num2
    // num1 - num2 = num - 2num2 = n(n+1)/ 2 - 2 (k(k + 1) / 2) * m
    public static int differenceOfSumsMathOpt(final int n, final int m) {
        final int k = n / m;
        return (n * (n + 1)) / 2 - (k * (k + 1)) * m;
    }
    //Traverse, Time O(n) and Space O(1)
    public static int differenceOfSums(final int n, final int m) {
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(i % m == 0) {
                ans -= i;
            } else {
                ans += i;
            }
        }
        return ans;
    }
}
