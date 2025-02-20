package leetcode.binaryStuff;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.02.2025
 **/
public class FindUniqueBinaryString_1980 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1). Cantors diagonal algorithm
    public static String findDifferentBinaryStringDiagonalAlgorithm(final String[] nums) {
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
    //not correct because it might contain "111..." element and they will be repeated
    public String findDifferentBinaryString(final String[] nums) {
        final StringBuilder mask = new StringBuilder();
        for(int i = 0; i <= nums.length; i++) {
            mask.append('1');
        }
        int xor = Integer.valueOf(mask.toString(), 2);
        for(int i = 0; i < nums.length; i++) {
            xor ^= Integer.valueOf(nums[i], 2);
        }
        final String str = Integer.toBinaryString(xor);
        final StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= nums.length - str.length(); i++) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    //Time O(n^2) and Space O(n)
    public String findDifferentBinaryStringGreedy(String[] nums) {
        final Set<Integer> integers = new HashSet();
        for (String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }

        int n = nums.length;
        for (int num = 0; num <= n; num++) {
            if (!integers.contains(num)) {
                String ans = Integer.toBinaryString(num);
                while (ans.length() < n) {
                    ans = "0" + ans;
                }

                return ans;
            }
        }

        return "";
    }
}
