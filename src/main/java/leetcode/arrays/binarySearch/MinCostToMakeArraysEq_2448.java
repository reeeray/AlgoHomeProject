package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.06.2023
 **/
public class MinCostToMakeArraysEq_2448 {

    public static void main(String[] args) {
        final int[] nums = {735103,366367,132236,133334,808160,113001,49051,735598,686615,665317,999793,426087,587000,649989,509946,743518};
        final int[] cost = {724182,447415,723725,902336,600863,287644,13836,665183,448859,917248,397790,898215,790754,320604,468575,825614};
        minCost(nums, cost);
    }

    public static long minCost(final int[] nums, final int[] cost) {
        long numerator = 0;
        int denominator = 0;
        for(int i=0; i<nums.length; i++){
            numerator += (long)(nums[i] * cost[i]);
            denominator += cost[i];
        }
        long average = numerator/denominator;
        long minCost = 0;
        for(int i=0; i<nums.length; i++) {
            minCost += Math.abs(nums[i] - average) * cost[i];
        }
        return minCost;
    }
}
