package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.03.2025
 **/
public class FindMissingAndRepeatedValues_2965 {

    public static void main(String[] args) {

    }

    //Time O(n^2) and Space O(n^2)
    public static int[] findMissingAndRepeatedValues(final int[][] grid) {
        final int n = grid.length;
        final int[] ans = new int[2];
        final int[] values = new int[n*n];
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(values[grid[row][col] - 1] != 0) {
                    ans[0] = grid[row][col];
                }
                values[grid[row][col] - 1] = 1;
            }
        }
        for(int i = 0; i < values.length; i++) {
            if(values[i] == 0) {
                ans[1] = i + 1;
            }
        }
        return ans;
    }

    //Mathematics Time O(n*n) and Space O(1)
    public int[] findMissingAndRepeatedValuesSpaceOpt(int[][] grid) {
        long sum = 0, sqrSum = 0;
        long n = grid.length;
        long total = n * n;

        // Calculate actual sum and squared sum from grid
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                sum += grid[row][col];
                sqrSum += (long) grid[row][col] * grid[row][col];
            }
        }

        // Calculate differences from expected sums
        // Expected sum: n(n+1)/2, Expected square sum: n(n+1)(2n+1)/6
        long sumDiff = sum - (total * (total + 1)) / 2;
        long sqrDiff = sqrSum - (total * (total + 1) * (2 * total + 1)) / 6;

        // Using math: If x is repeated and y is missing
        // sumDiff = x - y
        // sqrDiff = x² - y²
        int repeat = (int) (sqrDiff / sumDiff + sumDiff) / 2;
        int missing = (int) (sqrDiff / sumDiff - sumDiff) / 2;

        return new int[] { repeat, missing };
    }
}
