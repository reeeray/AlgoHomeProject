package leetcode.pureLogic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.11.2023
 **/
public class CountNicePairsInAnArray_1814 {

    public static void main(String[] args) {
        final int[] input = new int[] {42, 11, 1, 97};
        countNicePairs(input);
    }

    public static int countNicePairs(final int[] nums) {
        final int MOD = 1_000_000_007;
        final Map<Integer, Integer> permutations = new HashMap<>();
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            final int val = nums[i] - Integer.valueOf(new StringBuilder("" + nums[i]).reverse().toString());
            //final int val = nums[i] - rev(nums[i]);
            count = (count + permutations.getOrDefault(val, 0)) % MOD;
            permutations.put(val, permutations.getOrDefault(val, 0) + 1);
        }
        return count;
    }

    private static int rev(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }

        return result;
    }

    private static int calcCombinations(final int n) {
        return factorail(n) / (factorail(n - 2) * 2);
    }

    private static int factorail(final int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorail(n - 1);
    }
}
