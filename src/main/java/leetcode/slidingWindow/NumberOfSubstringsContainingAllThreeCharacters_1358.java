package leetcode.slidingWindow;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.03.2025
 **/
public class NumberOfSubstringsContainingAllThreeCharacters_1358 {

    public static void main(String[] args) {
        numberOfSubstrings("abcabc");
    }

    //Time O(n) and Space O(1)
    public static int numberOfSubstrings(final String s) {
        int left = 0;
        int counter = 0;
        final int[] frequency = new int[3];
        for(int right = 0; right < s.length(); right++) {
            frequency[s.charAt(right) - 'a']++;
            if(frequency[0] > 0 && frequency[1] > 0 && frequency[2] > 0) {
                counter += s.length() - right;
                frequency[s.charAt(left++) - 'a']--;
                while (frequency[0] > 0 && frequency[1] > 0 && frequency[2] > 0) {
                    counter += s.length() - right;
                    frequency[s.charAt(left++) - 'a']--;
                }
            }
        }
        return counter;
    }

    //Last position tracking Time O(n) and Space O(1)
    public int numberOfSubstringsOptimized(String s) {
        final int len = s.length();
        // Track last position of a, b, c
        final int[] lastPos = { -1, -1, -1 };
        int total = 0;

        for (int pos = 0; pos < len; pos++) {
            // Update last position of current character
            lastPos[s.charAt(pos) - 'a'] = pos;

            // Add count of valid substrings ending at current position
            // If any character is missing, min will be -1
            // Else min gives leftmost required character position
            total += 1 + Math.min(lastPos[0], Math.min(lastPos[1], lastPos[2]));
        }

        return total;
    }
}
