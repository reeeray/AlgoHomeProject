package leetcode.binaryStuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.02.2024
 **/
public class LargestDivisibleSubset_368 {

    public static void main(String[] args) {

    }

    //Time O(n^2) and Space O(n)
    public List<Integer> largestDivisibleSubset(final int[] nums) {
        Arrays.sort(nums);
        final int[] groupSize = new int[nums.length];
        final int[] prevElement = new int[nums.length];
        groupSize[0] = 1;
        prevElement[0] = -1;
        int maxElementIndex = 0;
        for(int i=0; i<nums.length; i++) {
            groupSize[i] = 1;
            prevElement[i] = -1;
            for(int j=0; j<nums.length; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(groupSize[i] < groupSize[j] + 1) {
                        groupSize[i] = groupSize[j] + 1;
                        prevElement[i] = j;
                    }
                }
            }
            if(groupSize[maxElementIndex] < groupSize[i]) {
                maxElementIndex = i;
            }
        }
        final List<Integer> answ = new ArrayList<>();
        while(maxElementIndex != - 1) {
            answ.add(nums[maxElementIndex]);
            maxElementIndex = prevElement[maxElementIndex];
        }
        return answ;
    }
}
