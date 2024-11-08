package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.11.2024
 **/
public class MaxXORForEachQuery_1829 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public static int[] getMaximumXor(final int[] nums, final int maximumBit) {
        final int[] pref = new int[nums.length];
        pref[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            pref[i] = pref[i - 1] ^ nums[i];
        }
        int mask = (1 << maximumBit) - 1;
        final int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            ans[i] = pref[pref.length - 1 - i] ^ mask;
        }
        return ans;
    }

    //Space O(1) and Time O(n)
    public int[] getMaximumXorSpaceOptimized(int[] nums, int maximumBit) {
        int xorProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            xorProduct = xorProduct ^ nums[i];
        }
        int[] ans = new int[nums.length];

        int mask = (1 << maximumBit) - 1;

        for (int i = 0; i < nums.length; i++) {
            ans[i] = xorProduct ^ mask;
            // remove last element
            xorProduct = xorProduct ^ nums[nums.length - 1 - i];
        }

        return ans;
    }
}
