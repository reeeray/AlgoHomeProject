package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.09.2023
 **/
public class FindTheDifference_389 {

    public static void main(String[] args) {
        assert 'e' == findTheDifference("abcd", "abcde");
    }

    private static char findTheDifference(final String s, final String t) {
        final char[] sArr = s.toCharArray();
        final char[] tArr = t.toCharArray();
        final int[] alphabet = new int[26];
        int pointer = 0;
        while(pointer < t.length()) {
            if(pointer < s.length()) {
                alphabet[sArr[pointer] - 'a']++;
            }
            alphabet[tArr[pointer++] - 'a']--;
        }
        for(int i=0; i<26; i++) {
            if(alphabet[i] == -1) {
                return (char)('a' + i);
            }
        }
        return 'a';
    }

    private static char findTheDifferenceXOR(final String s, final String t) {
        char c = 0;
        for(char cs : s.toCharArray()) c ^= cs;
        for(char ct : t.toCharArray()) c ^= ct;
        return c;
    }
}
