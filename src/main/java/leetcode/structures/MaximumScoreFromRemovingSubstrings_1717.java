package leetcode.structures;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.07.2025
 **/
public class MaximumScoreFromRemovingSubstrings_1717 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n) p.s. in C++ reverse() takes constant space
    public static int maxGain(String s, int x, int y) {
        if(x < y) {
            final int temp = x;
            x = y;
            y = temp;
            s = new StringBuffer(s).reverse().toString();
        }

        int aCount = 0, bCount = 0, totalPoints = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                aCount++;
            } else if(s.charAt(i) == 'b'){
                 if (aCount > 0){
                     aCount--;
                    totalPoints += x;
                } else {
                     bCount++;
                 }
            } else {
                totalPoints += Math.min(aCount, bCount) * y;
                aCount = bCount = 0;
            }
        }
        totalPoints += Math.min(aCount, bCount) * y;
        return totalPoints;
    }

    //Time O(n) and Space O(n) p.s. in C++ strings are mutable
    public int maximumGain(String s, int x, int y) {
        final StringBuilder text = new StringBuilder(s);
        int totalPoints = 0;

        if (x > y) {
            // Remove "ab" first (higher points), then "ba"
            totalPoints += removeSubstring(text, "ab", x);
            totalPoints += removeSubstring(text, "ba", y);
        } else {
            // Remove "ba" first (higher or equal points), then "ab"
            totalPoints += removeSubstring(text, "ba", y);
            totalPoints += removeSubstring(text, "ab", x);
        }

        return totalPoints;
    }


    private int removeSubstring(final StringBuilder inputString, final String targetSubstring,
            int pointsPerRemoval) {
        int totalPoints = 0;
        int writeIndex = 0;

        // Iterate through the string
        for (int readIndex = 0; readIndex < inputString.length(); readIndex++) {
            // Add the current character
            inputString.setCharAt(writeIndex++, inputString.charAt(readIndex));

            // Check if we've written at least two characters and
            // they match the target substring
            if (writeIndex > 1 && inputString.charAt(writeIndex - 2) == targetSubstring.charAt(0) &&
                            inputString.charAt(writeIndex - 1) == targetSubstring.charAt(1)) {
                writeIndex -= 2; // Move write index back to remove the match
                totalPoints += pointsPerRemoval;
            }
        }

        // Trim the StringBuilder to remove any leftover characters
        inputString.setLength(writeIndex);

        return totalPoints;
    }

    public int maximumGainMoreCode(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = highPriorityPair.equals("ab") ? "ba" : "ab";

        // First pass: remove high priority pair
        String stringAfterFirstPass = removeSubstring(s, highPriorityPair);
        int removedPairsCount =
                (s.length() - stringAfterFirstPass.length()) / 2;

        // Calculate score from first pass
        totalScore += removedPairsCount * Math.max(x, y);

        // Second pass: remove low priority pair
        String stringAfterSecondPass = removeSubstring(
                stringAfterFirstPass,
                lowPriorityPair
        );
        removedPairsCount = (stringAfterFirstPass.length() -
                stringAfterSecondPass.length()) /
                2;

        // Calculate score from second pass
        totalScore += removedPairsCount * Math.min(x, y);

        return totalScore;
    }

    private String removeSubstring(String input, String targetPair) {
        Stack<Character> charStack = new Stack<>();

        // Iterate through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Check if current character forms the target pair with the top of the stack
            if (
                    currentChar == targetPair.charAt(1) &&
                            !charStack.isEmpty() &&
                            charStack.peek() == targetPair.charAt(0)
            ) {
                charStack.pop(); // Remove the matching character from the stack
            } else {
                charStack.push(currentChar);
            }
        }

        // Reconstruct the remaining string after removing target pairs
        StringBuilder remainingChars = new StringBuilder();
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop());
        }
        return remainingChars.reverse().toString();
    }
}
