package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.01.2023
 **/
public class RestoreIDAddress_93 {

    public static void main(String[] args) {
        restoreIpAddress("172162541");
    }

    private static List<String> restoreIpAddress(final String s) {
        final List<String> ans = new ArrayList<>();
        if(s.length() < 4 || s.length() > 16) {
            return ans;
        }
        backTrack(s, 0, ans, "", 0);

        return ans;
    }

    private static void backTrack(final String s, final int index, final List<String> answer, final String res, final int count) {
        if(index >= s.length() || count >= 4) {
            if(count == 4 && index == s.length()) {
                answer.add(res.substring(0, res.length() - 1));
            }
            return;
        }

        backTrack(s, index + 1, answer, res + s.charAt(index) + ".", count + 1);
        if(s.charAt(index) != '0' && index + 1 < s.length()) {
            backTrack(s, index + 2, answer, res + s.charAt(index) + s.charAt(index + 1) + ".", count + 1);
        }
        if(index + 2 < s.length() && s.charAt(index) > '0' && Integer.valueOf("" + s.charAt(index) + s.charAt(index + 1) + s.charAt(index + 2)) <= 255) {
            backTrack(s, index + 3, answer, res + s.charAt(index) + s.charAt(index + 1) + s.charAt(index + 2) + ".", count + 1);
        }
    }
}
