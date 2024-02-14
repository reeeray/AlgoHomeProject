package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.02.2024
 **/
public class ReaarangeArrayElementsBySign_2149 {

    public static void main(String[] args) {

    }

    public int[] rearrangeArray(final int[] nums) {
        final int[] ans = new int[nums.length];
        int positive = 0, negative = 0;
        for(int i=0; i<nums.length; i+=2) {
            for (int p=positive; p<nums.length; p++) {
                if(nums[p] >= 0) {
                    positive = p;
                    break;
                }
            }
            for (int n=negative; n<nums.length; n++) {
                if(nums[n] < 0) {
                    negative = n;
                    break;
                }
            }
            ans[i] = nums[positive++];
            ans[i + 1] = nums[negative++];
        }
        return ans;
    }

    //Space O(n) and Time O(n)
    public int[] rearrangeArrayOptimized(final int[] nums) {
        final int[] ans = new int[nums.length];
        int positive = 0, negative = 1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= 0) {
                ans[positive] = nums[i];
                positive += 2;
            } else {
                ans[negative] = nums[i];
                negative += 2;
            }
        }
        return ans;
    }
}
