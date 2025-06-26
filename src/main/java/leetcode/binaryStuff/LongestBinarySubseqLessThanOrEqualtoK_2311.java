package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.06.2025
 **/
public class LongestBinarySubseqLessThanOrEqualtoK_2311 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public int longestSubsequence(final String s, final int k) {
        int sm = 0;
        int conut = 0;
        final int bitsInK = (int) (Math.log(k) / Math.log(2)) + 1;
        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(s.length() - 1 - i);
            if (ch == '1') {
                if (i < bitsInK && sm + (1 << i) <= k) {
                    sm += 1 << i;
                    conut++;
                }
            } else {
                conut++;
            }
        }
        return conut;
    }
}
