package leetcode.dp;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.01.2025
 **/
public class MinNumberOfOperationsToMoveAllBallsToEachBox_1769 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("001011")));
    }

    // Time O(3n) and Space O(3n)
    public static int[] minOperations(final String boxes) {
        final int[][] fromLeftToRight = new int[boxes.length()][2];
        fromLeftToRight[0] = new int[] {0, Integer.parseInt(boxes.substring(0, 1))};
        final int[][] fromRightToLeft = new int[boxes.length()][2];
        fromRightToLeft[boxes.length() - 1] = new int[] {0, Integer.parseInt(boxes.substring(boxes.length() - 1))};
        final int[] ans = new int[boxes.length()];
        for(int i=1; i<boxes.length(); i++) {
            fromLeftToRight[i] = new int[] {fromLeftToRight[i - 1][0] + fromLeftToRight[i - 1][1], fromLeftToRight[i - 1][1] + Integer.parseInt(boxes.substring(i, i + 1))};
        }
        for(int i=boxes.length() - 2; i >= 0; i--) {
            fromRightToLeft[i] = new int[] {fromRightToLeft[i + 1][0] + fromRightToLeft[i + 1][1], fromRightToLeft[i + 1][1] + Integer.parseInt(boxes.substring(i, i + 1))};
        }
        for(int i=0; i<boxes.length(); i++) {
            ans[i] = fromLeftToRight[i][0] + fromRightToLeft[i][0];
        }
        return ans;
    }

    //Time O(n) and Space O(1)
    public static int[] minOperationsSpaceOptimized(final String boxes) {
        final int n = boxes.length();
        final int[] answer = new int[n];

        int ballsToLeft = 0, movesToLeft = 0;
        int ballsToRight = 0, movesToRight = 0;

        // Single pass: calculate moves from both left and right
        for (int i = 0; i < n; i++) {
            // Left pass
            answer[i] += movesToLeft;
            ballsToLeft += Character.getNumericValue(boxes.charAt(i));
            movesToLeft += ballsToLeft;

            // Right pass
            int j = n - 1 - i;
            answer[j] += movesToRight;
            ballsToRight += Character.getNumericValue(boxes.charAt(j));
            movesToRight += ballsToRight;
        }

        return answer;
    }
}
