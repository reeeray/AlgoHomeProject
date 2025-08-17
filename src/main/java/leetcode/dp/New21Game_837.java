package leetcode.dp;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.05.2023
 **/
public class New21Game_837 {

    public static void main(String[] args) {

    }

    //we don't need to calculate sum of previous probabilities each time, we can keep it as a sliding window
    //Time O(n) and Space O(n)
    public static double new21gameSlidingWindow(final int n, final int k, final int maxPts) {
        final double[] dp = new double[n + 1];
        dp[0] = 1;
        double sum = k > 0 ? 1 : 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = sum * (1.0 / maxPts);
            if(i < k) {
                sum += dp[i];
            }
            if(i - maxPts >= 0 && i - maxPts < k) {
                sum -= dp[i - maxPts];
            }
        }
        double res = 0;
        for(int i = k; i <= n; i++) {
            res += dp[i];
        }
        return res;
    }
    //it will be TLE but logic is correct. Time complexity is O(n * maxPts)
    public static double new21game(final int n, final int k, final int maxPts) {
        final double[] dp = new double[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= maxPts; j++) {
                if(i - j >= 0 && i - j < k) {
                    dp[i] += dp[i - j] * (1 / maxPts);
                }
            }
        }
        double res = 0;
        for(int i = k; i <= n; i++) {
            res += dp[i];
        }
        return res;
    }
    /**
     * Alice plays the following game, loosely based on the card game "21".
     *
     * Alice starts with 0 points and draws numbers while she has less than k points.
     * During each draw, she gains an integer number of points randomly from the range [1, maxPts], where maxPts is an integer.
     * Each draw is independent and the outcomes have equal probabilities.
     *
     * Alice stops drawing numbers when she gets k or more points.
     *
     * Return the probability that Alice has n or fewer points.
     *
     * Answers within 10-5 of the actual answer are considered accepted.
     * @param n
     * @param k
     * @param maxPts
     * @return
     */
    public static double new21gameTLE(final int n, final int k, final int maxPts) {
        //corener cases
        if(k == 0 || n >= k - 1 + maxPts) {
            return 1.0;
        }

        final double[] dp = new double[n+1];
        dp[0] = 1.0;
        final int maxPoint = k-1+maxPts; //including unreachable

        for(int i=1; i<maxPoint; i++) {
            for(int j=1; j<maxPoint; j++) {
                if(i - j >= 0 && i - j < k) {
                    dp[i] = dp[i - j] / maxPts;
                }
            }
        }

        double resProbability = 0.0;
        for(int i=k; i<=n; i++) {
            resProbability += dp[i];
        }
        return resProbability;
    }

    /**
     * imroved version with usage of sliding window
     * @param n
     * @param k
     * @param maxPts
     * @return
     */
    public static double new21gameEfficient(final int n, final int k, final int maxPts) {
        //corener cases
        if(k == 0 || n >= k-1+maxPts) return 1.0;

        //dp[i] is the probability of reaching point i
        final double[] dp = new double[n + 1];
        dp[0] = 1.0; // becasue you start in 0.0

        double resProbability = 0.0;
        double windowSum = 1.0; //We have to use sliding window otherwise it will be TLE

        for(int i=1; i<=n; i++) {
            dp[i] = windowSum / maxPts;

            if(i < k) {
                windowSum += dp[i];
            } else {
                resProbability +=  dp[i];
            }

            if(i >= maxPts) {
                windowSum -= dp[i - maxPts];
            }
        }
        return resProbability;
    }
}
