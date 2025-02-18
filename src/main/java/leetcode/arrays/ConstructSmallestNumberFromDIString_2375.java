package leetcode.arrays;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.02.2025
 **/
public class ConstructSmallestNumberFromDIString_2375 {

    public static void main(String[] args) {

    }

    public static String smallestNumber(final String pattern) {
        final boolean[] visited = new boolean[9];
        final StringBuilder sb = new StringBuilder();
        return dfs(pattern, 0, sb, visited);
    }

    private static String dfs(final String pattern, final int index, final StringBuilder val, final boolean[] visited) {

        for(int i = 1; i < 10; i++) {
            if(visited[i - 1]) {
                continue;
            }
            if(index > 0 && (pattern.charAt(i - 1) == 'I' && i < Integer.valueOf(val.charAt(val.length())) || i > Integer.valueOf(val.charAt(val.length())) )) {
                continue;
            }
            visited[i] = true;
            val.append(i);
            final String num = dfs(pattern, i + 1, val, visited);
            if(num != null) {
                return num;
            }
            visited[i] = false;
            val.deleteCharAt(val.length());
        }
        return null;
    }

    //Time O(n) and Space O(n)
    public static String smallestNumberGenious(String pattern) {
        final StringBuilder result = new StringBuilder();
        final Stack<Integer> numStack = new Stack<>();

        // Iterate through the pattern
        for (int index = 0; index <= pattern.length(); index++) {
            // Push the next number onto the stack
            numStack.push(index + 1);

            // If 'I' is encountered or we reach the end, pop all stack elements
            if (index == pattern.length() || pattern.charAt(index) == 'I') {
                while (!numStack.isEmpty()) {
                    result.append(numStack.pop());
                }
            }
        }

        return result.toString();
    }

    //Time O(n) and Space O(n)
    public String smallestNumberRecursion(String pattern) {
        StringBuilder result = new StringBuilder();

        // Start building the sequence by calling the helper function
        buildSequence(0, 0, pattern.toCharArray(), result);
        // Reverse the final result
        return result.reverse().toString();
    }

    // Recursively build the sequence
    int buildSequence(
            int currentIndex,
            int currentCount,
            char[] patternArray,
            StringBuilder result
    ) {
        if (currentIndex != patternArray.length) {
            if (patternArray[currentIndex] == 'I') buildSequence(
                    // If 'I', increment the count and move to the next index
                    currentIndex + 1,
                    currentIndex + 1,
                    patternArray,
                    result
            );
            else currentCount = buildSequence(
                    // If 'D', keep the count and move to the next index
                    currentIndex + 1,
                    currentCount,
                    patternArray,
                    result
            );
        }

        result.append(currentCount + 1);
        // Return the next count for the sequence
        return currentCount + 1;
    }

    //Time O(n^2) and Space O(n). Can be optimized
    public String smallestNumberSliwingWindow(String pattern) {
        StringBuilder result = new StringBuilder();

        // Iterate through the pattern and build the result
        for (
                int currentIndex = 0, previousIndex = 0;
                currentIndex <= pattern.length();
                ++currentIndex
        ) {
            result.append(1 + currentIndex);

            // Reverse the substring starting from previousIndex when necessary
            if (
                    currentIndex == pattern.length() ||
                            pattern.charAt(currentIndex) == 'I'
            ) {
                final StringBuilder temp = new StringBuilder();
                temp
                        .append(result.substring(0, previousIndex))
                        .append(
                                new StringBuilder(
                                        result.substring(previousIndex)
                                ).reverse()
                        );
                result = temp;
                previousIndex = currentIndex + 1;
            }
        }

        // Return the final result as a string
        return result.toString();
    }
}
