package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.11.2025
 **/
public class GreatestSumDivisibleByThree_1262 {

    public static void main(String[] args) {

    }

    //Due to sorting Time O(nlogn) and Space O(n)
    //Greedy and Backward thinking
    public static int maxSumDivThree(final int[] nums) {
        final List<Integer>[] leftOvers = new List[3];
        leftOvers[0] = new ArrayList<>();
        leftOvers[1] = new ArrayList<>();
        leftOvers[2] = new ArrayList<>();
        for(final int num : nums) {
            leftOvers[num % 3].add(num);
        }
        Collections.sort(leftOvers[1], Collections.reverseOrder());
        Collections.sort(leftOvers[2], Collections.reverseOrder());
        final int totalSum = Arrays.stream(nums).sum();
        int toRemove = Integer.MAX_VALUE;
        if(totalSum % 3 == 0) {
            toRemove = 0;
        } else if (totalSum % 3 == 1){
            if(leftOvers[1].size() >= 1) {
                toRemove = leftOvers[1].get(leftOvers[1].size() - 1);
            }
            if(leftOvers[2].size() >= 2) {
                toRemove = Math.min(toRemove, leftOvers[2].get(leftOvers[2].size() - 2) + leftOvers[2].get(leftOvers[2].size() - 1));
            }
        } else {
            if(leftOvers[1].size() >= 2) {
                toRemove = leftOvers[1].get(leftOvers[1].size() - 2) + leftOvers[1].get(leftOvers[1].size() - 1);
            }
            if(leftOvers[2].size() >= 1) {
                toRemove = Math.min(toRemove, leftOvers[2].get(leftOvers[2].size() - 1));
            }
        }
        return totalSum - toRemove;
    }

    //DP Time O(n) and Space O(1)
    public int maxSumDivThreeOpt(int[] nums) {
        int[] f = { 0, Integer.MIN_VALUE, Integer.MIN_VALUE };
        for (int num : nums) {
            int[] g = new int[3];
            System.arraycopy(f, 0, g, 0, 3);
            for (int i = 0; i < 3; ++i) {
                g[(i + (num % 3)) % 3] = Math.max(
                        g[(i + (num % 3)) % 3],
                        f[i] + num
                );
            }
            f = g;
        }
        return f[0];
    }
}
