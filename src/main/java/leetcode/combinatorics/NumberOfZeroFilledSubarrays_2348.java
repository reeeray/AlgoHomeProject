package leetcode.combinatorics;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.08.2025
 **/
public class NumberOfZeroFilledSubarrays_2348 {

    public static void main(String[] args) {
        zeroFilledSubarray(new int[]{0,1,0,0,1,0,0,0});
    }

    //Time O(n) and Space O(1) but there is no need to calculate arithmetic progression
    public static long zeroFilledSubarrayOpt(final int[] nums) {
        long res = 0;
        int streak = 0;
        for(final int num : nums) {
            streak = num == 0 ? streak + 1 : 0;
            res += streak;
        }
        return res;
    }

    //Time O(n) Space O(1) but it's math operations ther involved
    public static long zeroFilledSubarray(final int[] nums) {
        long res = 0;
        int windowStart = -1;
        int windowEnd = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && windowStart == -1) {
                windowStart = i;
            } else if(nums[i] == 0 && windowStart != -1) {
                windowEnd = i;
            }else if(windowEnd != -1 || windowStart != -1) {
                if(windowEnd == -1) {
                    res += 1;
                }else {
                    res += (long)(windowEnd - windowStart + 1) * (windowEnd - windowStart + 2) / 2;
                }
                windowStart = -1;
                windowEnd = -1;
            }
        }
        if(windowEnd != -1 || windowStart != -1) {
            if(windowEnd == -1) {
                res += 1;
            }else {
                res += (long)(windowEnd - windowStart + 1) * (windowEnd - windowStart + 2) / 2;
            }
        }
        return res;
    }
}
