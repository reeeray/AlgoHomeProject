package leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.10.2022
 **/
public class MaxLOfConcatStr_1239 {

    int max = 0;
    List<String> list = new ArrayList<>();

    //backtrack means DFS basically, Time complexity if O(2^M) and Space complexity is O(M) where M is the max length of a string in array
    public int maxLength(final List<String> arr) {
        list = arr;
        backTrack("", 0);
        return max;
    }

    private void backTrack(final String str, final int index) {
        if(max < str.length()) {
            max = str.length();
        }

        for(int i=index; i<list.size(); i++) {
            if(!isUnique(str, list.get(i))) continue;
            backTrack(str + list.get(i), i + 1);
        }
    }

    private boolean isUnique(final String sequence, final String addition) {
        final int[] alphabet = new int[26];
        for(char c : addition.toCharArray()) {
            if(sequence.contains("" + c)) return false;
            if(++alphabet[c - 'a'] == 2) return false;
        }
        return true;
    }
}
