package leetcode.algos;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.11.2024
 **/
public class FindIfArrayCanBeSorted_3011 {

    public static void main(String[] args) {

    }

    //Bubble sort, Space O(n) and Time O(n*n)
    public static boolean canSortArray(final int[] nums) {
        final int[] copy = Arrays.copyOf(nums, nums.length);
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j < nums.length - i - 1; j++) {
                if(copy[j] <= copy[j + 1]) {
                    continue;
                } else {
                    if(Integer.bitCount(copy[j]) == Integer.bitCount(copy[j + 1])) {
                        final int to = copy[j];
                        copy[j] = copy[j + 1];
                        copy[j + 1] = to;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Checking segments will strongly optimize solution, Space O(1) and Time O(n)
    public static boolean canSortArrayOptimized(final int[] nums) {
        // Number of set bits of the elements in the current segment
        int numOfSetBits = Integer.bitCount(nums[0]);
        int maxOfSegment = nums[0];
        int minOfSegment = nums[0];

        // Initialize max of the previous segment to the smallest possible integer
        int maxOfPrevSegment = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (Integer.bitCount(nums[i]) == numOfSetBits) {
                // Element belongs to the same segment
                // Update min and max values of the segment
                maxOfSegment = Math.max(maxOfSegment, nums[i]);
                minOfSegment = Math.min(minOfSegment, nums[i]);
            } else { // Element belongs to a new segment
                // Check if the segments are arranged properly
                if (minOfSegment < maxOfPrevSegment) {
                    return false;
                }

                // Update the previous segment's max
                maxOfPrevSegment = maxOfSegment;

                // Start a new segment with the current element
                maxOfSegment = nums[i];
                minOfSegment = nums[i];
                numOfSetBits = Integer.bitCount(nums[i]);
            }
        }
        // Final check for proper segment arrangement
        if (minOfSegment < maxOfPrevSegment) {
            return false;
        }
        return true;
    }
}
