package leetcode.dp;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.01.2024
 **/
public class OutOfBoundaryPath_576 {

    public static void main(String[] args) {

    }
    //Space O(mn) and Time O(mn*maxMove)
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int mod = 1000000000 + 7;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int count = 0;
        for (int moves = 1; moves <= maxMove; moves++) {
            final int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1) count = (count + dp[i][j]) % mod;
                    if (j == n - 1) count = (count + dp[i][j]) % mod;
                    if (i == 0) count = (count + dp[i][j]) % mod;
                    if (j == 0) count = (count + dp[i][j]) % mod;
                    temp[i][j] = (
                            ((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % mod +
                                    ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % mod
                    ) % mod;
                }
            }
            dp = temp;
        }
        return count;
    }
}
