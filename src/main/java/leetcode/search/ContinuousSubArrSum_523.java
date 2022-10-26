package leetcode.search;

import patterns.creational.factory.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.10.2022
 **/
public class ContinuousSubArrSum_523 {


    public static void main(String[] args) {
        int[] input = {23, 2, 4, 6, 7};
        assert hasContinuousSubArrSum(input, 6) == true;

    }

    private static boolean hasContinuousSubArrSum(final int[] nums, final int evenNum) {
        final Map<Integer, Integer> reminders = new HashMap<>();
        reminders.put(0,0);
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];

            if(!reminders.containsKey(sum%evenNum)) {
                reminders.put(sum%evenNum, i+1);
            }else if (reminders.get(sum%evenNum) < i){
                return true;
            }
        }
        return false;
    }
}
