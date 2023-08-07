package leetcode.search;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.08.2023
 **/
public class Search2DMatrix_74 {

    public static void main(String[] args) {
        final int[][] input = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(new int[][] {{1}, {3}}, 3));
    }

    public static boolean searchMatrix(final int[][] matrix, final int target) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int left = 0, right = m*n - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            final int i = mid / n;
            final int j = mid % n;
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}
