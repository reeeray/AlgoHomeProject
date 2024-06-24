package leetcode.slidingWindow;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.06.2024
 **/
public class MinNumberOfKConseqBitFlips_995 {

    public static void main(String[] args) {

    }

    // Space O(n) additional boolean array, Time O(n)
    public int minKBitFlips(final int[] nums, final  int k) {
        // Keeps track of flipped states
        final boolean[] flipped = new boolean[nums.length];
        // Tracks valid flips within the past window
        int validFlipsFromPastWindow = 0;
        // Counts total flips needed
        int flipCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                // Decrease count of valid flips from the past window if needed
                if (flipped[i - k]) {
                    validFlipsFromPastWindow--;
                }
            }

            // Check if current bit needs to be flipped
            if (validFlipsFromPastWindow % 2 == nums[i]) {
                // If flipping the window extends beyond the array length, return -1
                if (i + k > nums.length) {
                    return -1;
                }
                // Increment the count of valid flips and mark current as flipped
                validFlipsFromPastWindow++;
                flipped[i] = true;
                flipCount++;
            }
        }

        return flipCount;
    }

    //Space optimized the same version. Time O(n) and Space O(1)
    public int minKBitFlipsDSpaceOpt(final int[] nums, final int k) {
        int currentFlips = 0; // Tracks the current number of flips
        int totalFlips = 0; // Tracks the total number of flips

        for (int i = 0; i < nums.length; ++i) {
            // If the window slides out of the range and the leftmost element is
            // marked as flipped (2), decrement currentFlips
            if (i >= k && nums[i - k] == -1) {
                currentFlips--;
            }

            // Check if the current bit needs to be flipped
            if ((currentFlips % 2) == nums[i]) {
                // If flipping would exceed array bounds, return -1
                if (i + k > nums.length) {
                    return -1;
                }
                // Mark the current bit as flipped
                nums[i] = -1;
                currentFlips++;
                totalFlips++;
            }
        }

        return totalFlips;
    }
}
