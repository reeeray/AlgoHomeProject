package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.03.2025
 **/
public class MergeTwo2DArraysBySummingValues_2570 {

    public static void main(String[] args) {

    }

    //Time O(n1 + n2) and Space O(n) where n is the size of result
    public static int[][] mergeArrays(final int[][] nums1, final int[][] nums2) {
        final ArrayList<int[]> answer = new ArrayList<>();
        int indexNum1 = 0;
        int indexNum2 = 0;
        while (indexNum1 < nums1.length || indexNum2 < nums2.length) {
            if(indexNum1 >= nums1.length || (indexNum2 < nums2.length && nums1[indexNum1][0] > nums2[indexNum2][0])) {
                answer.add(new int[] {nums2[indexNum2][0], nums2[indexNum2++][1]});
                continue;
            }
            if(indexNum2 >= nums2.length || nums1[indexNum1][0] < nums2[indexNum2][0]) {
                answer.add(new int[] {nums1[indexNum1][0], nums1[indexNum1++][1]});
                continue;
            }
            if(nums1[indexNum1][0] == nums2[indexNum2][0]) {
                answer.add(new int[]{nums1[indexNum1][0], nums1[indexNum1++][1] + nums2[indexNum2++][1]});
            }
        }
        return answer.toArray(new int[0][]);
    }
}
