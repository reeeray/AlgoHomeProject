package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.03.2025
 **/
public class PutMarbelsInBag_2551 {

    public static void main(String[] args) {

    }

    public static long putMarbles(final int[] weights, final int k) {
        final int n = weights.length;
        // We collect and sort the value of all n - 1 pairs.
        final int[] pairWeights = new int[n - 1];
        for(int i = 0; i < n - 1; i++) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }
        // We will sort only the first (n - 1) elements of the array.
        Arrays.sort(pairWeights, 0, n -1);
        // Get the difference between the largest k - 1 values and the
        // smallest k - 1 values.
        long answer = 0;
        for(int i = 0; i < k - 1; i++) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }
        return answer;
    }
}
