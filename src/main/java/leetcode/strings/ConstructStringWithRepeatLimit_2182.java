package leetcode.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.12.2024
 **/
public class ConstructStringWithRepeatLimit_2182 {

    public static void main(String[] args) {
        System.out.println(repeatLimitedString("cczazcc", 3));
        System.out.println(repeatLimitedString("aababab", 2));
    }

    //O(1) (to be precise O(k)) O(n*k) where k is number of unique elements in string
    public static String repeatLimitedString(final String s, final int repeatLimit) {
        final int[] chars = new int[26];
        for(final char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        final StringBuilder sb = new StringBuilder();
        int lastIndex = findLastIndex(chars);
        int lastAdded = -1;
        while (lastIndex >= 0 && lastAdded != lastIndex) {
            for(int i=lastIndex; i >= 0; i--) {
                final int capacity = chars[i];
                if(capacity == 0) continue;
                if(i == lastIndex) {
                    appendNTimes(sb, (char)('a' + i), repeatLimit >= capacity ? capacity : repeatLimit);
                    chars[i] -= repeatLimit >= capacity ? capacity : repeatLimit;
                    lastIndex = chars[i] == 0 ? findLastIndex(chars) : lastIndex;
                    lastAdded = i;
                } else {
                    sb.append((char)('a' + i));
                    lastAdded = i;
                    chars[i]--;
                    break;
                }
            }
        }
        return sb.toString();
    }

    private static void appendNTimes(final StringBuilder sb, final char c, final int n) {
        for(int i=0; i<n; i++) {
            sb.append(c);
        }
    }

    private static int findLastIndex(final int[] chars) {
        for (int i = 25; i >= 0; i--) {
            if (chars[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    //Space O(k) and Time O(n*logk) k - is number of unique characters in string
    public String repeatLimitedStringTimeOptimized(final String s, final int repeatLimit) {
        final int[] freq = new int[26];
        final PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> Character.compare(b, a));
        final StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
         freq[c - 'a']++;
        }
        for(int i=0; i<26; i++) {
            if(freq[i] != 0) {
                heap.offer((char)('a' + i));
            }
        }

        while (!heap.isEmpty()) {
            final char c = heap.poll();
            final int count = freq[c - 'a'];
            int used = Math.min(count, repeatLimit);
            for (int i = 0; i < used; i++) {
                sb.append(c);
            }
            freq[c - 'a'] -= used;
            if (freq[c - 'a'] > 0 && !heap.isEmpty()) {
                final char nextC = heap.poll();
                sb.append(nextC);
                freq[nextC - 'a']--;
                if (freq[nextC - 'a'] > 0) {
                    heap.offer(nextC);
                }
                heap.offer(c);
            }
        }

        return sb.toString();
    }
}
