package leetcode.pointers;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.10.2025
 **/
public class AdjacentIncreasingSubarraysDetectionII_3350 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static int maxIncreasingSubarrays(final List<Integer> nums) {
        int leftCounter = 0, rightCounter = 1, res = 0;
        for(int i = 1; i < nums.size(); i++) {
            if(nums.get(i) > nums.get(i - 1)) {
                rightCounter++;
            } else {
                leftCounter = rightCounter;
                rightCounter = 1;
            }
            res = Math.max(res, Math.min(leftCounter, rightCounter));
            res = Math.max(res, rightCounter / 2);
        }
        return res;
    }
}
