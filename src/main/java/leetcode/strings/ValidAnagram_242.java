package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.12.2023
 **/
public class ValidAnagram_242 {

    public static void main(String[] args) {

    }

    public boolean isAnagram(final String s, final String t) {
        if(s.length() != t.length()) {
            return false;
        }
        final int[] table = new int[26];
        for(int i=0; i<s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt((i) - 'a')]--;
        }

        for(int i : table) {
            if(i != 0) {
                return false;
            }
        }
        return true;

    }
}
