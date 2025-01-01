package leetcode.dp;

/**
 * Duplication with package leetcode.strings.MaxScoreAfterSplittingAString_1422;
 * User : Shein G.A.{@reeeray}
 * Date : 01.01.2025
 **/
public class MaxScoreAfterSplittingAString_1422 {

    public static void main(String[] args) {

    }

    //Time O(2n) and Space O(1)
    public static int maxScore(final String s) {
        int ones = 0;
        for(final char c : s.toCharArray()) {
            if(c == '1') {
                ones++;
            }
        }
        int max = 0;
        int zeros = 0;
        for(int i=0; i<s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones--;
            } else {
                zeros++;
            }
            max = Math.max(max, zeros + ones);
        }
        return max;
    }

    //Space O(1) and time O(n), two times faster than previous
    public static int maxScoreOnePass(final String s) {
        int zeros = 0;
        int ones = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<s.length() - 1; i++) {
            if(s.charAt(i) == '1') {
                ones++;
            } else {
                zeros++;
            }
            max = Math.max(max, zeros - ones);
        }
        if(s.charAt(s.length() - 1) == '1') {
            ones++;
        }
        return max + ones; //because it's zeros at split place + allOnes - onesIn left part at split
    }
}
