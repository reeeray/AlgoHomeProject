package leetcode.slidingWindow;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.08.2024
 **/
public class MinSwapsToGroupAll1Together_2134 {

    public static void main(String[] args) {
        assert 4 == minSwaps(new int[] {0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0});
    }

    //Time O(n) and Space O(1)
    public static int minSwaps(final int[] nums) {
        int minSwaps = Integer.MAX_VALUE;
        int totalCount = 0;
        for(final int num : nums) {
            totalCount += num;
        }
        int numOnes = nums[0];
        int end = 0;
        for(int start = 0; start < nums.length; start++) {
            if(start != 0) {
                numOnes -= nums[start - 1];
            }
            while (end - start + 1 < totalCount) {
                numOnes += nums[++end % nums.length];
            }
            minSwaps = Math.min(minSwaps, totalCount - numOnes);
        }
        System.out.println(minSwaps);
        return minSwaps;
    }


}
