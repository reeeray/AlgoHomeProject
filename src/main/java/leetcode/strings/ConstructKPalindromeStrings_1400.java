package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.01.2025
 **/
public class ConstructKPalindromeStrings_1400 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static boolean canConstruct(final String s, final int k) {
        if(s.length() < k) return false;
        if(s.length() == k) return true;
        final int[] chars = new int[26];
        for(final char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        int oddCount = 0;
        for(int i=0; i<26; i++) {
            oddCount += chars[i] % 2;
        }
        return oddCount <= k;
    }
}
