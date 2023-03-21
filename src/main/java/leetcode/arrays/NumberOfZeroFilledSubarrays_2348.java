package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.03.2023
 **/
public class NumberOfZeroFilledSubarrays_2348 {

    public static void main(String[] args) {

    }

    public static long zeroFilledSubarray(final int[] nums) {
        long sum = 0;
        int consequetive = 0;
        boolean isSeq = false;
        for(int num : nums) {
            if(num == 0) {
                isSeq = true;
                consequetive++;
            } else if(isSeq) {
                sum += (consequetive * (consequetive + 1) )/2;
                consequetive = 0;
                isSeq = false;
            }
        }
        if(isSeq) {
            sum += (consequetive * (consequetive + 1) )/2;
        }
        return sum;
    }

    public long zeroFilledSubarrayElegant(int[] nums) {
        long res=0;
        for(int i=0,j=0;i<nums.length;i++){
            if(nums[i]!=0) j=i+1;
            res+=i-j+1;
        }
        return res;
    }
}
