package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.09.2023
 **/
public class IsSubseq_392 {

    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) {
            return true;
        }
        final char[] chars = s.toCharArray();
        int p = 0;
        for(char c : t.toCharArray()) {
            if(c == chars[p]) {
                p++;
            }
            if(p == s.length()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubsequenceWithoutSpace(String s, String t) {
        if(s.isEmpty()) {
            return true;
        }
        int j = 0;
        for(int i = 0; i < t.length() && j < s.length(); i ++) {
            if(t.charAt(i) == s.charAt(j)){
                j++;
                if(j == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
