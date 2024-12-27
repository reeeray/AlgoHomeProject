package leetcode.algos;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.12.2024
 **/
public class BestSightseeingPair_1014 {

    public static void main(String[] args) {
        final int[] input = new int[]{8, 1, 5, 2, 6};
        System.out.println(maxScoreSightseeingPair(input));
    }

    //Time O(n) and Space O(n)
    public static int maxScoreSightseeingPair(final int[] values) {
        final int[] left = new int[values.length];
        left[0] = values[0];
        int maxScore = 0;
        for(int i=1; i<values.length; i++) {
            final int rightScore = values[i] - i;
            maxScore = Math.max(maxScore, left[i - 1] + rightScore);
            left[i] = Math.max(left[i - 1], values[i] + i);
        }
        return maxScore;
    }

    //Equal to previous one but space optimized because we don't need to keep track of an array, we just keep updating maxLeftValue
    public static int maxScoreSightseeingPairSpaceOpt(final int[] values) {
        int leftMaxScore = values[0];
        int maxScore = 0;
        for(int i=1; i<values.length; i++) {
            final int currScore = leftMaxScore + values[i] - i;
            maxScore = currScore > maxScore ? currScore : maxScore;
            final int left = values[i] + i;
            leftMaxScore = left > leftMaxScore ? left : leftMaxScore;
        }
        return maxScore;
    }
}
