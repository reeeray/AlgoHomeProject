package leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.10.2022
 **/
public class SetMismatch_645 {


    public static void main(String[] args) {
        final int[] input = {3, 2, 3, 4, 6, 5};
        final int[] expexted = {3, 1};
        System.out.println(Arrays.toString(solveGeneric(input)));
        assert Arrays.equals(solveGeneric(input), expexted);
        assert Arrays.equals(solveGenericImproved(input), expexted);
    }

    private static int[] solveOrdered(final int[] nums) {
        final int[] res = new int[2];
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != i+1) {
                res[0] = nums[i];
                res[1] = i+1;
                return res;
            }
        }
        return res;
    }

    private static int[] solveGeneric(final int[] nums) {
        final Set<Integer> dup = new HashSet<>();
        final int[] res = new int[2];
        for(int i=0; i<nums.length; i++) {
            dup.add(i+1);
        }
        for(int num : nums) {
            if(dup.add(num)) {
                res[0] = num;
            }
            dup.remove(num);
        }
        res[1] = dup.iterator().next();
        return res;
    }

    private static int[] solveGenericImproved(final int[] nums) {
        final Set<Integer> dup = new HashSet<>();
        final int[] res = new int[2];
        //search for dup
        for(int num : nums) {
            if(!dup.add(num)) {
                res[0] = num;
            }
        }

        //search for missing
        for(int i=0; i<nums.length; i++) {
            if(dup.add(i+1)) {
                res[1] = i + 1;
                return res;
            }
        }
        return null;
    }
}
