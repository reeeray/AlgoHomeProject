package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.10.2023
 **/
public class PowerOfFour_342 {

    public static void main(String[] args) {
        isPowerOfFourLogarithmic(8);
    }

    public static boolean isPowerOfFour(final int n) {
        if(n == 1) {
            return true;
        }
        final String binary = Integer.toBinaryString(n);
        if(binary.length() <= 0 || binary.length()%2 == 0 || binary.length() < 3) {
            return false;
        }

        for(int i=1; i<binary.length(); i++) {
            if(binary.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    public static boolean isPowerOfFourRecursive(final int n) {
        return n > 0 && (n == 1 || (n%4==0&&isPowerOfFourRecursive(n/4)));
    }

    public static boolean isPowerOfFourLogarithmic(final int n) {
         if(n == 1) {
             return true;
         }
         if(n <= 0) {
             return false;
         }
         final double log = Math.log(n) / 2;
         return log == (int)log;
    }
}
