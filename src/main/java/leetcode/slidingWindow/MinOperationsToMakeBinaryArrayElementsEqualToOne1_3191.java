package leetcode.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.03.2025
 **/
public class MinOperationsToMakeBinaryArrayElementsEqualToOne1_3191 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public static int minOperations(final int[] nums) {
        final Deque<Integer> flipDeque = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            while (!flipDeque.isEmpty() && i > flipDeque.peekFirst() + 2) {
                flipDeque.pollFirst();
            }

            if((nums[i] + flipDeque.size()) % 2 == 0) {
                if(i + 2 >= nums.length) {
                    return -1;
                }
                count++;
                flipDeque.offerLast(i);
            }

        }
        return count;
    }

    //Time O(n) and Space O(1)
    public static int minOperationsOpt(final int[] nums) {
        int count = 0;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i - 2] == 0) {
                nums[i - 2] = nums[i - 2] ^ 1;
                nums[i - 1] = nums[i - 1] ^ 1;
                nums[i] = nums[i] ^ 1;
            }
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++) sum += nums[i];
        if(sum == nums.length) return count;
        return -1;
    }
}
