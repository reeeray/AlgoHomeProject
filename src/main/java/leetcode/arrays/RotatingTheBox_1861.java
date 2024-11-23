package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.11.2024
 **/
public class RotatingTheBox_1861 {

    public static void main(String[] args) {

    }

    public static char[][] rotateTheBox(final char[][] box) {
        final int m = box.length;
        final int n = box[0].length;
        final char[][] result = new char[n][m];


        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], '.');
        }

        for (int i = 0; i < m; i++) {
            int lowestRowWithEmptyCell = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    result[lowestRowWithEmptyCell][m - i - 1] = '#';
                    lowestRowWithEmptyCell--;
                }
                if (box[i][j] == '*') {
                    result[j][m - i - 1] = '*';
                    lowestRowWithEmptyCell = j - 1;
                }
            }
        }
        return result;
    }
}
