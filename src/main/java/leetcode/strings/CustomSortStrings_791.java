package leetcode.strings;

/**
 * 791. Custom Sort String.
 * <p>
 * order and str are strings composed of lowercase letters. In order, no letter occurs more than once.
 * <p>
 * order was sorted in some custom order previously. We want to permute the characters of str so that they match the order that order was sorted. More specifically, if x occurs before y in order, then x should occur before y in the returned string.
 * <p>
 * Return any permutation of str (as a string) that satisfies this property.
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 14.07.2021
 **/
public class CustomSortStrings_791 {

    public static void main(String[] args) {
        final String actual = customSortString("cba", "abcd");
        final String expected = "cbad";
        assert expected.equals(actual);

    }

    public static String customSortString(final String order, final String str) {
        final int[] prior = new int[26];
        for (int i = 0; i < order.length(); i++) {
            prior[order.charAt(i) - 'a'] = i + 1;
        }
        final String[] res = new String[26];
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            final int p = prior[c - 'a'];
            if (prior[c - 'a'] > 0) {
                res[p] = res[p] == null ? "" + c : res[p] + c;
            } else {
                sb.append(c);
            }
        }
        final StringBuilder answ = new StringBuilder();
        for (String s : res) {
            if (s != null)
                answ.append(s);
        }
        answ.append(sb.toString());
        return answ.toString();
    }
}
