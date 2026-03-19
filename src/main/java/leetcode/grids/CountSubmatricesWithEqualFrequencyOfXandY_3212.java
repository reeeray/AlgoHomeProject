package leetcode.grids;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.03.2026
 **/
public class CountSubmatricesWithEqualFrequencyOfXandY_3212 {

    public static void main(String[] args) {
        numberOfSubmatrices(new char[][] {{'X','Y','.'},{'Y','.','.'}});
    }

    public static int numberOfSubmatrices(final char[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;
        final int[][] dpX = new int[rows][cols];
        final int[][] dpY = new int[rows][cols];
        int res = 0;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                final int xCount = (row > 0 ? dpX[row - 1][col] : 0) + (col > 0 ? dpX[row][col - 1] : 0) - (row > 0 && col > 0 ? dpX[row - 1][col - 1] : 0) + (grid[row][col] == 'X' ? 1 : 0);
                final int yCount = (row > 0 ? dpY[row - 1][col] : 0) + (col > 0 ? dpY[row][col - 1] : 0) - (row > 0 && col > 0 ? dpY[row - 1][col - 1] : 0) + (grid[row][col] == 'Y' ? 1 : 0);
                dpX[row][col] = xCount;
                dpY[row][col] = yCount;
                if(xCount != 0 && xCount == yCount) res++;
            }
        }
        return res;
    }

    //with one array but 3D : Time O(mn) and Space O(mn)
    public int numberOfSubmatricesPrefixSum(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        int[][][] sum = new int[n + 1][m + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'X') {
                    sum[i + 1][j + 1][0] =
                            sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0] + 1;
                    sum[i + 1][j + 1][1] = 1;
                } else if (grid[i][j] == 'Y') {
                    sum[i + 1][j + 1][0] =
                            sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0] - 1;
                    sum[i + 1][j + 1][1] = sum[i + 1][j][1] | sum[i][j + 1][1];
                } else {
                    sum[i + 1][j + 1][0] =
                            sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0];
                    sum[i + 1][j + 1][1] = sum[i + 1][j][1] | sum[i][j + 1][1];
                }
                ans += (sum[i + 1][j + 1][0] == 0 && sum[i + 1][j + 1][1] == 1)
                        ? 1
                        : 0;
            }
        }
        return ans;
    }
}
