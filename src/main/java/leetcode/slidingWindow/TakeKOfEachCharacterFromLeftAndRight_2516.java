package leetcode.dfs;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.11.2024
 **/
public class TakeKOfEachCharacterFromLeftAndRight_2516 {

    public static void main(String[] args) {
        takeCharacters("abc", 1);
    }

    //TLE Time O(2^n) and Space O(n)
    public static int takeCharacters(final String s, final int k) {
        final int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        dfs(s, 0, s.length() - 1, k, ans, 0, 0, 0);
        return ans[0] == Integer.MAX_VALUE ? -1 : ans[0];
    }

    private static void dfs(final String s, final int left, final int right, final int k, final int[] ans, final int a, final int b, final int c) {
        if(a >= k && b >= k && c >= k) {
            ans[0] = Math.min(ans[0], left + (s.length() - 1 - right));
        }
        if(left <= right && left < s.length()) {
            if(s.charAt(left) == 'a') {
                dfs(s, left + 1, right, k, ans, a + 1, b, c);
            } else if (s.charAt(left) == 'b') {
                dfs(s, left + 1, right, k, ans, a, b + 1, c);
            } else {
                dfs(s, left + 1, right, k, ans, a, b, c + 1);
            }
        }
        if(left <= right && right > -1) {
            if(s.charAt(left) == 'a') {
                dfs(s, left, right - 1, k, ans, a + 1, b, c);
            } else if (s.charAt(left) == 'b') {
                dfs(s, left, right - 1, k, ans, a, b + 1, c);
            } else {
                dfs(s, left, right - 1, k, ans, a, b, c + 1);
            }
        }
    }
}
