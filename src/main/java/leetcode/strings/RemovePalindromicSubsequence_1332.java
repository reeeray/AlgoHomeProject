package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.06.2022
 **/
public class RemovePalindromicSubsequence_1332 {

    public static void main(String[] args) {
        assert removePalindromeSub("ababababa") == 1;
    }

    public static int removePalindromeSub(final String s) {
        return isPalindrom(s) ? 1 : 2;
    }

    private static boolean isPalindrom(final String s) {
        int i = 0, n = s.length();
        while(i <= n/2) {
            if(s.charAt(i) != s.charAt(n - 1 - i++))
                return false;
        }
        return true;
    }
}
