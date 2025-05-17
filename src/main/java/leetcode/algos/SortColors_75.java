package leetcode.algos;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.05.2025
 **/
public class SortColors_75 {

    public static void main(String[] args) {

    }

    //Space O(1) and Time O(n)
    public static void sortColorsOnePass(final int[] nums) {
        int left = 0, right = nums.length - 1, curr = 0;
        while (curr <= right) {
            if(nums[curr] == 0) {
            int temp = nums[left];
            nums[left++] = nums[curr];
            nums[curr++] = temp;
            } else if (nums[curr] == 2) {
                final int temp = nums[right];
                nums[right++] = nums[curr];
                nums[curr] = temp;
            } else {
                curr++;
            }
        }
    }

    //Space O(1) and Time O(2n)
    public static void sortColors(final int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                red++;
            } else if (nums[i] == 1) {
                white++;
            } else {
                blue++;
            }
        }
        int index = 0;
        while (red > 0) {
            nums[index++] = 0;
            red--;
        }
        while (white > 0) {
            nums[index++] = 1;
            white--;
        }
        while(blue > 0) {
            nums[index++] = 2;
            blue--;
        }
    }
}
