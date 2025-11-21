package leetcode.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.11.2025
 **/
public class UniqueLength3PalindromicSubsequences_1930 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static int countPalindromicSubsequence(final String s) {
        final Set<Character>[] mem = new Set[26];
        for(int left = 0; left < s.length() - 2; left++) {
            if(mem[s.charAt(left) - 'a'] != null) continue;
            final Set<Character> currSet = new HashSet<>();
            mem[s.charAt(left) - 'a'] = currSet;
            final char leftChar = s.charAt(left);
            for(int right = s.length() - 1; right > left + 1; right--) {
                if(s.charAt(right) != leftChar) continue;
                for(int mid = left + 1; mid < right; mid++) {
                    currSet.add(s.charAt(mid));
                }
                break;
            }
        }
        int res = 0;
        for(int i = 0; i < 26; i++) {
            if(mem[i] != null) res += mem[i].size();
        }
        return res;
    }

    public int countPalindromicSubsequenceABitMoreOptimized(String s) {
        final int[] first = new int[26];
        final int[] last = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (first[curr] == - 1) {
                first[curr] = i;
            }

            last[curr] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }

            final Set<Character> between = new HashSet();
            for (int j = first[i] + 1; j < last[i]; j++) {
                between.add(s.charAt(j));
            }

            ans += between.size();
        }

        return ans;
    }
}
