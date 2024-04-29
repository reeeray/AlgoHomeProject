package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.04.2024
 **/
public class MinNumberOfOperationsToMakeArrayXOREqualToK_2997 {

    public static void main(String[] args) {

    }

    public static int minOperations(final int[] nums, int k) {
        //result of basic final XOR
        int finalXOR = 0;
        for(final int num : nums) {
            finalXOR ^= num;
        }

        int res = 0;
        while( finalXOR > 0 || k > 0) {
            if((k/2) != (finalXOR/2)) {
                res++;
            }
            finalXOR /= 2;
            k /= 2;
        }
        return res;
    }

    public static int minOperationsElegant(final int[] nums, final int k) {
        int finalXOR = 0;
        for(final int num : nums) {
            finalXOR ^= num;
        }
        return Integer.bitCount(finalXOR^k);
    }
}
