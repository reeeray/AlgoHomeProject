package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.08.2024
 **/
public class SpiralMatrix3_885 {

    public static void main(String[] args) {

    }

    //Time O(max(row, col)^2) and Space O(row*col)
    public static int[][] spiralMatrixIII(final int rows, final int cols, final int rStart, final int cStart) {
        final int n = rows * cols;
        final int[][] ans = new int[n][];
        int left = cStart;
        int right = cStart;
        int top = rStart;
        int bottom = rStart;
        int row = rStart;
        int col = cStart;
        int dir = 0;
        final int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int idx = 0;
        while(idx < n) {
            if(row >= 0 && row < rows && col < cols && col >= 0) {
                ans[idx++] = new int[]{row, col};
            }
            if(dir == 0 && col <= right) {
                row += directions[dir][0];
                col += directions[dir][1];
            } else if (dir == 0){
                right = col;
                dir = 1;
                row += directions[dir][0];
                col += directions[dir][1];
                continue;
            }

            if(dir == 1 && row <= bottom) {
                row += directions[dir][0];
                col += directions[dir][1];
            } else if (dir == 1) {
                bottom = row;
                dir = 2;
                row += directions[dir][0];
                col += directions[dir][1];
                continue;
            }

            if(dir == 2 && col >= left) {
                row += directions[dir][0];
                col += directions[dir][1];
            } else if (dir == 2) {
                left = col;
                dir = 3;
                row += directions[dir][0];
                col += directions[dir][1];
                continue;
            }

            if(dir == 3 && row >= top) {
                row += directions[dir][0];
                col += directions[dir][1];
            } else if (dir == 3) {
                top = row;
                dir = 0;
                row += directions[dir][0];
                col += directions[dir][1];
                continue;
            }


        }
        return ans;
    }
}
