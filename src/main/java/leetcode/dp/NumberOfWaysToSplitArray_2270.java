package leetcode.dp;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.01.2025
 **/
public class NumberOfWaysToSplitArray_2270 {

    public static void main(String[] args) {

    }

    //Time O(2n) and Space O(n)
    public static int waysToSplitArray(final int[] nums) {
        final long[] fromLeftToRight = new long[nums.length];
        final long[] fromRightToLeft = new long[nums.length];
        fromLeftToRight[0] = nums[0];
        fromRightToLeft[nums.length - 1] = nums[nums.length - 1];
        for(int i=1; i<nums.length - 1; i++) {
            fromLeftToRight[i] = fromLeftToRight[i - 1] + nums[i];
            fromRightToLeft[nums.length - i - 1] = fromRightToLeft[nums.length - i] + nums[nums.length - i - 1];
        }
        int count = 0;
        for(int i=0; i < nums.length - 1; i++) {
            if(fromLeftToRight[i] >= fromRightToLeft[i + 1]) {
                count++;
            }
        }
        return count;
    }

    //Time O(2n) and Space O(1)
    public static int waysToSplitArraySpaceOptimized(final int[] nums) {
        // Keep track of sum of elements on left and right sides
        long leftSum = 0, rightSum = 0;

        // Initially all elements are on right side
        for (final int num : nums) {
            rightSum += num;
        }

        int count = 0;
        // Try each possible split position
        for (int i = 0; i < nums.length - 1; i++) {
            // Move current element from right to left side
            leftSum += nums[i];
            rightSum -= nums[i];

            // Check if this creates a valid split
            if (leftSum >= rightSum) {
                count++;
            }
        }

        return count;
    }
}
