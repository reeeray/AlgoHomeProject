package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.05.2024
 **/
public class SpecialArrayWithXElementsGreaterThanOrEqualX_1608 {

    public static void main(String[] args) {
        specialArray(new int[] {0, 4, 3, 0, 4});
    }

    public static int specialArray(final int[] nums) {
        int x = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(x <= nums[i] && (i == 0 || nums[i-1] < x)) {
                return x;
            }
            x--;
        }
        return -1;

    }

    public int specialArrayOptimized(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+1];

        for(int num: nums){
            if(num >= n) arr[n]++;
            else arr[num]++;
        }

        int ans = 0;
        for(int i = n; i > 0; i--){
            ans += arr[i];
            if(ans == i) return i;
        }

        return -1;
    }
}
