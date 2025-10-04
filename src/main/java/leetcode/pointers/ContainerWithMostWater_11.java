package leetcode.pointers;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.10.2025
 **/
public class ContainerWithMostWater_11 {

    public static void main(String[] args) {

    }

    //Sliding window/two pointers
    //Time O(n) and Space O(1)
    public static int maxArea(final int[] height) {
        int res = 0, left = 0, right = height.length - 1;
        while(left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if(height[left] <= height[right]) {
                left++;
            } else {
                right++;
            }
        }
        return res;
    }
}
