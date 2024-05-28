package leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.05.2024
 **/
public class GetEqualSubstringsWithinBudget_1208 {

    public static int equalSubstring(final String s, final String t, int maxCost) {
        int maxLen = 0;
        // Starting index of the current substring
        int start = 0;
        // Cost of converting the current substring in s to t
        int currCost = 0;
        for (int i = 0; i < s.length(); i++) {
            // Add the current index to the substring
            currCost += Math.abs(s.charAt(i) - t.charAt(i));

            // Remove the indices from the left end till the cost becomes less than allowed
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }
}
