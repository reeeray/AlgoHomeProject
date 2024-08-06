package leetcode.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.08.2024
 **/
public class MinNumberOfPushesToTypeWord2_3016 {

    public static void main(String[] args) {
        minimumPushes("alporfmdqsbhncwyu");
    }

    //Time O(n) and Space O(1)
    public static int minimumPushes(final String word) {
        final int[] freq = new int[26];
        for(final char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        int ans = 0;
        Arrays.sort(freq);
        for(int i=25; i>=0 && freq[i] != 1; i--) {
            ans += freq[i] * ((26 - i) / 8 + 1);
        }
        return ans;
    }
}
