package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.05.2023
 **/
public class SolvingQuestionsWithBrainPower_2140 {

    private static long max = 0;

    public static void main(String[] args) {
//        final int[][] input = {{3,2},{4,3},{4,4},{2,5}};
        final int[][] input = {{28,1}};
        mostPoints(input);
    }

    //TLE
    private static long mostPoints(final int[][] questions) {
        dfs(questions, 0, 0);
        return max;
    }

    private static void dfs(final int[][] questions, final int index, final long points) {
        if(index >= questions.length) {
            max = Math.max(max, points);
            return;
        }
        for(int i=index; i<questions.length; i++) {
            dfs(questions, i+questions[i][1]+1, points+questions[i][0]);
        }
    }

    public long mostPointsDP(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for(int i = n - 1; i >= 0; i--){
            dp[i] = Math.max(questions[i][0] + dp[Math.min(n, i + questions[i][1] + 1)], dp[i + 1]);
        }

        return dp[0];
    }
}
