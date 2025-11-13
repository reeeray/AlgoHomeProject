package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.11.2025
 **/
public class MaxNumberOfOperationsToMoveOnesToTheEnd_3228 {

    public static void main(String[] args) {
        maxOperations("1001101");
    }

    public static int maxOperations(final String s) {
        int counter = 0;
        int ones = 0;
        boolean prevZero = false;
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '1') {
                ones++;
                prevZero = false;
            } else {
                if(!prevZero) counter += ones;
                prevZero = true;
            }
        }
        if(!prevZero && s.charAt(s.length() - 1) == '0') counter += ones;
        return counter;
    }

    //Time O(n) and Space O(1)
    public int maxOperationsWhileLoop(String s) {
        int countOne = 0;
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                while (i + 1 < s.length() && s.charAt(i + 1) == '0') {
                    i++;
                }
                ans += countOne;
            } else {
                countOne++;
            }
            i++;
        }
        return ans;
    }
}
