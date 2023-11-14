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

    public static int countWithoutTLE(final String s) {
        final int[] firstindex = new int[26];
        final int[] lastIndex = new int[26];
        Arrays.fill(firstindex, -1);
        for(int i = 0; i<s.length(); i++) {
            final int index = s.charAt(i) - 'a';
            if(firstindex[index] == -1) {
                firstindex[index] = i;
            }
            lastIndex[index] = i;
        }

        int total = 0;
        for(int i = 0; i < 26; i++) {
            if(firstindex[i] == - 1) {
                continue;
            }

            final Set<Character> uniqie = new HashSet<>();
            for(int j=firstindex[i] + 1; j<lastIndex[i]; j++) {
                uniqie.add(s.charAt(j));
            }
            total += uniqie.size();
        }
        return total;
    }
}
