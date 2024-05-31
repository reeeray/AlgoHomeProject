package leetcode.binaryStuff;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.06.2024
 **/
public class SingleNumber3_260 {

    public static void main(String[] args) {

    }

    //Space O(n) and Time O(n)
    public static int[] ingelNumber (final int[] nums) {
        final Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return freq.entrySet().stream().filter(entry -> entry.getValue() == 1).mapToInt(Map.Entry::getKey).toArray();
    }

    //Time O(n) and Space O(1)
    public static int[] singleNumber(final int[] nums) {
        int xor=0;
        for(int num:nums){
            xor^=num;
        }

        int[] result = new int[2];
        int rightmostSetBit = xor & -xor;
        int num1 = 0, num2 = 0;

        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                num1 ^= num; // XOR all numbers with rightmost set bit as 0
            } else {
                num2 ^= num; // XOR all numbers with rightmost set bit as 1
            }
        }

        result[0] = num1;
        result[1] = num2;

        return result;
    }
}
