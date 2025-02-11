package leetcode.strings;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.02.2025
 **/
public class RemoveAllOccurrencesOfASubstring_1910 {

    public static void main(String[] args) {
        removeOccurrences("daabcbaabcbc", "abc");
    }

    //Time O(n + m) and Space O(n + m)
    public String removeOccurrencesKnuttMorrisPrattAlgo(String s, String part) {
        // Precompute KMP longest prefix-suffix array for the pattern
        int[] kmpLPS = computeLongestPrefixSuffix(part);

        // Using stack to track characters and support pattern matching
        Stack<Character> charStack = new Stack<>();

        // Array to store pattern matching indices during traversal
        int[] patternIndexes = new int[s.length() + 1];

        for (
                int strIndex = 0, patternIndex = 0;
                strIndex < s.length();
                strIndex++
        ) {
            char currentChar = s.charAt(strIndex);
            charStack.push(currentChar);

            if (currentChar == part.charAt(patternIndex)) {
                // Track the next pattern index when characters match
                patternIndexes[charStack.size()] = ++patternIndex;

                if (patternIndex == part.length()) {
                    // Remove entire matched pattern from stack
                    int remainingLength = part.length();
                    while (remainingLength != 0) {
                        charStack.pop();
                        remainingLength--;
                    }

                    // Restore pattern index for next potential match
                    patternIndex = charStack.isEmpty()
                            ? 0
                            : patternIndexes[charStack.size()];
                }
            } else {
                if (patternIndex != 0) {
                    // Backtrack pattern matching using KMP LPS
                    strIndex--;
                    patternIndex = kmpLPS[patternIndex - 1];
                    charStack.pop();
                } else {
                    // Reset pattern index tracking when no match is possible
                    patternIndexes[charStack.size()] = 0;
                }
            }
        }

        // Convert remaining stack characters to result string
        StringBuilder result = new StringBuilder();
        while (!charStack.isEmpty()) {
            result.append(charStack.pop());
        }

        return result.reverse().toString();
    }

    private int[] computeLongestPrefixSuffix(String pattern) {
        // Array to store the longest proper prefix which is also a suffix
        int[] lps = new int[pattern.length()];

        // Initialize tracking variables for prefix and current position
        for (int current = 1, prefixLength = 0; current < pattern.length();) {
            // If characters match, extend the prefix length
            if (pattern.charAt(current) == pattern.charAt(prefixLength)) {
                // Store the length of matching prefix
                lps[current] = ++prefixLength;
                current++;
            }
            // If characters don't match and we're not at the start of the pattern
            else if (prefixLength != 0) {
                // Backtrack to the previous longest prefix-suffix
                prefixLength = lps[prefixLength - 1];
            }
            // If no match and no prefix to backtrack
            else {
                // No prefix-suffix match found
                lps[current] = 0;
                current++;
            }
        }

        // Return the computed longest prefix-suffix array
        return lps;
    }

    //Time O(n*m) and Space O(n + m) where n is the length of s and m is length of part
    public String removeOccurrencesStack(final String s, final String part) {
        final Stack<Character> stk = new Stack<>();
        final int strLength = s.length();
        final int partLength = part.length();

        // Iterate through each character in the string
        for (int index = 0; index < strLength; index++) {
            // Push current character to stack
            stk.push(s.charAt(index));

            // If stack size is greater than or equal to the part length, check for match
            if (stk.size() >= partLength && checkMatch(stk, part, partLength)) {
                // Pop the characters matching 'part' from the stack
                for (int j = 0; j < partLength; j++) {
                    stk.pop();
                }
            }
        }

        // Convert stack to string with correct order
        final StringBuilder result = new StringBuilder();
        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }
        return result.reverse().toString();
    }

    // Helper function to check if the top of the stack matches the 'part'
    private static boolean checkMatch(final Stack<Character> stk, final String part, final int partLength) {
        final Stack<Character> temp = new Stack<>();
        temp.addAll(stk); // Copy the stack to avoid modifying the original

        // Iterate through part from right to left
        for (int partIndex = partLength - 1; partIndex >= 0; partIndex--) {
            // If current stack top doesn't match expected character
            if (temp.isEmpty() || temp.peek() != part.charAt(partIndex)) {
                return false;
            }
            temp.pop();
        }
        return true;
    }

    //Time O(n*m) and Space O(n)
    public static String removeOccurrences(final String s, final String part) {
        String str = s;
        int index = 0;
        while (index <= str.length() - part.length()) {
            if(str.substring(index, index + part.length()).equals(part)) {
                str = str.substring(0, index) + str.substring(index + part.length());
                index = Math.max(0, index - part.length());
            } else {
                index++;
            }
        }
        return str;
    }

    //Use embadded methods, Time O(n^2) and Space O(n)
    public String removeOccurrencesEmbadded(String s, String part) {
        // Continue removing occurrences of 'part' as long as it exists in 's'
        while (s.contains(part)) {
            // Find the index of the leftmost occurrence of 'part'
            int partStartIndex = s.indexOf(part);

            // Remove the substring 'part' from 's' by concatenating the segments before and after 'part'
            s =
                    s.substring(0, partStartIndex) +
                            s.substring(partStartIndex + part.length());
        }
        // Return the updated string after all occurrences are removed
        return s;
    }
}
