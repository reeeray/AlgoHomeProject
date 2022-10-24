package leetcode.strings;

import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.10.2022
 **/
public class MaxLOfConcatStr_1239 {

    private static int max = 0;
    private static List<String> stringArr;

    public static void main(String[] args) {
        final List<String> input = Arrays.asList("cha", "r", "act", "ers");
        assert maxLength(input) == 6;
    }

    private static int maxLength(final List<String> arr) {
        stringArr = arr;
        backTrack("", 0);
        return max;
    }

    private static void backTrack(final String str, final int index) {
        if(max < str.length()) {
            max = str.length();
        }

        for(int i=index; i<stringArr.size(); i++) {
            if(!isUnique(str, stringArr.get(i))) continue;
            backTrack(str + stringArr.get(i), i+1);
        }
    }


    private static boolean isUnique(final String template, final String seq) {
        final int[] alfabet = new int[26];
        for(char c : seq.toCharArray()) {
            if(++alfabet[c - 'a'] == 2) return false;
            if(template.contains(c + "")) return false;
        }
        return true;
    }
}
