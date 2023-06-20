package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.06.2023
 **/
public class KRadiusSubarrayAverages_2090 {

    public static void main(String[] args) {
        final int[] input = {40527,53696,10730,66491,62141,83909,78635,18560};
        System.out.println(Arrays.toString(getAverages(input, 2)));
    }

    public static int[] getAverages(final int[] nums, final int k) {
        final int[] averages = new int[nums.length];
        final int n = nums.length;
        final int mult = 2*k + 1;
        if(n < mult) {
            Arrays.fill(averages, -1);
            return averages;
        }
        long sum = 0;
        for(int i=0; i<k; i++) {
            averages[i] = -1;
            averages[n - i - 1] = -1;
            sum = sum + nums[k - i - 1] + nums[k + i + 1];
        }
        sum += nums[k];
        for(int i=k; i<n-k; i++) {
            averages[i] = (int)(sum / mult);
            if(i + k+1 <n) {
                sum = sum - nums[i - k] + nums[i + k + 1];
            }
        }
        return averages;
    }
}
