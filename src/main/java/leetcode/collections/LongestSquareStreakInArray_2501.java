package leetcode.collections;

import leetcode.structures.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.10.2024
 **/
public class LongestSquareStreakInArray_2501 {

    public static void main(String[] args) {

    }

    //Time O(2n) and Space O(n)
    public static int longestSquareStreak(final int[] nums) {
        final Set<Integer> unique = new HashSet<>();
        int longestStreak = 0;
        for(final int num : nums) {
            unique.add(num);
        }
        for(final int n : nums) {
            long curr = n;
            int currStreak = 0;
            while(unique.contains((int) curr)) {
                currStreak++;
                if (curr * curr > 1e5) break;
                curr *= curr;
            }
            longestStreak = Math.max(longestStreak, currStreak);
        }

        return longestStreak < 2 ? -1 : longestStreak;
    }
}
