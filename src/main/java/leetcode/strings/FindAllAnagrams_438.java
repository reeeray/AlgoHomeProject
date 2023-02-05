package leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.02.2023
 **/
public class FindAllAnagrams_438 {

    public static void main(String[] args) {
        assert 2 == findAnagrams("cbaebabacd", "abc").size();
    }

    private static List<Integer> findAnagrams(final String s, final String p) {
        final int[] frequencies = new int[26];
        for(final char c : p.toCharArray()) {
            frequencies[c - 'a']++;
        }
        final List<Integer> answ = new ArrayList<>();
        for(int i=0; i<=s.length()-p.length(); i++) {
            final int[] currFreq = new int[26];

            for(int j=i; j<i+p.length(); j++) {
                final int cNum = s.charAt(j) - 'a';
                if(frequencies[cNum] != 0) {
                    currFreq[cNum]++;
                    if(currFreq[cNum] > frequencies[cNum]) {
                        break;
                    }
                    if(j == i + p.length()-1) {
                        answ.add(i);
                    }
                } else {
                    break;
                }
            }
        }

        return answ;
    }

    //slide window of size p
    private static List<Integer> findAnagramsElegant(final String s, final String p) {
            final List<Integer> result = new ArrayList<>();

            if(s == null || s.length() == 0)
                return result;
            final int[] sCount = new int[26];
            final int[] pCount = new int[26];

            for(char c : p.toCharArray()) {
                pCount[c - 'a']++;
            }

            for(int i=0; i<s.length(); i++) {
                sCount[s.charAt(i) - 'a']++;

                if(i >= p.length())
                    sCount[s.charAt(i - p.length()) - 'a']--;

                if(Arrays.equals(sCount, pCount))
                    result.add(i - p.length() + 1);
            }
            return result;
    }
}
