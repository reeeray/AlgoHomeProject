package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.05.2025
 **/
public class Finding3DigitsEvenNumbers_2094 {

    public static void main(String[] args) {
        findEvenNumbers(new int[] {2, 1, 3, 0});
    }

    //First of all we need to know the frequency of each digit in given array. For this we create frequency container with const space limited to 10.
    //Then at each position, hundreds, dozens and ones might be also limited number digits, from 0 to 9. And actually hundreds can start only from 1, dozens can any and ones can be only even digits. We must add frequency check and that's it.
    //Time complexity: O(n), technically it's only iteration over array to know frequency, later 3 level inner for loop takes constant time.
    public static int[] findEvenNumbers(final int[] digits) {
        final int[] frequency = new int[10];
        for(final int digit : digits) {
            frequency[digit]++;
        }
        final List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            if(frequency[i] < 1) {
                continue;
            }
            frequency[i]--;
            for(int j = 0; j < 10; j++) {
                if(frequency[j] < 1) {
                    continue;
                }
                frequency[j]--;
                for(int k = 0; k < 9; k+=2) {
                    if(frequency[k] == 0) {
                        continue;
                    }
                    ans.add(i*100 + j*10 + k);
                }
                frequency[j]++;
            }
            frequency[i]++;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
