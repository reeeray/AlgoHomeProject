package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.04.2025
 **/
public class CountGoodNumbers_1922 {

    private static final int MOD = (int)(1e9 + 7);
    public static void main(String[] args) {

    }

    //Time O(logn) and Space O(1)
    public static int countGoodNumbers(final long n) {
        //it's a cominatorics, we have 5 cominations at even positions (0, 2, 4, 6, 8) and we have (n + 1)/2 even position and we have 4 combinations of prior digits(2, 3, 5, 7) at even positions n/2
        return (int)((smartPower(5, (n + 1) / 2) * smartPower(4, n / 2)) % MOD);
    }

    // use fast exponentiation to calculate x^y % mod
    public static long smartPower(final int x, long y) {
        long ret = 1;
        long mul = x;
        while (y > 0) {
            if (y % 2 == 1) {
                ret = (ret * mul) % MOD;
            }
            mul = (mul * mul) % MOD;
            y /= 2;
        }

        return ret;
    }

}
