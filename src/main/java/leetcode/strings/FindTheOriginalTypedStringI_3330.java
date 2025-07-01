package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.07.2025
 **/
public class FindTheOriginalTypedStringI_3330 {

    public static void main(String[] args) {
        possibleStringCount("abbcccc");
    }

    //Time O(n) and Space O(1)
    public static int possibleStringCount(final String word) {
        int res = 1;
        int left = 0;
        int right = 0;
        while (right < word.length()) {
            if(word.charAt(right) == word.charAt(left)) {
                right++;
            } else {
                res += right - left - 1;
                left = right++;
            }
        }
        return res + (right - left - 1);
    }

    public int possibleStringCountElegant(String word) {
        int n = word.length(), ans = 1;
        for (int i = 1; i < n; ++i) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ++ans;
            }
        }
        return ans;
    }
}
