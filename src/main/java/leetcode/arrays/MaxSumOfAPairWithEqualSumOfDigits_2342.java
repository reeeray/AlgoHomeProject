package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.02.2025
 **/
public class MaxSumOfAPairWithEqualSumOfDigits_2342 {

    public static void main(String[] args) {
        maxSum(new int[] {18,43,36,13,7});
    }

    public static int maxSum(final int[] nums) {
        final Map<Integer, int[]> digitsSum = new HashMap<>();
        for(final int num : nums) {
            int n = num;
            int digitsS = 0;
            while (n != 0) {
                digitsS += n % 10;
                n /= 10;
            }
            digitsSum.putIfAbsent(digitsS, new int[]{-1, -1});
            final int[] vals = digitsSum.get(digitsS);
            if(vals[0] == - 1) {
                vals[0] = num;
            } else if (vals[1] == -1) {
                vals[1] = num;
            } else {
                final int min = Math.min(vals[0], vals[1]);
                final int second = Math.max(num, min);
                if(vals[0] == min) {
                    vals[0] = second;
                } else {
                    vals[1] = second;
                }
            }
        }
        int ans = -1;
        for(final int[] vals : digitsSum.values()) {
            if(vals[0] >= 0 && vals[1] >= 0) {
                ans = Math.max(ans, vals[0] + vals[1]);
            }
        }
        return ans;
    }

    //Time O(lognm) and Space O(logm) where n - the size of nums and m is the number of digits in max number in nums
    public int maximumSum(int[] nums) {
        int result = -1;
        // Array to map digit sums to the largest element with that sum
        // (82 to cover all possible sums from 0 to 81)
        int[] digitMapping = new int[82];

        for (int element : nums) {
            int digitSum = 0;
            // Calculating digit sum
            for (int currValue = element; currValue != 0; currValue /= 10) {
                int currDigit = currValue % 10;
                digitSum += currDigit;
            }

            // Check if there is already an element with the same digit sum
            if (digitMapping[digitSum] > 0) {
                // Update the result if the sum of the current and mapped element is greater
                result = Math.max(result, digitMapping[digitSum] + element);
            }

            // Update the mapping to store the larger of the current or previous element for this digit sum
            digitMapping[digitSum] = Math.max(digitMapping[digitSum], element);
        }

        return result;
    }
}
