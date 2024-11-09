package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.11.2024
 **/
public class MinArrayEnd_3133 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static long minEnd(int n, final int x) {
        long res = x;
        while (--n > 0) {
            res = (res + 1) | x;
        }
        return res;
    }
}
