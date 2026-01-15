package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.01.2026
 **/
public class MaximizeAreaOfSquareHoleInGrid_2943 {

    public static void main(String[] args) {

    }

    //Time O(vlogv + hlogh) and Space O(logv + logh)
    public static int maximizeSquareHoleArea(final int n, final int m, final int[] hBars, final int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int hMax = 1, vMax = 1, hCurr = 1, vCurr = 1;
        for(int i = 1; i < hBars.length; i++) {
            if(hBars[i] == hBars[i - 1] + 1) {
                hCurr++;
            } else {
                hCurr = 1;
            }
            hMax = Math.max(hMax, hCurr);
        }

        for(int i = 1; i < vBars.length; i++) {
            if(vBars[i] == vBars[i - 1] + 1) {
                vCurr++;
            } else {
                vCurr = 1;
            }
            vMax = Math.max(vMax, vCurr);
        }
        final int maxLen = Math.min(hMax, vMax) + 1;
        return maxLen * maxLen;
    }
}
