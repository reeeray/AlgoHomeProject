package leetcode.structures;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.07.2024
 **/
public class MaxScoreFromRemovingSubstr_1717 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        final String highPriorityPair = x > y ? "ab" : "ba";
        final String lowPriorityPair = y > x ? "ab" : "ba";

        // First pass: remove high priority pair
        final String stringAfterFirstPass = removeSubstring(s, highPriorityPair);
        int removedPairsCount =
                (s.length() - stringAfterFirstPass.length()) / 2;

        // Calculate score from first pass
        totalScore += removedPairsCount * Math.max(x, y);

        // Second pass: remove low priority pair
        final String stringAfterSecondPass = removeSubstring(stringAfterFirstPass, lowPriorityPair);
        removedPairsCount =
                (stringAfterFirstPass.length() - stringAfterSecondPass.length()) / 2;

        // Calculate score from second pass
        totalScore += removedPairsCount * Math.min(x, y);

        return totalScore;
    }

    private String removeSubstring(String input, String targetPair) {
        final Stack<Character> charStack = new Stack<>();
        // Iterate through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Check if current character forms the target pair with the top of the stack
            if (currentChar == targetPair.charAt(1) &&
                            !charStack.isEmpty() &&
                            charStack.peek() == targetPair.charAt(0) ) {
                charStack.pop(); // Remove the matching character from the stack
            } else {
                charStack.push(currentChar);
            }
        }

        // Reconstruct the remaining string after removing target pairs
        final StringBuilder remainingChars = new StringBuilder();
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop());
        }
        return remainingChars.reverse().toString();
    }

    //Greedy way counting
    public int maximumGainOptimized(String s, int x, int y) {
        // Ensure "ab" always has higher points than "ba"
        if (x < y) {
            // Swap points
            int temp = x;
            x = y;
            y = temp;
            // Reverse the string to maintain logic
            s = new StringBuilder(s).reverse().toString();
        }

        int aCount = 0, bCount = 0, totalPoints = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'a') {
                aCount++;
            } else if (currentChar == 'b') {
                if (aCount > 0) {
                    // Can form "ab", remove it and add points
                    aCount--;
                    totalPoints += x;
                } else {
                    // Can't form "ab", keep 'b' for potential future 'ba'
                    bCount++;
                }
            } else {
                // Non 'a' or 'b' character encountered
                // Calculate points for any remaining 'ba' pairs
                totalPoints += Math.min(bCount, aCount) * y;
                // Reset counters for next segment
                aCount = bCount = 0;
            }
        }

        // Calculate points for any remaining "ba" pairs at the end
        totalPoints += Math.min(bCount, aCount) * y;

        return totalPoints;
    }
}
