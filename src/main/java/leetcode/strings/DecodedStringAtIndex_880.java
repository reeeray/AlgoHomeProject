package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.09.2023
 **/
public class DecodedStringAtIndex_880 {

    public static void main(String[] args) {

    }

    public static String decodedAtIndex(final String s, int k) {
        long decodedLength = 0; // Total length of the decoded string

        for (char character : s.toCharArray()) {
            if (Character.isDigit(character)) {
                // If the character is a digit, update the decoded length accordingly
                decodedLength *= (character - '0');
            } else {
                // If the character is a letter, increment the decoded length
                decodedLength++;
            }
        }

        // Traverse the input string in reverse to decode and find the kth character
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                // If the character is a digit, adjust the length and k accordingly
                decodedLength /= (currentChar - '0');
                k %= decodedLength;
            } else {
                // If the character is a letter, check if it's the kth character
                if (k == 0 || decodedLength == k) {
                    return String.valueOf(currentChar); // Return the kth character as a string
                }
                decodedLength--;
            }
        }

        return ""; // Return an empty string if no character is found
    }
}
