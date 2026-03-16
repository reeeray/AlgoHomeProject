package leetcode.pureLogic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.03.2026
 **/
public class GetBiggestThreeRhombusSumsInAGrid_1878 {

    public static void main(String[] args) {

    }

    public static int[] getBiggestThree(final int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;
        final int[][] sumDiagToTopLeft = new int[rows + 1][cols + 2];
        final int[][] sumDiagToTopRight = new int[rows + 1][cols + 2];

        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                sumDiagToTopLeft[i][j] = sumDiagToTopLeft[i - 1][j - 1] + grid[i - 1][j - 1];
                sumDiagToTopRight[i][j] = sumDiagToTopRight[i - 1][j + 1] + grid[i - 1][j - 1];
            }
        }

        final Result res = new Result();
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                res.add(grid[row][col]);
                for (int k = row + 2; k < rows; k += 2) {
                    int ux = row;
                    int uy = col;
                    int dx = k;
                    int dy = col;
                    int lx = (row + k) / 2;
                    int ly = col - (k - row) / 2;
                    int rx = (row + k) / 2;
                    int ry = col + (k - row) / 2;
                    if (ly < 0 || ry >= cols) {
                        break;
                    }
                    int sum =
                            (sumDiagToTopRight[lx + 1][ly + 1] - sumDiagToTopRight[ux][uy + 2]) +
                                    (sumDiagToTopLeft[rx + 1][ry + 1] - sumDiagToTopLeft[ux][uy]) +
                                    (sumDiagToTopLeft[dx + 1][dy + 1] - sumDiagToTopLeft[lx][ly]) +
                                    (sumDiagToTopRight[dx + 1][dy + 1] - sumDiagToTopRight[rx][ry + 2]) -
                                    (grid[ux][uy] +
                                            grid[dx][dy] +
                                            grid[lx][ly] +
                                            grid[rx][ry]);
                    res.add(sum);
                }
            }
        }
        return Arrays.stream(res.res).distinct().filter(val -> val != 0).toArray();
    }

    private static class Result {
        final int[] res;

        public Result() {
            res = new int[3];
        }

        public void add(final int val) {
            if(val <= res[2]  || val == res[1] || val == res[0]) return;
            if(val < res[1]) {
                res[2] = val;
                return;
            }
            if(val < res[0]) {
                res[2] = res[1];
                res[1] = val;
                return;
            }
            res[2] = res[1];
            res[1] = res[0];
            res[0] = val;
        }
    }
}
