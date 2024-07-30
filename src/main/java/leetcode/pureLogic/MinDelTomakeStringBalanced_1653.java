package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.07.2024
 **/
public class MinDelTomakeStringBalanced_1653 {

    public static void main(String[] args) {
        System.out.println(minimumDelitions("aababbab"));
    }

    public static int minimumDelitions(final String s) {
        final int[] fromLeft = new int[s.length()];
        final int[] fromRight = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            fromLeft[i] = s.charAt(i) == 'b' ? (i == 0 ? 1 : fromLeft[i - 1] + 1 ) : (i == 0 ? 0 : fromLeft[i - 1]);
            fromRight[s.length() - 1 - i] = s.charAt(s.length() - 1 - i) == 'a' ? (i == 0 ? 1 : fromRight[s.length() - i] + 1) : (i == 0 ? 0 : fromRight[s.length() - i]);

        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++) {
            min = Math.min(min, fromLeft[i] + fromRight[i]);
        }
        return min - 1;
    }

    //optimized DP Space O(n) and Time O(n)
    public static int minimumDeletions(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int bCount = 0;

        // dp[i]: The number of deletions required to
        // balance the substring s[0, i)
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                dp[i + 1] = dp[i];
                bCount++;
            } else {
                // Two cases: remove 'a' or keep 'a'
                dp[i + 1] = Math.min(dp[i] + 1, bCount);
            }
        }

        return dp[n];
    }

    //Optimized DP Time O(n) and Space O(1)
    public static int minimumDeletionsOpt(String s) {
        int n = s.length();
        int minDeletions = 0;
        int bCount = 0;

        // minDeletions variable represents dp[i]
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            } else {
                // Two cases: remove 'a' or keep 'a'
                minDeletions = Math.min(minDeletions + 1, bCount);
            }
        }

        return minDeletions;
    }
}
