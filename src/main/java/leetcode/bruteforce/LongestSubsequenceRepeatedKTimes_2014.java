package leetcode.bruteforce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.06.2025
 **/
public class LongestSubsequenceRepeatedKTimes_2014 {

    public static void main(String[] args) {

    }

    //brute force with enumeration, Time O(factorial(n/k) * n) and Space O(factorial(n/k)) where n is the length of s
    public static String longestSubsequenceRepeatedK(final String s, final int k) {
        final int[] frequency = new int[26];
        for(final char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        final Queue<String> queue = new LinkedList<>();
        final List<Character> candidates = new ArrayList<>();
        //reverse order because priority is lexiograpical
        for(int i = 25; i >= 0; i--) {
            if(frequency[i] >= k) {
                candidates.add(Character.valueOf((char)('a' + i)));
                queue.add(String.valueOf((char)('a' + i)));
            }
        }
        String ans = "";
        while(!queue.isEmpty()) {
            final String curr = queue.poll();
            if(curr.length() > ans.length()) {
                ans = curr;
            }
            for(final char c : candidates) {
                final String nextCandidate = curr + c;
                if(isSubsequnceKTimesRepeated(nextCandidate, s, k)) {
                    queue.add(nextCandidate);
                }
            }
        }
        return ans;
    }

    private static boolean isSubsequnceKTimesRepeated(final String subseq, final String sequence, final int times) {
        int pos = 0, matched = 0, len = subseq.length();
        for(final char c : sequence.toCharArray()) {
            if(c == subseq.charAt(pos)) {
                pos++;
                if(pos == len) {
                    pos = 0;
                    matched++;
                    if(matched == times) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
