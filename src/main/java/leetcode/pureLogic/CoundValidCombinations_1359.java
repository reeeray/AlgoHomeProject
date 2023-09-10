package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.09.2023
 **/
public class CoundValidCombinations_1359 {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        assert countOrdersMath(8) == countOrders(8);
    }

    public static int countOrders(final int n) {
        if(n == 1) {
            return 1;
        }
        final long count = (1l * countOrders(n-1) * (2 * n - 1) * n) % MOD;
        return (int)count;
    }

    //Combinatorial math
    //C = (2*n)! / (2^n)
    public static int countOrdersMath(final int n) {
        long numerator = 1;

        for(int i=2; i<=2*n; i++) {
            numerator *= i;
        }

        final double devider = Math.pow(2, n);

        final double answer = numerator / devider;
        return (int)(answer % MOD);
    }
}
