package leetcode.algos;

/**
 *
 * Known problem. Resplution is Floyd's algorithm
 * User : Shein G.A.{@reeeray}
 * Date : 19.09.2023
 **/
public class FindTheDuplicateNumber_287 {

    public static void main(String[] args) {

    }

    public int findDuplicates(final int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
