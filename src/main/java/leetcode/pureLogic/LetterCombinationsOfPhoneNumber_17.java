package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.08.2023
 **/
public class LetterCombinationsOfPhoneNumber_17 {

    public static String[][] keyboard = new String[][] {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"},
            {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(final String digits) {
        final List<String> answer = new ArrayList<>();
        if(!digits.isEmpty())
            dfs(answer, "", digits, 0);
        return answer;
    }

    private static void dfs(final List<String> res, final String cur, final String digits, final int index) {
        if(index == digits.length()) {
            res.add(cur);
            return;
        }

        final int digit = Integer.valueOf(digits.charAt(index) - '0');
        for(String c : keyboard[digit-2]) {
            dfs(res, cur + c, digits, index + 1);
        }
    }
}
