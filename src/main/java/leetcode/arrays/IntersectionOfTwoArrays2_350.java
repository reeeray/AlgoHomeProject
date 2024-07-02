package leetcode.arrays;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.07.2024
 **/
public class IntersectionOfTwoArrays2_350 {

    public static void main(String[] args) {

    }

    public int[] intersectWorserPerform(int[] nums1, int[] nums2) {
        final Map<Integer, Integer> map = new HashMap<>();
        int [] nums = nums1.length > nums2.length ? nums1 : nums2;
        for(int num : nums) {
            if(map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }
        final List<Integer> res = new ArrayList<>();
        int[] small = nums1.length > nums2.length ? nums2 : nums1;
        for(int num : small) {
            if(map.containsKey(num)) {
                if(map.get(num) > 0)
                    res.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        final int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++)
            result[i] = res.get(i);
        return result;
    }

    //Time O(n + m) and Space O(1)
    public int[] intersect(final int[] nums1, final int[] nums2) {
        final int[] storage = new int[1001];
        final int[] biggest = nums1.length > nums2.length ? nums1 : nums2;
        final int[] smallest = nums1.length > nums2.length ? nums2 : nums1;
        for(int val : biggest) {
            storage[val]++;
        }
        int k =0;
        for(int val : smallest) {
            if(storage[val]-- > 0) {
                biggest[k++] = val;
            }
        }
        return Arrays.copyOfRange(biggest, 0, k);
    }

    //Time O(nlogn + mlogm) and Space O(1)
    public int[] intersectPointersApproach(int[] nums1, int[] nums2) {
        final int l1 = nums1.length;
        final int l2 = nums2.length;
        int i = 0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while( i < l1 && j < l2)
        {
            if(nums1[i] < nums2[j])
            {
                i++;
            }
            else if(nums1[i] > nums2[j])
            {
                j++;
            }
            else
            {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}