package leetcode.arrays;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.07.2024
 **/
public class SortTheJumbledNumbers_2191 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortJumbledTLE(new int[] {8,9,4,0,2,1,3,5,7,6}, new int[] {991,338,38})));
    }

    public static int[] sortJumbledTLE(final int[] mapping, final int[] nums) {
        final Integer[] repr = Arrays.stream(nums).boxed().toArray(size -> new Integer[size]);
        final int[] decoded = new int[nums.length];
//        for(int i=0; i < nums.length; i++) {
//
//        }
        Arrays.sort(repr, Comparator.comparingInt(a -> decode(mapping, a)));

        for(int i=0; i<nums.length; i++) {
            nums[i] = repr[i];
        }
        return nums;
    }

    private static int decode(final int[] mapping, int val) {
        String ans = "";
        final String v = Integer.toString(val);
        for(final char c : v.toCharArray()) {
            final int r = mapping[c - '0'];
            ans += Integer.toString(r);
        }
        return Integer.parseInt(ans);
    }

    //Time O(nlogn) and Space O(n)
    public int[] sortJumbledWorking(int[] mapping, int[] nums) {
        final ArrayList<Integer[]> storePairs = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            // Convert current value to string
            final String number = Integer.toString(nums[i]);
            String formed = "";
            for (int j = 0; j < number.length(); ++j) {
                formed = formed +
                        Integer.toString(mapping[number.charAt(j) - '0']);
            }
            // Store the mapped value.
            int mappedValue = Integer.parseInt(formed);
            // Push a pair consisting of mapped value and original value's index.
            storePairs.add(new Integer[] { mappedValue, i });
        }

        // Sort the array in non-decreasing order by the first value (default).
        Collections.sort(
                storePairs,
                new Comparator<Integer[]>() {
                    @Override
                    public int compare(Integer[] o1, Integer[] o2) {
                        return o1[0].compareTo(o2[0]);
                    }
                }
        );

        int[] answer = new int[nums.length];
        for (int i = 0; i < storePairs.size(); i++) {
            answer[i] = nums[storePairs.get(i)[1]];
        }
        return answer;
    }

    public int[] sortJumbledSimilar(int[] mapping, int[] nums) {
        final List<int[]> storePairs = new ArrayList<int[]>();

        for (int i = 0; i < nums.length; i++) {
            int mappedValue = 0;
            int temp = nums[i];
            int place = 1;

            if (temp == 0) {
                storePairs.add(new int[] { mapping[0], i });
                continue;
            }
            while (temp != 0) {
                mappedValue = place * mapping[temp % 10] + mappedValue;
                place *= 10;
                temp /= 10;
            }
            storePairs.add(new int[] { mappedValue, i });
        }

        Collections.sort(storePairs, (a, b) -> a[0] - b[0]);

        final int[] answer = new int[nums.length];
        for (int i = 0; i < storePairs.size(); i++) {
            answer[i] = nums[storePairs.get(i)[1]];
        }

        return answer;
    }

}
