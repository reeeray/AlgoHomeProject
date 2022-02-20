package leetcode.arrays;

/**
 * Should be in place, 0(1).
 * User : Shein G.A.{@reeeray}
 * Date : 09.02.2022
 **/
public class RemoveDuplicatesFromSortedArr_26 {

    public static void main(String[] args) {
        final int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        final int[] expected = {0, 1, 2, 3, 4};

        final int res = removeDuplicates(arr);

        assert res == expected.length;

        for (int i = 0; i < res; i++) {
            assert arr[i] == expected[i];
        }

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int index = 1;
        int unique = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != unique) {
                unique = nums[i];
                nums[index] = unique;
                index++;
            }
        }
        return index;
    }


}
