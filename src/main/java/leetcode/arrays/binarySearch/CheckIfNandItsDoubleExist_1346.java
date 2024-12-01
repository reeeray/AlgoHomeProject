package leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.12.2024
 **/
public class CheckIfNandItsDoubleExist_1346 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public static boolean checkIfExist(final int[] arr) {
        final Set<Integer> numbers = new HashSet<>();
        for(final int number : arr) {
            if(numbers.contains(number * 2) || (number % 2 == 0 && numbers.contains(number / 2))) {
                return true;
            }
            numbers.add(number);
        }
        return false;
    }

    //Time O(nlogn) Space O(1)
    public boolean checkIfExistAlternative(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; ++i) {
            int currentValue = arr[i];
            int idx = Arrays.binarySearch(arr, 2 * currentValue);
            if (idx >= 0 && idx != i) {
                return true;
            }
        }

        return false;
    }
}
