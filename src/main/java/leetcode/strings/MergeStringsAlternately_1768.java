package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.04.2023
 **/
public class MergeStringsAlternately_1768 {

    public static void main(String[] args) {

    }

    /**
     * Memory could be improved via using char array, efficiency could be improved via using SB
     * @param word1
     * @param word2
     * @return
     */
    private static String mergeAlternately(final String word1, final String word2) {
        final int l1 = word1.length();
        final int l2 = word2.length();
        String res = "";
        int index = 0;
        while(index < l1 && index < l2) {
            res += word1.substring(index, index+1) + word2.substring(index, index+1);
            index++;
        }
        if(index < l1) {
            res += word1.substring(index);
        }
        if(index < l2) {
            res += word2.substring(index);
        }
        return res;
    }
}
