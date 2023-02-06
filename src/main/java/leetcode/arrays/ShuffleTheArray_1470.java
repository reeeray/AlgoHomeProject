package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.02.2023
 **/
public class ShuffleTheArray_1470 {

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/shuffle-the-array/solutions/2973933/shuffle-the-array/
    private static int[] shuffle(final int[] nums, int n) {
        final int[] res = new int[2*n];
        for(int i=0; i<n; i++) {
            res[2*n] = nums[i];
            res[2*n + 1] = nums[n + i];
        }
        return res;
    }
}
