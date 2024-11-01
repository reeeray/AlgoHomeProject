package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.11.2024
 **/
public class DeleteCharactersToMakeFancyString_1957 {

    public static void main(String[] args) {
        makeFancyString("leeetcode");
    }

    //Time O(n) and Space O(n)
    public static String makeFancyString(final String s) {
        char prev = ' ';
        int counter = 0;
        final StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(prev == c && counter == 2) {
                continue;
            } else if (prev == c) {
                counter++;
            } else {
                counter = 1;
                prev = c;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
