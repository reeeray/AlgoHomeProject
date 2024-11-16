package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.11.2024
 **/
public class FindThePowerOfKSizeSubarrays1_3254 {

    public static void main(String[] args) {
        final int[] input = new int[] {1, 2, 3, 4, 3, 2, 5};
        final int[] input1 = new int[] {5, 6, 27};
        resultArray(input, 3);
    }

    //Time O(n*k) and Space O(n-k+1)
    public static int[] resultArray(final int[] nums, final int k) {
        if(k == 1) {
            return nums;
        }
        final int[] result = new int[nums.length - k + 1];
        for(int i=k-1; i<nums.length; i++) {
            if(i - k >= 0 && result[i - k] > 0) {
                if(nums[i - 1] + 1 == nums[i]) {
                    result[i - k + 1] = nums[i];
                } else {
                    result[i - k + 1] = -1;
                }
            } else {
                for(int j=i - k + 1; j < i; j++) {
                    if(nums[j] + 1 != nums[j + 1]) {
                        result[i - k + 1] = -1;
                        break;
                    }
                }
                if(result[i - k + 1] == 0) {
                    result[i - k + 1] = nums[i];
                }
            }
        }
        return result;
    }
}
