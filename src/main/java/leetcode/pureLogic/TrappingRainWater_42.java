package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.04.2024
 **/
public class TrappingRainWater_42 {

    public static void main(String[] args) {

    }

    //Space O(2n) and Time(3n)
    public static int trap(final int[] height) {
        final int n = height.length;
        if(n == 0) {
            return 0;
        }

        final int[] left = new int[n];
        left[0] = height[0];
        final int[] right = new int[n];
        right[n-1] = height[n-1];
        for(int i=1; i<n; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        for(int i=n-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        int ans = 0;
        for(int i=1; i<n-1; i++) {
            ans += Math.max(left[i], right[i]) - height[i];
        }
        return ans;
    }
}
