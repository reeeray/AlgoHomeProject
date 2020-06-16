package leetcode;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Also known as
 * Dutch National Flag problem solution (See coursera Algorithms Part 1 slides).
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 11.06.2020
 **/
public class Sort_Colors_75 {

    public void sortColors(final int[] nums) {
        // //Insertion sort
        // for(int i=0; i<nums.length; i++) {
        //     for(int j=i; j>0;j--) {
        //         if(nums[j] < nums[j-1]) {
        //             nums[j-1] = nums[j]^nums[j-1];
        //             nums[j] = nums[j]^nums[j-1];
        //             nums[j-1] = nums[j-1]^nums[j];
        //         }else
        //             break;
        //     }
        // }
        int left = 0, curr = 0;
        int right = nums.length - 1;
        int storage = 0;
        while (curr <= right) {
            if (nums[curr] == 0) {
                storage = nums[curr];
                nums[curr++] = nums[left];
                nums[left++] = storage;
            } else if (nums[curr] == 2) {
                storage = nums[curr];
                nums[curr] = nums[right];
                nums[right--] = storage;
            } else
                curr++;
        }
    }
}
