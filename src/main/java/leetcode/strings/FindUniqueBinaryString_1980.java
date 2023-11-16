package leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.11.2023
 **/
public class FindUniqueBinaryString_1980 {

    public static void main(String[] args) {

    }

    int n;
    Set<String> numsSet = new HashSet();

    private String generate(String curr) {
        if (curr.length() == n) {
            if (!numsSet.contains(curr)) {
                return curr;
            }

            return "";
        }

        String addZero = generate(curr + "0");
        if (addZero.length() > 0) {
            return addZero;
        }

        return generate(curr + "1");
    }

    public String findDifferentBinaryStringRecursive(String[] nums) {
        n = nums.length;
        for (String s : nums) {
            numsSet.add(s);
        }

        return generate("");
    }



    public String findDifferentBinaryString(final String[] nums) {
        final Set<Integer> unique = new HashSet<>();
        for(String num : nums) {
            unique.add(Integer.parseInt(num, 2));
        }

        for(int i=0; i<nums.length; i++) {
            if(!unique.contains(i)) {
                String str = Integer.toBinaryString(i);
                while(str.length() <= nums[0].length()) {
                    str = "0" + str;
                }
                return str;
            }
        }
        return "";
    }
}
