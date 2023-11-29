package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.02.2022
 **/
public class NumberOf1Bits_191 {

    public static void main(String[] args) {
    }

    //binary representation of unsigned integer
    public static int hammingWeight(int n) {
        final char[] bits = Integer.toBinaryString(n).toCharArray();
        int counter = 0;
        for (char b : bits) {
            if (b == '1')
                counter++;
        }
        return counter;
    }

    public static int hammingWeightBinary(final int n) {
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                counter++;
        }
        return counter;
    }

    //it works for regular numbers but in assignment it's binary representation of unsigned int
    public static int hammingWeigt2(int n) {
        int counter = 0;
        while (n > 0) {
            if(n % 2 == 1) {
                counter++;
            }
            n = (n / 2);
        }
        return counter;
    }
}
