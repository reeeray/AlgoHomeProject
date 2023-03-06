package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.03.2023
 **/
public class KMissingPositiveNumber_1539 {

    public static void main(String[] args) {
        final int[] input = {1, 2, 3, 4};
        assert 6 == findKthPositive(input, 2);
    }

    public static int findKthPositive(final int[] arr, final int k) {
        int pointer = 0;
        int missingCounter = 0;
        for(int i=1; i<Integer.MAX_VALUE; i++) {
            if(pointer < arr.length && arr[pointer] == i) {
                pointer++;
            } else {
                missingCounter++;
            }
            if(missingCounter == k) {
                return i;
            }
        }
        return -1;
    }
}
