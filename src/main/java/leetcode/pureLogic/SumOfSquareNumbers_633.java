package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.06.2024
 **/
public class SumOfSquareNumbers_633 {

    public static void main(String[] args) {
        judgeSquareSumOpt(5);
    }

    //Spce O(1) but Time complexity is O(n^2)
    public static boolean judgeSquareSum(final int c) {
        for(int i=0; i*i <= c; i++) {
            final double b = Math.sqrt(c - i*i);
            if(b == (int)b) {
                return true;
            }
        }
        return false;
    }

    //Space O(1) and Time O(n)
    public static boolean judgeSquareSumOpt(final int c) {
        long b = (int) Math.ceil(Math.pow(c, 0.5));
        long a = 0;

        while(a <= b) {
            final long val = a*a + b*b;
            if(val == c) {
                return true;
            } else if(val > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }
}
