package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.01.2023
 **/
public class NthTribonacci_1137 {

    public static void main(String[] args) {
        assert 1_389_537 == tribonacci(25);
    }

    private static int tribonacci(final int n) {
        final int[] nearest = {0, 1, 1};
        for(int i=3; i<=n; i++) {
            nearest[i%3] = nearest[0] + nearest[1] + nearest[2];
        }
        return nearest[n%3];
    }

}
