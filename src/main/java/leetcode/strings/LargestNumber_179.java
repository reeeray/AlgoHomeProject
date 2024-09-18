package leetcode.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.09.2024
 **/
public class LargestNumber_179 {

    public static void main(String[] args) {

    }

    //Time is O(nlogn) and Space O(n + S), S space needed for sorting algorithm. basically n for merge sort in java
     public static String largestNumber(final int[] nums) {
        // Convert each integer to a string
        final String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = Integer.toString(nums[i]);
        }

        // Sort strings based on concatenated values
        Arrays.sort(numStrings, (a, b) -> (b + a).compareTo(a + b));

        // Handle the case where the largest number is zero
        if (numStrings[0].equals("0")) {
            return "0";
        }
        final StringBuilder sb = new StringBuilder();
        for(final String n : numStrings) {
            sb.append(n);
        }
        return sb.toString();
    }
}
