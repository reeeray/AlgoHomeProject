package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.10.2022
 **/
public class ContaonsDuplicates_219 {

    public static void main(String[] args) {
        final int[] nums = {1, 2, 3, 1};

        assert containsDuplicates(nums, 3) == true;
    }

    //also possible to solve via hash map(maybe will be faster but memory consumption is more
    private static boolean containsDuplicates(final int[] nums, final int k) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; (j-i<=k)&&j<nums.length; j++) {
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}
