package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.11.2025
 **/
public class IncrementSubmatricesByOne_2536 {

    public static void main(String[] args) {

    }

    public static int[][] rangeAddQueries(final int n, final int[][] queries) {
        final int[][] res = new int[n][n];
        for(int i = 0; i < n; i++) {
            res[i] = new int[n];
        }
        for(final int[] query : queries) {
            for(int i = query[0]; i <= query[2]; i++) {
                res[i][query[1]]++;
                if(query[3] < n) {
                    res[i][query[3]]--;
                }
            }
        }
        for(int col = 1; col < n; col++) {
            for(int row = 0; row < n; row++) {
                res[row][col] += res[row][col - 1];
            }
        }
        return res;
    }

    //Time O(n^2) and Space O(n^2)
    public int[][] rangeAddQueriesOpt(int n, int[][] queries) {
        final int[][] diff = new int[n + 1][n + 1];
        for (final int[] q : queries) {
            int row1 = q[0];
            int col1 = q[1];
            int row2 = q[2];
            int col2 = q[3];
            diff[row1][col1] += 1;
            diff[row2 + 1][col1] -= 1;
            diff[row1][col2 + 1] -= 1;
            diff[row2 + 1][col2 + 1] += 1;
        }

        final int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = (i == 0) ? 0 : mat[i - 1][j];
                int x2 = (j == 0) ? 0 : mat[i][j - 1];
                int x3 = (i == 0 || j == 0) ? 0 : mat[i - 1][j - 1];
                mat[i][j] = diff[i][j] + x1 + x2 - x3;
            }
        }
        return mat;
    }
}
