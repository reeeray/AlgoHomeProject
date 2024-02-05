package leetcode.pureLogic;

import edu.princeton.cs.algs4.In;
import patterns.creational.factory.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.02.2024
 **/
public class FirstUniqueCharacterInAStirng_387 {

    public static void main(String[] args) {
        assert firstUniqCharacter("grigory") == 2;
        System.out.println(firstUniqCharacterOptimized("leetcode"));
    }

    public static int firstUniqCharacter(final String s) {
        final int[] count = new int[26];
        final List<Character> order = new ArrayList<>();
        for(char c : s.toCharArray()) {
            if(count[c - 'a']++ > 0) {
                order.remove((Character)c);
            } else {
                order.add(c);
            }
        }
        return order.isEmpty() ? -1 : s.indexOf(order.get(0));
    }

    public static int firstUniqCharacterOptimized(final String s) {
        final int[] storage = new int[26];
        for(char c : s.toCharArray()) {
            storage[c - 'a']++;
        }

        int answ = Integer.MAX_VALUE;

        for(int i=0; i<26; i++) {
            if(storage[i] == 1) {
             answ = Math.min(answ, s.indexOf((char)('a' + i)));
            }
        }
        return answ == Integer.MAX_VALUE ? -1 : answ;
    }

    //Time O(n) and Space O(1)
    public static int firstUniqCharacterAlternativeOptimized(final String s) {
        int answ = Integer.MAX_VALUE;
        for(char c = 'a'; c <= 'z'; c++) {
            final int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                answ = Math.min(answ, index);
            }
        }
        return answ == Integer.MAX_VALUE ? -1 : answ;
    }
}
