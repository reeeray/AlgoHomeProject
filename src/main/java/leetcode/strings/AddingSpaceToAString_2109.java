package leetcode.strings;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.12.2024
 **/
public class AddingSpaceToAString_2109 {

    public static void main(String[] args) {
        System.out.println(addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
    }

    //Space O(1) and Time O(n+m) where n - number characters in the string and m - number of spaces
    public static String addSpaces(final String s, final int[] spaces) {
        final StringBuilder sb = new StringBuilder();
        sb.ensureCapacity(s.length() + spaces.length);
        //Arrays.sort(spaces);
        sb.append(s, 0, spaces[0]);
        for(int i=1; i<spaces.length; i++) {
            sb.append(" ");
            sb.append(s, spaces[i - 1], spaces[i]);
        }
        sb.append(" ");
        sb.append(s, spaces[spaces.length - 1], s.length());
        return sb.toString();
    }

    public String addSpacesTwoPointer(final String s, final int[] spaces) {
        final StringBuilder result = new StringBuilder();
        // Pre-allocate space for efficiency
        result.ensureCapacity(s.length() + spaces.length);

        int spaceIndex = 0;
        for (int stringIndex = 0; stringIndex < s.length(); ++stringIndex) {
            if (
                    spaceIndex < spaces.length && stringIndex == spaces[spaceIndex]
            ) {
                // Insert space at the correct position
                result.append(' ');
                ++spaceIndex;
            }
            // Append the current character
            result.append(s.charAt(stringIndex));
        }

        return result.toString();
    }
}
