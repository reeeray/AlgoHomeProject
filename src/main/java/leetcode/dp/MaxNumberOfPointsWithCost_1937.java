package leetcode.dp;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.08.2024
 **/
public class MaxNumberOfPointsWithCost_1937 {

    private static long max = 0;

    public static void main(String[] args) {
    }

    //TLE
    public static long maxPoints(final int[][] points) {
        max = 0;
        dfs(0, -1, 0,  points);
        return max;
    }

    private static void dfs(final int row, final int prev, final long score, final int[][] matrix) {
        if(row == matrix.length) {
            max = Math.max(max, score);
            return;
        }
        for(int i=0; i<matrix[0].length; i++) {
            dfs(row +1, i, score + matrix[row][i] - prev == -1 ? 0 : Math.abs(prev - i), matrix);
        }
    }

    public long maxPointsDP(final int[][] points) {
        final int m = points.length, n = points[0].length;
        long[] previousRow = new long[n];

        // Initialize the first row
        for (int col = 0; col < n; ++col) {
            previousRow[col] = points[0][col];
        }


        // Process each row
        for (int row = 0; row < m - 1; ++row) {
            long[] leftMax = new long[n];
            long[] rightMax = new long[n];
            long[] currentRow = new long[n];

            // Calculate left-to-right maximum
            leftMax[0] = previousRow[0];
            for (int col = 1; col < n; ++col) {
                leftMax[col] = Math.max(leftMax[col - 1] - 1, previousRow[col]);
            }

            // Calculate right-to-left maximum
            rightMax[n - 1] = previousRow[n - 1];
            for (int col = n - 2; col >= 0; --col) {
                rightMax[col] = Math.max(
                        rightMax[col + 1] - 1,
                        previousRow[col]
                );
            }

            // Calculate the current row's maximum points
            for (int col = 0; col < n; ++col) {
                currentRow[col] = points[row + 1][col] +
                        Math.max(leftMax[col], rightMax[col]);
            }

            // Update previousRow for the next iteration
            previousRow = currentRow;
        }

        // Find the maximum value in the last processed row
        long maxPoints = 0;
        for (int col = 0; col < n; ++col) {
            maxPoints = Math.max(maxPoints, previousRow[col]);
        }

        return maxPoints;
    }

    public long maxPointsDPOpt(int[][] points) {
        int cols = points[0].length;
        long[] currentRow = new long[cols], previousRow = new long[cols];

        for (int[] row : points) {
            // runningMax holds the maximum value generated in the previous iteration of each loop
            long runningMax = 0;

            // Left to right pass
            for (int col = 0; col < cols; ++col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = runningMax;
            }

            runningMax = 0;
            // Right to left pass
            for (int col = cols - 1; col >= 0; --col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = Math.max(currentRow[col], runningMax) +
                        row[col];
            }

            // Update previousRow for next iteration
            previousRow = currentRow;
        }

        // Find maximum points in the last row
        long maxPoints = 0;
        for (int col = 0; col < cols; ++col) {
            maxPoints = Math.max(maxPoints, previousRow[col]);
        }

        return maxPoints;
    }
}
