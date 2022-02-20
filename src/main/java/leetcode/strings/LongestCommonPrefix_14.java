package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.02.2022
 **/
public class LongestCommonPrefix_14 {


    public static void main(String[] args) {
        final String[] example = {"fligh", "flow", "flower"};

        System.out.println(longestCommonPrefix(example));
    }

    public static String longestCommonPrefix(String[] strs) {
        int index = 0;
        final int limit = strs[0].length();
        while (index < limit) {
            char pref = strs[0].toCharArray()[index];
            for (final String str : strs) {
                final char[] chars = str.toCharArray();
                if (chars.length <= index || chars[index] != pref) {
                    return strs[0].substring(0, index);
                }

            }
            index++;
        }
        return strs[0];
    }

    public static String longestCommonPrefixFastest(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
