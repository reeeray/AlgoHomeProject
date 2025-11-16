package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.11.2025
 **/
public class NumberOfSubstringsWithOnly1s_1513 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static int numSub(final String s) {
        final int mod = (int)1e7 + 7;
        long total = 0, subseq = 0;
        for(int i = 0; i < s.length(); i++) {
            final char c  = s.charAt(i);
            if(c == '1') {
                subseq++;
            } else {
                total += (subseq * (subseq + 1)) / 2;
                subseq = 0;
                total %= mod;
            }
        }
        total += (subseq * (subseq + 1)) / 2;
        return (int)(total % mod);
    }
}
