package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.05.2024
 **/
public class LargestPositiveIntegerThatExistsWithItsNegative_2441 {

    public static void main(String[] args) {

    }

    public static int finadMaxK(final int[] nums) {
        final Set<Integer> numbers = new HashSet<>();
        int max = -1;
        for(final int num : nums) {
            if(numbers.contains(-num)) {
               max = Math.max(max, Math.abs(num));
            }
            numbers.add(num);
        }
        return max;
    }
}
