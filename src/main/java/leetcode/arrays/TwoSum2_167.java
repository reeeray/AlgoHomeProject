package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.06.2022
 **/
public class TwoSum2_167 {

    public static void main(String[] args) {
        final int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        final int[] answ = new int[2];

        for(int i=0; i<numbers.length - 1; i++) {
            int k = searchFor(i, target - numbers[i], numbers);
            if(k != -1) {
                answ[0] = i+1;
                answ[1] = k+1;
                return answ;

            }
        }
        return answ;
    }

    private static int searchFor(final int index, final int t, final int[] numbers) {
        for(int i=index+1; i<numbers.length; i++) {
            if(numbers[i] > t)
                return -1;
            if(numbers[i] == t)
                return i;
        }
        return -1;
    }
}
