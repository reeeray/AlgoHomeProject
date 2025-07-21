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

    //Time O(n) and Space O(n)
    private static String makeFancyStringLatest(final String s) {
        char prev = s.charAt(0);
        int count = 1;
        final StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++) {
            if(count <= 2) {
                sb.append(prev);
            }
            if(prev == s.charAt(i)) {
                count++;
            } else {
                prev = s.charAt(i);
                count = 1;

            }
        }
        return count <= 2 ? sb.append(prev).toString() : sb.toString();
    }

    //Time O(n) and Space O(1) in place with two pointers
    public String makeFancyStringTwoPointers(String s) {
        // If the size of the string is less than 3, return it.
        if (s.length() < 3) {
            return s;
        }

        final StringBuilder sb = new StringBuilder();
        // Start by appending the first two characters to StringBuilder.
        sb.append(s.charAt(0)).append(s.charAt(1));

        // Iterate from the 3rd character onwards.
        for (int i = 2; i < s.length(); ++i) {
            // If the current character is not equal to the previously inserted
            // two characters, then we can add it to the StringBuilder.
            if (
                    s.charAt(i) != sb.charAt(sb.length() - 1) ||
                            s.charAt(i) != sb.charAt(sb.length() - 2)
            ) {
                sb.append(s.charAt(i));
            }
        }

        // Convert StringBuilder back to String and return.
        return sb.toString();
    }
}
