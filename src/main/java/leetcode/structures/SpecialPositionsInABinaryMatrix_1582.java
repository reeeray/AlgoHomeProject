package leetcode.structures;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.12.2023
 **/
public class SpecialPositionsInABinaryMatrix_1582 {

    public static void main(String[] args) {
        final int[][] input = new int[][] {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(numSpecial(input));
    }

    public static int numSpecial(final int[][] mat) {
        int count = 0;
        for(int r = 0; r < mat.length; r++) {
            for(int c = 0; c < mat[0].length; c++) {
                if(mat[r][c] == 1) {
                    count += check(r, c, mat);
                }
            }
        }
        return count;
    }

    //Space O(1) but Time O(m*n*(m+n))
    private static int check(final int row, final int column, final int[][] mat) {
        int n = 0;
        for(int i=0; i < mat.length; i++) {
            if(mat[row][i] == 1) {
                n++;
            }
            if(n > 1) {
                return 0;
            }
        }

        for(int i=0; i < mat[0].length; i++) {
            if(i != row && mat[i][column] == 1) {
                n++;
            }
            if(n > 1) {
                return 0;
            }
        }
        return 1;
    }

    //Space O(m+n) and Time O(m*n)
    public int numSpecialTimeOptim(int[][] mat) {
        final int m = mat.length;
        final int n = mat[0].length;
        final int[] rowCount = new int[m];
        final int[] colCount = new int[n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }

        int ans = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1) {
                    if (rowCount[row] == 1 && colCount[col] == 1) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
