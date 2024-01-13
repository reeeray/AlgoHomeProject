package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.01.2024
 **/
public class MinNumberOfStepsToMakeTwoStringsAnagram_1347 {

    public static void main(String[] args) {

    }

    public int minSteps(final String s, final String t) {
        final int[] voc = new int[26];
        for(int i=0; i<s.length(); i++) {
            voc[s.charAt(i) - 'a'] ++;
            voc[t.charAt(i) - 'a'] --;
        }

        int steps = 0;
        for(int i=0; i<26; i++) {
            if(voc[i] > 0) {
                steps += voc[i];
            }
        }

        return steps;
    }
}
