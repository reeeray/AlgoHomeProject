package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.05.2024
 **/
public class PalindromPartitioning_131 {

    public static void main(String[] args) {

    }

    public List<List<String>> partition(final String s) {
        final List<List<String>> res = new ArrayList<>();
        dfs(res, 0, new ArrayList<>(), s);
        return res;
    }

    private static void dfs(final List<List<String>> res, final int start, final List<String> currentSubList, final String str) {
        if(start >= str.length()) {
            res.add(new ArrayList<>(currentSubList));
            return;
        }

        for(int end = start; end < str.length(); end++) {
            if(isPalindrom(str, start, end)) {
                currentSubList.add(str.substring(start, end + 1));
                dfs(res, end + 1, currentSubList, str);
                currentSubList.remove(currentSubList.size() - 1);
            }
        }
    }

    private static boolean isPalindrom(final String str, int start, int end) {
        while(start < end) {
            if(str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
