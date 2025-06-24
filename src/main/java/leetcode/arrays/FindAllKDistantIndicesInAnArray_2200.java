package leetcode.arrays;

import leetcode.structures.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.06.2025
 **/
public class FindAllKDistantIndicesInAnArray_2200 {

    public static void main(String[] args) {
        findKDistantIndices(new int[] {734,228,636,204,552,732,686,461,973,874,90,537,939,986,855,387,344,939,552,389,116,93,545,805,572,306,
                157,899,276,479,337,219,936,416,457,612,795,221,51,363,667,112,686,21,416,264,942,2,127,47,151,277,603,842,586,630,508,147,866,
                434,973,216,656,413,504,360,990,228,22,368,660,945,99,685,28,725,673,545,918,733,158,254,207,742,705,432,771,578,549,228,766,998,
                782,757,561,444,426,625,706,946}, 939, 34);
    }

    public static List<Integer> findKDistantIndices (final int[] nums, final int key, final int k) {
        final List<Integer> res = new ArrayList<>();
        int validity = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == key) {
                if(validity < 1) {
                    for (int j = i - k; j < i; j++) {
                        if(j >= 0) {
                            res.add(j);
                        }
                    }
                }
                validity = k + 1;
            }
            if(validity > 0) {
                validity--;
                res.add(i);
            }
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    //Time O(n) and Space O(1)
    public List<Integer> findKDistantIndicesOpt(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int r = 0; // unjudged minimum index
        int n = nums.length;
        for (int j = 0; j < n; ++j) {
            if (nums[j] == key) {
                int l = Math.max(r, j - k);
                r = Math.min(n - 1, j + k) + 1;
                for (int i = l; i < r; ++i) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
