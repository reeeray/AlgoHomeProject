package leetcode.arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.06.2024
 **/
public class PatchingArray_330 {

    public static void main(String[] args) {
        System.out.println(minPatches(new int[] {1, 2, 2}, 5));
    }

    //Time complexity O(n) and Space O(1)
    public static int minPatches(final int[] nums, final int n) {
        long currMissing = 1;
        int arrIndex = 0;
        int patches = 0;
        while (currMissing <= n) {
            if(arrIndex < nums.length && currMissing >= nums[arrIndex]) {
                currMissing += nums[arrIndex++];
            } else {
                patches++;
                currMissing += currMissing;
            }
        }
        return patches;
    }

}
