package leetcode.graphs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.01.2025
 **/
public class MakeLexicographicallySmallestArrayBySwappingElements_2948 {

    public static void main(String[] args) {

    }

    //Time due to sorting it's O(nlogn) and Space O(n + logn) where logn is also coming from Quick sort Java.
    public static int[] lexicographicallySmallestArray(final int[] nums, final int limit) {
        final int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int groupId = 0;
        final Map<Integer, Integer> numToGroup = new HashMap<>();
        numToGroup.put(sortedNums[0], groupId);
        final Map<Integer, LinkedList<Integer>> groupToOrderedList = new HashMap<>();
        groupToOrderedList.put(groupId, new LinkedList<>(Collections.singletonList(sortedNums[0])));
        for(int i=1; i<nums.length; i++) {
            if(sortedNums[i] - sortedNums[i - 1] > limit) {
                groupId++;
            }
            numToGroup.put(sortedNums[i], groupId);
            if(!groupToOrderedList.containsKey(groupId)) {
                groupToOrderedList.put(groupId, new LinkedList<>());
            }
            groupToOrderedList.get(groupId).add(sortedNums[i]);
        }
        for(int i = 0; i < nums.length; i++) {
            final int group = numToGroup.get(nums[i]);
            nums[i] = groupToOrderedList.get(group).poll();
        }
        return nums;
    }
}
