package leetcode.arrays.binarySearch;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.10.2023
 **/
public class FindTheOriginalArrOfPrefixXor_2433 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findArray(new int[] {5, 2, 0, 3, 1})));
    }

    public static int[] findArray(final int[] pref) {
        int prev = pref[0];
        for(int i=1; i<pref.length; i++) {
            int cur = pref[i];
            pref[i] = prev^pref[i];
            prev = cur;
        }

        return pref;
    }

    public static int[] findArraySpaceOpptimized(final int[] pref) {
        for(int i=pref.length-1; i>0; i--) {
            pref[i] = pref[i]^pref[i-1];
        }
        return pref;
    }
}
