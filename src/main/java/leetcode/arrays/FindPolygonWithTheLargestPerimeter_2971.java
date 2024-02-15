package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.02.2024
 **/
public class FindPolygonWithTheLargestPerimeter_2971 {

    public static void main(String[] args) {

    }

    //Time complexity O(NlogN) and Space O(N) or O(logN)
    public long largestPerimeter(final int[] nums) {
        Arrays.sort(nums);
        long prevSum = 0;
        long ans = -1;
        for(int num : nums) {
            if(prevSum < num) {
                ans = num + prevSum;
            }
            prevSum += num;
        }
        return ans;
    }
}
