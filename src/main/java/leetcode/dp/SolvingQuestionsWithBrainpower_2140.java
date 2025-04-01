package leetcode.dp;

import patterns.creational.factory.Page;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.04.2025
 **/
public class SolvingQuestionsWithBrainpower_2140 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public static long mostPoints(final int[][] questions) {
        final long[] dp = new long[questions.length];
        for(int i=questions.length-1; i >= 0; i--) {
            final int index = i + questions[i][1] + 1;
            if(index < questions.length) {
                dp[i] = dp[index] + questions[i][0];
            } else {
                dp[i] = questions[i][0];
            }
            if(i < questions.length - 1) {
                //we might want to skip question
                dp[i] = Math.max(dp[i], dp[i + 1]);
            }
        }
        return dp[0];
    }
}
