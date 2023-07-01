package leetcode.dfs;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.07.2023
 **/
public class FairDistribOfCookies_2305 {

    public static void main(String[] args) {

    }

    /**
     * Time complexity O(k^n) | Space complexity : O(k + n)
     * @param cookies
     * @param k
     * @return
     */
    public static int distributeCookies(final int[] cookies, final int k) {
        final int[] children = new int[k];
        return dfs(0, cookies, children, k);
    }

    private static int dfs(final int index, final int[] cookies, final int[] children, int withoutCookies) {
        // If there are not enough cookies remaining, return Integer.MAX_VALUE
        // as it leads to an invalid distribution.
        if(cookies.length - index < withoutCookies) {
            return Integer.MAX_VALUE;
        }

        // After distributing all cookies, return the unfairness of this
        // distribution.
        if(index == cookies.length) {
            int max = Integer.MIN_VALUE;
            for(final int c : children) {
                max = Math.max(max, c);
            }
            return max;
        }
        // Try to distribute the i-th cookie to each child, and update answer
        // as the minimum unfairness in these distributions.
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<children.length; i++) {
            withoutCookies -= children[i] == 0 ? 1 : 0;
            children[i] += cookies[index];

            // Recursively distribute the next cookie.
            ans = Math.min(ans, dfs(index + 1, cookies, children, withoutCookies));

            //backtracking
            children[i] -= cookies[index];
            withoutCookies += children[i] == 0 ? 1 : 0;

        }
        return ans;
    }
}
