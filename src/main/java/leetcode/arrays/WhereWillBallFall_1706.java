package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.11.2022
 **/
public class WhereWillBallFall_1706 {

    public static void main(String[] args) {
        final int[][] input = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
//        System.out.println(Arrays.toString(findBall(input)));

        final int[] expected = {1, -1, -1, -1, -1};

        assert Arrays.equals(expected, findBall(input)) == true;
        assert Arrays.equals(expected, findBallSpaceImproved(input)) == true;
    }

    /**
     * Space Complexity O(MxN)
     * Time complexity O(MxN)
     * @param grid
     * @return
     */
    private static int[] findBall(final int[][] grid) {
        final int cols = grid[0].length;
        final int[] res = new int[cols];
        for(int col=0; col<cols; col++) {
            res[col] = resolvePath(grid, col);
        }
        return res;
    }

    private static int resolvePath(final int[][] grid, final int start) {
        int col = start;
        final int rows = grid.length;
        final int cols = grid[0].length;

        for(int row = 0; row<grid.length; row++) {
            if(grid[row][col] == 1) {
                if(col+1 < cols && grid[row][col+1] == 1) {
                    col++;
                } else {
                    return -1;
                }
            } else {
                if(col-1 >= 0 && grid[row][col-1] == -1) {
                    col--;
                }else {
                    return -1;
                }
            }
        }

        return col;
    }

    /**
     * Space complexity O(1)
     * Time complexity(MxN)
     * @param grid
     * @return
     */
    private static int[] findBallSpaceImproved(final int[][] grid) {
        final int result[] = new int[grid[0].length];

        for (int col = 0; col < grid[0].length; col++) {
            int currentCol = col;
            for (int row = 0; row < grid.length; row++) {
                int nextColumn = currentCol + grid[row][currentCol];
                if (nextColumn < 0 ||
                        nextColumn > grid[0].length - 1 ||
                        grid[row][currentCol] != grid[row][nextColumn]) {
                    result[col] = -1;
                    break;
                }
                result[col] = nextColumn;
                currentCol = nextColumn;
            }
        }
        return result;
    }
}
