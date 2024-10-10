package leetcode.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.10.2024
 **/
public class MaxWidthRamp_962 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public static int maxWidthRampOpt(int[] nums) {
        final int n = nums.length;
        final Stack<Integer> indicesStack = new Stack<>();

        // Fill the stack with indices in increasing order of their values
        for (int i = 0; i < n; i++) {
            if (indicesStack.isEmpty() || nums[indicesStack.peek()] > nums[i]) {
                indicesStack.push(i);
            }
        }

        int maxWidth = 0;

        // Traverse the array from the end to the start
        for (int j = n - 1; j >= 0; j--) {
            while (
                    !indicesStack.isEmpty() && nums[indicesStack.peek()] <= nums[j]
            ) {
                maxWidth = Math.max(maxWidth, j - indicesStack.peek());
                // Pop the index since it's already processed
                indicesStack.pop();
            }
        }
        return maxWidth;
    }

    public static int maxWidthRamp(final int[] nums) {
        final Integer[] indexes = new Integer[nums.length];
        for(int i=0; i<nums.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (a, b) -> nums[a] != nums[b] ? nums[a] - nums[b] : a - b);
        int maxWidth = 0;
        int minIndex = nums.length;
        for(int i : indexes) {
            maxWidth = Math.max(maxWidth, i - minIndex);
            minIndex = Math.min(minIndex, i);
        }
        return maxWidth;
    }
}
