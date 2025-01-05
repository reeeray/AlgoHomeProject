package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.01.2025
 **/
public class ShiftingLetters2_2381 {

    public static void main(String[] args) {

    }

    public static String shiftingLetters(final String s, final int[][] shifts) {
        final int[] values = new int[s.length()];
        for(int i=0; i < s.length(); i++) {
            values[i] = s.charAt(i) - 'a';
        }
        for(final int[] shift : shifts) {
            final int dir = shift[2] == 0 ? -1 : 1;
            for(int i=shift[0]; i<=shift[1]; i++) {
                values[i] += dir;
                values[i] = values[i] == - 1 ? 25 : values[i];
            }
        }
        final StringBuilder sb = new StringBuilder();
        for(int val : values) {
            sb.append((char)('a' + val%26));
        }
        return sb.toString();
    }

    //Time O(n + m) and Space O(n)
    public String shiftingLettersAdvanced(final String s, final int[][] shifts) {
        final int n = s.length();
        final int[] diffArray = new int[n]; // Initialize a difference array with all elements set to 0.

        // Process each shift operation
        for (final int[] shift : shifts) {
            if (shift[2] == 1) { // If direction is forward (1)
                diffArray[shift[0]]++; // Increment at the start index
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]--; // Decrement at the end+1 index
                }
            } else { // If direction is backward (0)
                diffArray[shift[0]]--; // Decrement at the start index
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]++; // Increment at the end+1 index
                }
            }
        }

        final StringBuilder result = new StringBuilder(s);
        int numberOfShifts = 0;

        // Apply the shifts to the string
        for (int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + diffArray[i]) % 26; // Update cumulative shifts, keeping within the alphabet range
            if (numberOfShifts < 0) numberOfShifts += 26; // Ensure non-negative shifts

            // Calculate the new character by shifting `s[i]`
            char shiftedChar = (char) ('a' +
                    ((s.charAt(i) - 'a' + numberOfShifts) % 26));
            result.setCharAt(i, shiftedChar);
        }

        return result.toString();
    }
}
