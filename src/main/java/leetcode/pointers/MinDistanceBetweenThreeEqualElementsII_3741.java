package leetcode.pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.04.2026
 **/
public class MinDistanceBetweenThreeEqualElementsII_3741 {

    public static void main(String[] args) {

    }

    public static int minimumDistance(final int[] nums) {
        final int n = nums.length;
        final int[] nextNum = new int[n];
        final Map<Integer, Integer> occurrences = new HashMap<>();
        Arrays.fill(nextNum, -1);
        for(int i = n - 1; i >= 0; i--) {
            if(occurrences.get(nums[i]) != null) {
                nextNum[i] = occurrences.get(nums[i]);
            }
            occurrences.put(nums[i], i);
        }

        int res = n + 1;
        for(int i = 0; i < n; i++) {
            final int secondPos = nextNum[i];
            if(secondPos != -1) {
                final int thirdPos = nextNum[secondPos];
                if(thirdPos != -1) {
                    res = Math.min(res, thirdPos - i);
                }
            }
        }
        return res == n + 1 ? -1 : res * 2;
    }
}
