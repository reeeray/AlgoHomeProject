package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.01.2025
 **/
public class GridGame_2017 {

    public static void main(String[] args) {
        final int[][] input = new int[][] {{2, 5, 4}, {1, 5, 1}};
        gridGame(input);
    }

    //prefix and suffix sum, Time O(n) and Space O(1)
    public long gridGameSpaceOptimized(int[][] grid) {
        // Calculate the sum of all the elements for the first row
        long firstRowSum = 0;
        for (int num : grid[0]) {
            firstRowSum += num;
        }
        long secondRowSum = 0;
        long minimumSum = Long.MAX_VALUE;
        for (int turnIndex = 0; turnIndex < grid[0].length; ++turnIndex) {
            firstRowSum -= grid[0][turnIndex];
            // Find the minimum maximum value out of firstRowSum and
            // secondRowSum.
            minimumSum = Math.min(
                    minimumSum,
                    Math.max(firstRowSum, secondRowSum)
            );
            secondRowSum += grid[1][turnIndex];
        }
        return minimumSum;
    }

    public static long gridGame(final int[][] grid) {
        final long[][] score = new long[2][grid[0].length];
        score[0][grid[0].length - 1] = grid[0][grid[0].length - 1];
        score[1][0] = grid[1][0];
        for(int i = 1; i < grid[0].length; i++) {
            score[1][i] = score[1][i - 1] + grid[1][i];
            score[0][grid[0].length - 1 - i] = score[0][grid[0].length - i] + grid[0][grid[0].length - 1 -i];
        }
        for(int i=0; i< grid[0].length - 1; i++) {
            if(score[0][i + 1] <= score[1][i]) {
                return i == 0 ? score[0][1] : Math.max(score[0][i + 1], score[1][i - 1]);
            }
        }
        return score[1][grid[0].length - 1] - grid[1][grid[0].length - 1];
    }
}
