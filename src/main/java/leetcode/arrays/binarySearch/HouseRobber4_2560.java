package leetcode.arrays.binarySearch;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.03.2025
 **/
public class HouseRobber4_2560 {

    public static void main(String[] args) {

    }

    //Time O(nlogm) and Space O(1), where n is size of nums and m size of range of elemnts n nums
    public static int minCapability(final int[] nums, final int k) {
        // Store the maximum nums value in maxReward.
        int minReward = 1;
        int maxReward = Arrays.stream(nums).max().getAsInt();
        int totalHouses = nums.length;

        // Use binary search to find the minimum reward possible.
        while (minReward < maxReward) {
            int midReward = (minReward + maxReward) / 2;
            int possibleThefts = 0;

            for (int index = 0; index < totalHouses; ++index) {
                if (nums[index] <= midReward) {
                    possibleThefts += 1;
                    index++; // Skip the next house to maintain the
                    // non-adjacent condition
                }
            }

            if (possibleThefts >= k) maxReward = midReward;
            else minReward = midReward + 1;
        }

        return minReward;
    }
}
