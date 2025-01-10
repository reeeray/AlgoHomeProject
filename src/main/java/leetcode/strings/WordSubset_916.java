package leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.01.2025
 **/
public class WordSubset_916 {

    public static void main(String[] args) {

    }

    //Time O(n*u + m*v) where n is the length of words1 and u is the average length of th word in words1, and space O(words1.length + words2.length)
    public static List<String> wordSubsetsOpt(final String[] words1, final String[] words2) {
        final int[] words2Max = new int[26];
        for(final String word : words2) {
            final int[] chars = new int[26];
            for(final char c : word.toCharArray()) {
                chars[c - 'a']++;
            }
            for(int i=0; i<26; i++) {
                words2Max[i] = Math.max(words2Max[i], chars[i]);
            }
        }
        final List<String> res = new ArrayList<>();
        for(final String word : words1) {
            final int[] chars = new int[26];
            boolean isSufficient = true;
            for(final char c : word.toCharArray()) {
                chars[c - 'a']++;
            }
            for(int i=0; i<26; i++) {
                if(chars[i] < words2Max[i]) {
                    isSufficient = false;
                    break;
                }
            }
            if(isSufficient) {
                res.add(word);
            }
        }
        return res;
    }
    //TLE
    public static List<String> wordSubsets(final String[] words1, final String[] words2) {
        final List<String> res = new ArrayList<>();
        for(final String word : words1) {
            final int[] chars = new int[26];
            for(final char c : word.toCharArray()) {
                chars[c - 'a']++;
            }
            boolean isUniversal = true;
            for(final String wrd : words2) {
                final int[] copy = chars.clone();
                for(final char c : wrd.toCharArray()) {
                    if(copy[c - 'a']-- == 0) {
                        isUniversal = false;
                        break;
                    }
                }
                if(!isUniversal) {
                    break;
                }
            }
            if(isUniversal) {
                res.add(word);
            }
        }
        return res;
    }
}
