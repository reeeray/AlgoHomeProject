package leetcode.slidingWindow;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.03.2025
 **/
public class AlternatingGroups2_3208 {

    public static void main(String[] args) {

    }

    //Time O(n + k) and Space O(k)
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] extendedColors = new int[colors.length + k - 1];
        // Extend the array to handle circular sequences
        for (int i = 0; i < colors.length; i++) {
            extendedColors[i] = colors[i];
        }
        for (int i = 0; i < k - 1; i++) {
            extendedColors[colors.length + i] = colors[i];
        }

        int length = extendedColors.length;
        int result = 0;
        // Initialize the bounds of the sliding window
        int left = 0;
        int right = 1;

        while (right < length) {
            // Check if the current color is the same as the last one
            if (extendedColors[right] == extendedColors[right - 1]) {
                // Pattern breaks, reset window from the current position
                left = right;
                right++;
                continue;
            }

            // Expand the window to the right
            right++;

            // Skip counting sequence if its length is less than k
            if (right - left < k) continue;

            // Record a valid sequence and shrink window from the left to search for more
            result++;
            left++;
        }

        return result;
    }

    //Time O(n + k) and Space O(1)
    public int numberOfAlternatingGroupsOpt(int[] colors, int k) {
        int length = colors.length;
        int result = 0;
        // Tracks the length of the current alternating sequence
        int alternatingElementsCount = 1;
        int lastColor = colors[0];

        for (int index = 1; index < length; index++) {
            // Check if the current color is the same as the last one
            if (colors[index] == lastColor) {
                // Pattern breaks, reset sequence length
                alternatingElementsCount = 1;
                lastColor = colors[index];
                continue;
            }
            // Sequence can be extended
            alternatingElementsCount++;

            // Record a new alternating sequence
            if (alternatingElementsCount >= k) {
                result++;
            }

            lastColor = colors[index];
        }

        // Wrap around to the first k - 1 elements
        for (int index = 0; index < k - 1; index++) {
            // Pattern breaks. Since there are less than k elements remaining,
            // no more sequences can be formed
            if (colors[index] == lastColor) break;

            // Extend the pattern
            alternatingElementsCount++;

            // Record a new alternating sequence
            if (alternatingElementsCount >= k) {
                result++;
            }

            lastColor = colors[index];
        }
        return result;
    }

    //Time O(n + k) and Space O(1)
    public int numberOfAlternatingGroupsOnePass(int[] colors, int k) {
        int length = colors.length;
        int result = 0;
        // Length of current alternating sequence
        int alternatingElementsCount = 1;
        int lastColor = colors[0];

        // Loop through array with circular traversal
        for (int i = 1; i < length + k - 1; i++) {
            int index = i % length; // Wrap around using modulo

            // Check if current color is the same as last color
            if (colors[index] == lastColor) {
                // Pattern breaks, reset sequence length
                alternatingElementsCount = 1;
                lastColor = colors[index];
                continue;
            }

            // Extend alternating sequence
            alternatingElementsCount += 1;

            // If sequence length reaches at least k, count it
            if (alternatingElementsCount >= k) {
                result++;
            }

            lastColor = colors[index];
        }

        return result;
    }
}
