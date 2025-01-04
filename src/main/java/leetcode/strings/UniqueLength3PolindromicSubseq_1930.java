package leetcode.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.11.2023
 **/
public class UniqueLength3PolindromicSubseq_1930 {

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }


    //Time O(n) Space O(1)
    public static int countPalindromicSubsequence_1930(final String s) {
        final int[] firstOccurance = new int[26];
        Arrays.fill(firstOccurance, -1);
        final int[] secondOccurance = new int[26];
        for(int i=0; i<s.length(); i++) {
            final int charIndex = s.charAt(i) - 'a';
            if(firstOccurance[charIndex] == -1) {
                firstOccurance[charIndex] = i;
            }
            secondOccurance [charIndex] = i;
        }

        int count = 0;
        for(int i=0; i<26; i++) {
            if(firstOccurance[i] == -1) {
                continue;
            }
            final HashSet<Character> unique = new HashSet<>();
            for(int j = firstOccurance[i] + 1; j <secondOccurance[i]; j++) {
                unique.add(s.charAt(j));
            }
            count += unique.size();
        }
        return count;
    }

    // Time O(n) and Space O(1)
    public int countPalindromicSubsequenceCountLettresInBetween(final String s) {
        final Set<Character> letters = new HashSet();
        for (final Character c : s.toCharArray()) {
            letters.add(c);
        }

        int ans = 0;
        for (final Character letter : letters) {
            int i = -1;
            int j = 0;

            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == letter) {
                    if (i == -1) {
                        i = k;
                    }

                    j = k;
                }
            }

            final Set<Character> between = new HashSet();
            for (int k = i + 1; k < j; k++) {
                between.add(s.charAt(k));
            }

            ans += between.size();
        }

        return ans;
    }

    //TLE
    public static int countPalindromicSubsequence(final String s) {
        final char[] chars = s.toCharArray();
        final Set<String> unique = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            final char c = s.charAt(i);
            int left = i+1;
            int right = s.length()-1;
            while(left < right) {
                if(chars[right] == c) {
                    unique.add("" + c + s.charAt(left) + s.charAt(right));
                    left++;
                } else {
                    right--;
                }
            }
        }
        return unique.size();
    }
}
