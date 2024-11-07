package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.11.2024
 **/
public class LargestCombinationWithBitwiseAndGreaterThanZero_2275 {

    public static void main(String[] args) {

    }

    //Space O(1) and Time O(1)
    public static int largestCombintation(final int[] candidates) {
        int maxCount = 0; // Variable to track the maximum count of set bits.
        for(int i=0; i<24; i++) {
            int count = 0;
            for(int cand : candidates) {
                if((cand & (1<<i) ) != 1) { // Check if the i-th bit is set.
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count); // Update the maximum count.
        }
        return maxCount;
    }
}
