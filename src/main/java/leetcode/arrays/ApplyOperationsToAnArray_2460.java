package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.03.2025
 **/
public class ApplyOperationsToAnArray_2460 {

    public static void main(String[] args) {
        final int[] input = new int[] {1, 2, 2, 1, 1, 0};
        applyOperations(input);
    }

    //Time O(n) and Space O(n)
    public static int[] applyOperations(final int[] nums) {
        final int[] ans = new int[nums.length];
        int index = 0;
        int i = 0;
        while (i < nums.length){
            if(nums[i] == 0) {
                i++;
                continue;
            }
            if(i == nums.length - 1) {
                ans[index++] = nums[i];
                break;
            }
            if(nums[i] == nums[i + 1]) {
                ans[index++] = nums[i] * 2;
                i += 2;
            } else {
                ans[index++] = nums[i++];
            }

        }
        return ans;
    }

    //seems bullshit
    public int[] applyOperationsSpaceOpt(int[] nums) {
        int n = nums.length;
        int writeIndex = 0; // Pointer to place non-zero elements

        for (int index = 0; index < n; index++) {
            // Step 1: Merge adjacent equal elements if they are non-zero
            if (
                    index < n - 1 &&
                            nums[index] == nums[index + 1] &&
                            nums[index] != 0
            ) {
                nums[index] *= 2;
                nums[index + 1] = 0;
            }

            // Step 2: Shift non-zero elements to the front
            if (nums[index] != 0) {
                if (index != writeIndex) {
                    int temp = nums[index];
                    nums[index] = nums[writeIndex];
                    nums[writeIndex] = temp;
                }
                writeIndex++;
            }
        }

        return nums;
    }
}
