package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.03.2024
 **/
public class FirstMissingPositive_41 {

    public static void main(String[] args) {

    }

    //time O(n) and space O(n)
    public static int firstMissingPositive(final int[] nums) {
        final int n = nums.length;
        final boolean[] positive = new boolean[n+1];
        for(int num : nums) {
            if(num > 0 && num <= n) {
                positive[num-1] = true;
            }
        }

        for(int i=0; i<=n; i++) {
            if(!positive[i]) {
                return i + 1;
            }
        }

        return -1;
    }

    //cycle sort Time O(n) and Space O(1) extra
    public int firstMissingPositiveOptim(int[] nums) {
        int n = nums.length;

        // Use cycle sort to place positive elements smaller than n
        // at the correct index
        int i = 0;
        while (i < n) {
            int correctIdx = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIdx]) {
                final int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            } else {
                i++;
            }
        }

        // Iterate through nums
        // return smallest missing positive integer
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all elements are at the correct index
        // the smallest missing positive number is n + 1
        return n + 1;
    }
}
