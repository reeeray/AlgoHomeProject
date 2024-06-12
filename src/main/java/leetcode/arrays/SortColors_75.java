package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.06.2024
 **/
public class SortColors_75 {

    public static void main(String[] args) {

    }

    //Space O(1) and Time O(n)
    public static void sortColors(final int[] nums) {
        int red = 0;
        int white = 0;
        for(int num : nums) {
            if ( num == 0) {
                red++;
            }else if (num == 1) {
                white++;
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(red-- > 0) {
                nums[i] = 0;
            } else if( white-- > 0) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
