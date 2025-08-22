package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.08.2025
 **/
public class FindTheMinAreaToCoverAllOnesI_3195 {

    public static void main(String[] args) {

    }

    //one time traversal Time O(nm) and Space O(1)
    public static int minimumArea(final int[][] grid) {
        int minRow = Integer.MAX_VALUE, maxRow = Integer.MIN_VALUE, minCol = Integer.MAX_VALUE, maxCol = Integer.MIN_VALUE;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1) {
                    minRow = minRow == Integer.MAX_VALUE ? row : col;
                    maxRow = Math.max(maxRow, row);
                    minCol = Math.min(minCol, col);
                    maxCol = Math.max(maxCol, col);
                }
            }
        }
        if(minRow == Integer.MAX_VALUE && minCol == Integer.MAX_VALUE && maxRow == Integer.MIN_VALUE && maxCol == Integer.MIN_VALUE) {
            return 0;
        }
        final int horizontalDiff = (maxCol - minCol) == 0 ? 1 : (maxCol - minCol + 1);
        final int verticalDiff = (maxRow - minRow) == 0 ? 1 : (maxRow - minRow + 1);
        return horizontalDiff * verticalDiff;
    }
}
