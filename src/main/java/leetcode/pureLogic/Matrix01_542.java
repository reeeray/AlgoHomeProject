package leetcode.pureLogic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.08.2023
 **/
public class Matrix01_542 {

    public static void main(String[] args) {

    }

    public int[][] updateMatrix(final int[][] mat) {
        final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        final int m = mat.length;
        final int n = mat[0].length;
        final Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : directions) {
                int r = cell[0] + dir[0], c = cell[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] > mat[cell[0]][cell[1]] + 1) {
                    queue.offer(new int[]{r, c});
                    mat[r][c] = mat[cell[0]][cell[1]] + 1;
                }
            }
        }

        return mat;
//        final int[][] answer = new int[m][n];
//        int y0,x0;
//        for(int i=0; i<m; i++) {
//            for(int j=0; j<n; j++) {
//                if(mat[i][j] == 0) {
//                  y0=i;
//                  x0=j;
//                  dfs(mat, y0, x0, 0);
//                  return mat;
//                }
//            }
////            Arrays.fill(answer[i], -1);
//        }
//        return mat;
    }

    private void dfs(final int[][] matrix, final int row, final int col, final int count) {
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
            return;
        }
        int c = 0;
        if(matrix[row][col] !=0) {
            matrix[row][col] = Math.min(matrix[row][col], count);
            c = count + 1;
        }
        dfs(matrix, row + 1, col, c);
        dfs(matrix, row - 1, col, c);
        dfs(matrix, row, col + 1, c);
        dfs(matrix, row, col - 1, c);
    }
}
