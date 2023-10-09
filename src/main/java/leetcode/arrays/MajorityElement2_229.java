package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.10.2023
 **/
public class MajorityElement2_229 {

    public static void main(String[] args) {
        final int[] input = new int[]{3, 2, 3};
        majorityElement(input);
    }

    public static List<Integer> majorityElement(final int[] nums) {
        Arrays.sort(nums);
        final int factor = nums.length / 3;
        int curr = nums[0];
        int window = 1;
        final List<Integer> ans = new ArrayList<>();
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == curr) {
                window++;
                continue;
            } else {
                if(window > factor) {
                    ans.add(curr);
                }
                curr = nums[i];
                window = 1;
            }
        }
        if(window > factor) {
            ans.add(curr);
        }
        return ans;
    }
}
