package leetcode.binaryStuff;

import patterns.creational.factory.Page;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.02.2024
 **/
public class PowerOfTwo_231 {

    public static void main(String[] args) {
        isPowerOfTwoBinary(4);
    }

    public static boolean isPowerOfTwo(final int n) {
        final char[] s = Integer.toBinaryString(n).toCharArray();
        for(int i=1; i < s.length; i++) {
            if(s[i] == '1') {
                return false;
            }
        }
        return true;
    }

    //sPACE O(1) but time O(Logn)
    public static boolean isPowerOfTwoBinary(final int n) {
        int x = 1;
        while (x <= n) {
            if(x == n) {
                return true;
            }
            if( x > Integer.MAX_VALUE / 2) {
                return false;
            }
            x = x << 1;
        }
        return false;
    }

    //Space O(1) and Time O(1)
    public static boolean isPowerOfTwoBinEff(final int n) {
        return n > 0 && (n&(n-1)) == 0;
    }
}
