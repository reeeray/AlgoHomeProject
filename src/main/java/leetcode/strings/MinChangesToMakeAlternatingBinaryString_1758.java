package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.12.2023
 **/
public class MinChangesToMakeAlternatingBinaryString_1758 {

    public static void main(String[] args) {

    }

    //Space O(n) and Time O(1)
    public static int minOperations(final String s) {
        int startWithOne = 0;
        int startWithZero = 0;
        final char zero = '0';
        final char one = '1';
        char curr = zero;
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == curr) {
                startWithOne++;
            } else {
                startWithZero++;
            }
            curr = curr == zero ? one : zero;
        }
        return Math.min(startWithOne, startWithZero);
    }

    public int minOperationsOptimized(final String s) {
        int start0 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    start0++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    start0++;
                }
            }
        }

        return Math.min(start0, s.length() - start0);
    }
}
