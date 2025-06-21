package leetcode.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.06.2025
 **/
public class MinDeletionsToMakeStringKSpecial_3085 {

    public static void main(String[] args) {
        minimumDeletions("dabdcbdcdcd", 2);
    }

    //Time O(n + ClogC) and Space O(C)
    public static int minimumDeletions(final String word, final int k) {
        final int[] freq = new int[26];
        for(final char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int min = word.length() - 1;
        int index = 0;
        int fromPrev = 0;
        while (index < 25 || min > fromPrev) {
            if(freq[index] == 0) {
                index++;
                continue;
            }
            int temp = fromPrev;
            for(int i = index; i < 26; i++) {
                temp += freq[i] - freq[index] > k ? freq[i] - freq[index] - k : 0;
            }
            min = Math.min(temp, min);
            fromPrev += freq[index++];
        }
        return min;
    }

    //Time O(n + C^2) and Space O(C) where C is the size of character set
    public int minimumDeletionsEditorial(String word, int k) {
        final Map<Character, Integer> cnt = new HashMap<>();
        for (char ch : word.toCharArray()) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }
        int res = word.length();
        for (int a : cnt.values()) {
            int deleted = 0;
            for (int b : cnt.values()) {
                if (a > b) {
                    deleted += b;
                } else if (b > a + k) {
                    deleted += b - (a + k);
                }
            }
            res = Math.min(res, deleted);
        }
        return res;
    }
}
