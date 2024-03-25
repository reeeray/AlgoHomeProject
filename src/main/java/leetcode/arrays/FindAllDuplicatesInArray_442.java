package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.03.2024
 **/
public class FindAllDuplicatesInArray_442 {

    public static void main(String[] args) {

    }

    public List<Integer> findDuplicates(final int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correct = nums[i]-1;
            if(nums[i] != nums[correct]){
                nums[i] = nums[correct];
                nums[correct] = correct + 1;
            }else{
                i++;
            }
        }

        final List<Integer> res = new ArrayList<Integer>();
        for(int j = 0; j < nums.length ; j++){
            if( (nums[j] != j+1) ){
                res.add(nums[j]);
            }
        }
        return res;
    }
}
