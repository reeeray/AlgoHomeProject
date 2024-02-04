package leetcode.slidingWindow;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.02.2024
 **/
public class MinWindowSubstring_70 {

    public static void main(String[] args) {

    }

    public static String minWindow(final String s, final String t) {
        final Set<Character> unique = new HashSet<>();
        final List<Character> leftovers = new ArrayList<>();
        final List<Character> extra = new ArrayList<>();
        final Queue<Integer> positions = new LinkedList<>();
        for(char c : t.toCharArray()) {
            unique.add(c);
            leftovers.add(c);
        }
        String answ = "";
        for(int i=0; i<s.length(); i++) {
            if(unique.contains(s.charAt(i))) {
                positions.add(i);
                if(leftovers.remove((Character)s.charAt(i))) {
                    if(leftovers.isEmpty()) {
                        answ = answ.equals("") ? s.substring(positions.peek(), i + 1) : answ.length() >= s.substring(positions.peek(), i + 1).length() ? s.substring(positions.peek(), i + 1) : answ;
                        while(true) {
                            final char c = s.charAt(positions.poll());
                            if(extra.remove((Character)c)) {
                                answ = answ.equals("") ? s.substring(positions.peek(), i + 1) : answ.length() >= s.substring(positions.peek(), i +1).length() ? s.substring(positions.peek(), i +1) : answ;
                            } else {
                                leftovers.add(c);
                                break;
                            }
                        }
                    }
                } else {
                    extra.add(s.charAt(i));
                }
            }
        }
        return answ;
    }

    public static String minWindowOptimized(final String s, final String t) {
        final int [] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            map[c1]--;
            if (map[c1] >= 0)
                counter--;

            end++;
            while (counter == 0) {

                final char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2]> 0)counter++;

                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }

                start++;

            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
