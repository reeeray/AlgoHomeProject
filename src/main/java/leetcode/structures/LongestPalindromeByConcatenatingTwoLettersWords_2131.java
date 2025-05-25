package leetcode.structures;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.05.2025
 **/
public class LongestPalindromeByConcatenatingTwoLettersWords_2131 {

    public static void main(String[] args) {
        longestPalindrome(new String[] {"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"});
    }

    //Time O(n *L) Space O(L) Greedy
    public static int longestPalindrome(final String[] words) {
        final Map<String, int[]> pairCounter = new HashMap<>();
        for(final String word : words) {
            final String wordPair = "" + word.charAt(1) + word.charAt(0);
            if(pairCounter.containsKey(word)) {
                final int[] arr = pairCounter.get(word);
                if(word.charAt(0) == word.charAt(1) && arr[0] > arr[1]) {
                    arr[1]++;
                } else {
                    arr[0]++;
                }
                continue;
            }
            if(pairCounter.containsKey(wordPair)) {
                pairCounter.get(wordPair)[1]++;
                continue;
            }
            pairCounter.put(word, new int[] {1, 0});
        }
        int count = 0;
        boolean isPalindromicWordWithoutPair = false;
        for(final Map.Entry<String, int[]> pairs : pairCounter.entrySet()) {
            if(pairs.getValue()[0] > pairs.getValue()[1] && pairs.getKey().charAt(0) == pairs.getKey().charAt(1)) {
                isPalindromicWordWithoutPair = true;
            }
            count += Math.min(pairs.getValue()[0], pairs.getValue()[1]) * 4;
        }
        count += isPalindromicWordWithoutPair ? 2 : 0;
        return count;
    }

    //Time O(n) and Space O(L) using word matrix
    public int longestPalindromeOpt(String[] words) {
        int[][] mpp = new int[26][26];
        int count = 0, middle = 0;
        for (String s : words) {
            int x = s.charAt(0) - 'a', y = s.charAt(1) - 'a';
            if (mpp[y][x] > 0) {
                mpp[y][x]--;
                count += 4;
                if (x == y) middle--;
            } else {
                mpp[x][y]++;
                if (x == y) middle++;
            }
        }
        if (middle > 0) count += 2;
        return count;
    }
}
