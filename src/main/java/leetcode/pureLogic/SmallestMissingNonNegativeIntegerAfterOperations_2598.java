package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.10.2025
 **/
public class SmallestMissingNonNegativeIntegerAfterOperations_2598 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(value)
    public static int findSmallestInteger(final int[] nums, final int value) {
        final int[] leftOvers = new int[value];
        for(final int num : nums) {
            leftOvers[(num%value + value)%value]++;
        }
        int number = 0;
        while(leftOvers[number%value] != 0) {
            leftOvers[number++%value]--;
        }
        return number;
    }
}
