package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.12.2023
 **/
public class MaxScoreAfterSplittingAString_1422 {

    public static void main(String[] args) {
        maxScore("1011011");
    }

    public static int maxScore(final String s) {
        final int[] left = new int[s.length()];
        final int[] right = new int[s.length()];
        left[0] = Character.getNumericValue(s.charAt(0)) == 0 ? 1 : 0;
        right[s.length() - 1] = Character.getNumericValue(s.charAt(s.length() - 1)) == 1 ? 1 : 0;
        for(int i=1; i<s.length(); i++) {
            left[i] = left[i -1] + (Character.getNumericValue(s.charAt(i)) == 0 ? 1 : 0);
            right[s.length() - 1 - i] = right[s.length() - i] + (Character.getNumericValue(s.charAt(s.length() - 1 - i)) == 1 ? 1 : 0);
        }
        int ans = 0;
        for(int i =1; i<s.length(); i++) {
            ans = Math.max(ans, left[i-1] + right[i]);
        }
        return ans;
    }

    //Time (2n) and Space O(1)
    public int maxScoreLinear(final String s) {
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        int ans = 0;
        int zeros = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones--;
            } else {
                zeros++;
            }

            ans = Math.max(ans, zeros + ones);
        }

        return ans;
    }
}
