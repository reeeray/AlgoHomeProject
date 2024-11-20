package leetcode.slidingWindow;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.11.2024
 **/
public class TakeKOfEachCharacterFromLeftAndRight_2516 {

    public static void main(String[] args) {
        takeCharacters("abc", 1);
    }

    //Space O(1) and Time O(n)
    public static int takeCharactersOpt(final String s, final int k) {
        final int[] count = new int[3];
        for(final char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for(final int c : count) {
            if(c < k) {
                return -1;
            }
        }
        final int[] windowCount = new int[3];
        int left = 0, maxWindow = 0;
        for(int right = 0; right < s.length(); right++) {
            windowCount[s.charAt(right) - 'a']++;

            while(left <= right && (count[0] - windowCount[0] < k || count[1] - windowCount[1] < k || count[2] - windowCount[2] < k) ) {
                windowCount[s.charAt(left++) - 'a']--;
            }
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return s.length() - maxWindow;
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
