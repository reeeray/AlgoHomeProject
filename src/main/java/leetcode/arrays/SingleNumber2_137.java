package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.07.2023
 **/
public class SingleNumber2_137 {

    public static void main(String[] args) {

    }

    public static int singleNumber(final int[] nums) {
        final Set<Integer> uniqeNums = new HashSet<>();
        long sum = 0L;
        for(int num : nums) {
            if(uniqeNums.add(num)) {
               sum += 2L*num;
            } else {
                sum -= num;
            }
        }
        return (int)(sum/2);
    }

    public static int singleNumberBitManipulation(final int[] nums) {
        //Tracks the bits that have appeared once
        int ones=0;
        //Tracks the bits that have appeared twice.
        int twos=0;
        for(int i=0;i<nums.length;i++)
        {
            ones=(nums[i]^ones)&~twos;
            twos=(nums[i]^twos)&~ones;
        }
        return ones;
    }
}
