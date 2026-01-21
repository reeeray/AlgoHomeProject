package leetcode.binaryStuff;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.01.2026
 **/
public class ConstructTheMinBitwiseArrayII_3315 {

    public static void main(String[] args) {

    }

    public static int[] minBitwiseArray(final List<Integer> nums) {
        final int n = nums.size();
        final int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            int r = -1;
            int d = 1;
            final int val = nums.get(i);
            while ((val & d) != 0) {
                r = val - d;
                d <<= 1;
            }
            res[i] = r;
        }
        return res;
    }
}
