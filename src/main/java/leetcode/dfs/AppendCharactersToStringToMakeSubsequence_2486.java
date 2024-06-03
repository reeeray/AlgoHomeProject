package leetcode.dfs;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.06.2024
 **/
public class AppendCharactersToStringToMakeSubsequence_2486 {

    static int max = 0;

    public static void main(String[] args) {
        appendCharacters("coaching", "coding");
    }

    public static int appendCharacters(final String s, final String t) {
        int indexT = 0;
        for(final char c : s.toCharArray()) {
            if(c == t.charAt(indexT)) {
                indexT++;
            }
            if(indexT == t.length()) {
                return 0;
            }
        }
        return t.length() - indexT;
    }
}
