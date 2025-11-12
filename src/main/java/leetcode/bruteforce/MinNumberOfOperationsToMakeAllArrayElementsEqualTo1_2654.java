package leetcode.bruteforce;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.11.2025
 **/
public class MinNumberOfOperationsToMakeAllArrayElementsEqualTo1_2654 {

    public static void main(String[] args) {

    }

    public static int minOperations(final int[] nums) {
        int ones = 0, commonGCD = 0;
        for(final int num : nums) {
            if(num == 1) ones++;
            commonGCD = gcd(commonGCD, num);
        }

        if(ones > 0) return nums.length - ones;
        if(commonGCD > 1) return -1;

        int minLen = nums.length;
        for(int i = 0; i < nums.length; i++) {
            int currGCD = 0;
            for(int j = i; j < nums.length; j++) {
                currGCD = gcd(currGCD, nums[j]);
                if(currGCD == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen + nums.length - 2;
    }

    private static int gcd(int num1, int num2) {
        while(num2 != 0) {
            final int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}
