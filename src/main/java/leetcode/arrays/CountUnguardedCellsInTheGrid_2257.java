package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.11.2024
 **/
public class CountUnguardedCellsInTheGrid_2257 {

    public static void main(String[] args) {
        final int[][] guards = new int[][] {{0, 0}, {1, 1}, {2, 3}};
        final int [][] walls = new int[][] {{0, 1}, {2, 2}, {1, 4}};
        countUnguarded(4, 6, guards, walls);
    }
    private static final int UNGUARDED = 0;
    private static final int GUARDED = 1;
    private static final int GUARD = 2;
    private static final int WALL = 3;

    public int countUnguardedOpt(int m, int n, int[][] guards, int[][] walls) {
        // Create and initialize grid
        int[][] grid = new int[m][n];

        // Mark guards' positions
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }

        // Mark walls' positions
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 3;
        }

        // Horizontal passes
        for (int row = 0; row < m; row++) {
            // Left to right pass
            boolean isGuardLineActive = grid[row][0] == 2;
            for (int col = 1; col < n; col++) {
                isGuardLineActive = updateCellVisibility(
                        grid,
                        row,
                        col,
                        isGuardLineActive
                );
            }

            // Right to left pass
            isGuardLineActive = grid[row][n - 1] == 2;
            for (int col = n - 2; col >= 0; col--) {
                isGuardLineActive = updateCellVisibility(
                        grid,
                        row,
                        col,
                        isGuardLineActive
                );
            }
        }

        // Vertical passes
        for (int col = 0; col < n; col++) {
            // Top to bottom pass
            boolean isGuardLineActive = grid[0][col] == 2;
            for (int row = 1; row < m; row++) {
                isGuardLineActive = updateCellVisibility(
                        grid,
                        row,
                        col,
                        isGuardLineActive
                );
            }

            // Bottom to top pass
            isGuardLineActive = grid[m - 1][col] == 2;
            for (int row = m - 2; row >= 0; row--) {
                isGuardLineActive = updateCellVisibility(
                        grid,
                        row,
                        col,
                        isGuardLineActive
                );
            }
        }

        // Count unguarded cells
        int count = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    // Helper method to update cell visibility
    private boolean updateCellVisibility(
            int[][] grid,
            int row,
            int col,
            boolean isGuardLineActive
    ) {
        // If current cell is a guard, reactivate the guard line
        if (grid[row][col] == 2) {
            return true;
        }

        // If current cell is a wall, deactivate the guard line
        if (grid[row][col] == 3) {
            return false;
        }

        // If guard line is active, mark cell as guarded
        if (isGuardLineActive) {
            grid[row][col] = 1;
        }

        return isGuardLineActive;
    }

    //TLE
    public static int countUnguarded(final int m, final int n, final int[][] guards, final int[][] walls) {
        int ans = m * n;
        final int[][] battle = new int[m][n];
        final int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] wall : walls) {
            battle[wall[0]][wall[1]] = -2;
            ans--;
        }

        for(final int[] guard : guards) {
            if(battle[guard[0]][guard[1]] > -1) {
                ans--;
            }
            battle[guard[0]][guard[1]] = -2;
            for(final int[] direction : directions) {
                int x = guard[0] + direction[0];
                int y = guard[1] + direction[1];
                while(x >= 0 && x < m && y >= 0 && y < n) {
                    if(battle[x][y] == -2) {
                        break;
                    }
                    if(battle[x][y] != -1) {
                        battle[x][y] = -1;
                        ans--;
                    }
                    x += direction[0];
                    y += direction[1];
                }
            }
        }
        return ans;
    }
}
