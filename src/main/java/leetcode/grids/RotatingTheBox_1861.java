package leetcode.grids;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.05.2026
 **/
public class RotatingTheBox_1861 {

    public static void main(String[] args) {
        rotateTheBox(new char[][] {{'#','#','*','.','*','.'},{'#','#','#','*','.','.'},{'#','#','#','.','#','.'}});
    }

    public static char[][] rotateTheBox(final char[][] boxGrid) {
        final int rows = boxGrid.length;
        final int cols = boxGrid[0].length;
        for(int row = 0; row < rows; row++) {
            int countStones = 0;
            int bottomIndex = cols - 1;
            int currIndex = bottomIndex;
            while(currIndex >= 0) {
                if(boxGrid[row][currIndex] == '.') {
                } else if (boxGrid[row][currIndex] == '#') {
                    countStones++;
                } else {
                    for(int i = bottomIndex; i > currIndex; i--) {
                        boxGrid[row][i] = countStones-- > 0 ? '#' :'.';
                    }
                    countStones = 0;
                    bottomIndex = currIndex - 1;
                }
                currIndex--;
            }
            if(countStones != 0) {
                for(int i = bottomIndex; i > currIndex; i--) {
                    boxGrid[row][i] = countStones-- > 0 ? '#' :'.';
                }
            }
        }

        final char[][] res = new char[cols][rows];
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                res[col][rows - 1 - row] = boxGrid[row][col];
            }
        }
        return res;
    }

    //Time O(mn) and Space O(mn)
    public char[][] rotateTheBoxOptimizaed(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];

        // Create the transpose of the input grid in `result`
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = box[j][i];
            }
        }

        // Reverse each row in the transpose grid to complete the 90° rotation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                char temp = result[i][j];
                result[i][j] = result[i][m - 1 - j];
                result[i][m - 1 - j] = temp;
            }
        }

        // Apply gravity to let stones fall to the lowest possible empty cell in each column
        for (int j = 0; j < m; j++) {
            int lowestRowWithEmptyCell = n - 1;
            // Process each cell in column `j` from bottom to top
            for (int i = n - 1; i >= 0; i--) {
                // Found a stone - let it fall to the lowest empty cell
                if (result[i][j] == '#') {
                    result[i][j] = '.';
                    result[lowestRowWithEmptyCell][j] = '#';
                    lowestRowWithEmptyCell--;
                }
                // Found an obstacle - reset `lowestRowWithEmptyCell` to the row directly above it
                if (result[i][j] == '*') {
                    lowestRowWithEmptyCell = i - 1;
                }
            }
        }
        return result;
    }

    //Time O(mn) and Space O(mn)
    public char[][] rotateTheBoxCombinationRotationAndGravity(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];

        // Initialize the result grid with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = '.';
            }
        }

        // Apply gravity to let stones fall to the lowest possible empty cell in each column
        for (int i = 0; i < m; i++) {
            int lowestRowWithEmptyCell = n - 1;
            // Process each cell in row `i` in reversed order
            for (int j = n - 1; j >= 0; j--) {
                // Found a stone - let it fall to the lowest empty cell
                if (box[i][j] == '#') {
                    // Place it in the correct position in the rotated grid
                    result[lowestRowWithEmptyCell][m - i - 1] = '#';
                    lowestRowWithEmptyCell--;
                }
                // Found an obstacle - reset `lowestRowWithEmptyCell` to the row directly above it
                if (box[i][j] == '*') {
                    // Place the obstacle in the correct position in the rotated grid
                    result[j][m - i - 1] = '*';
                    lowestRowWithEmptyCell = j - 1;
                }
            }
        }
        return result;
    }
}
