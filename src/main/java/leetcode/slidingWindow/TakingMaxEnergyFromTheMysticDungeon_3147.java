package leetcode.slidingWindow;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.10.2025
 **/
public class TakingMaxEnergyFromTheMysticDungeon_3147 {

    public static void main(String[] args) {

    }

    //Reverse traversal Time O(n*k) and Space O(1)
    public static int maximumEnergy(final int[] energy, final int k) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++) {
            int curr = 0;
            for(int j = energy.length - 1 - i; j > -1; j -= k) {
                curr += energy[j];
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
