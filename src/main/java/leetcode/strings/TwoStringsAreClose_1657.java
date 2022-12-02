package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.12.2022
 **/
public class TwoStringsAreClose_1657 {

    public static void main(String[] args) {
        final String word1 = "cabbba";
        final String word2 = "abbccc";
        assert true == closeString(word1, word2);
    }

    private static boolean closeString(final String str1, final String str2) {
        final int[] arr1 = new int[26];
        final int[] arr2 = new int[26];
        for(final char c : str1.toCharArray()) {
            arr1[c-'a']++;
        }
        for(final char c : str2.toCharArray()) {
            arr2[c-'a']++;
        }
        final List<Integer> numberOfOccurrences = new ArrayList<>();
        for(int i=0; i<26; i++) {
            if ((arr1[i] == 0 && arr2[i] != 0) || (arr2[i] == 0 && arr1[i] != 0)) {
                return false;
            }
            numberOfOccurrences.add(arr1[i]);
        }

        for(int i=0; i<26; i++) {
            if(!numberOfOccurrences.remove(Integer.valueOf(arr2[i]))) {
                return false;
            }
        }
        return true;
    }
}
