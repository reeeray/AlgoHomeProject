package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.08.2025
 **/
public class PowerOfFour_42 {


    public static void main(String[] args) {
        isPowerOfFour(16);
    }

    //important to start with similar task but power of two which is simplier and is a prerequisit to this one
    public static boolean isPowerOfTwo(final int n) {
        return n > 0 && (n&(n-1)) == 0;
    }

    public static boolean isPowerOfFour(final int n) {
        if(n < 1 || (n&(n-1)) != 0)
            return false;
        final int lenOfBinaryRepr = Integer.toBinaryString(n).length();
        return lenOfBinaryRepr % 2 == 1;
    }

    //Time O(1) and Space O(1)
    public boolean isPowerOfFourMoreElegant(int n) {
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
