package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.05.2025
 **/
public class ZeroArrayTransformationI_3355 {

    public static void main(String[] args) {

    }

    //Time O(2n + q) where n is the length of nums and q is length of queries and Space O(2n)
    public static boolean isZeroArratOpt(final int[] nums, final int[][] queries) {
        final int[] ranges = new int[nums.length + 1];
        for(final int[] query : queries) {
            ranges[query[0]]++;
            ranges[query[1] + 1]--;
        }
        int numberOfOperations = 0;
        final int[] counter = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            numberOfOperations += ranges[i];
            counter[i] = numberOfOperations;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > counter[i]) {
                return false;
            }
        }
        return true;
    }

    //TLE Time O(q*L + n) Space O(1) where L is largest range in query
    public static boolean isZeroArray(final int[] nums, final int[][] queries) {
        for(final int[] query : queries) {
            for(int i = query[0]; i <= query[1]; i++) {
                if(nums[i] == 0) continue;
                nums[i]--;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                return false;
        }
        return true;
    }
}
