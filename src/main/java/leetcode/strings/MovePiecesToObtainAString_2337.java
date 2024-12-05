package leetcode.strings;


import leetcode.structures.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.12.2024
 **/
public class MovePiecesToObtainAString_2337 {

    public static void main(String[] args) {

    }

    //Queue solution-non optimized. Time O(n) and Space O(n)
    public boolean canChangeNonOptimized(String start, String target) {
        // Queue to store characters and indices from both strings
        final Queue<Pair<Character, Integer>> startQueue =
                new LinkedList<>(), targetQueue = new LinkedList<>();

        // Record non-underscore characters and their indices
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != '_') {
                startQueue.add(new Pair<>(start.charAt(i), i));
            }
            if (target.charAt(i) != '_') {
                targetQueue.add(new Pair<>(target.charAt(i), i));
            }
        }

        // If number of pieces don't match, return false
        if (startQueue.size() != targetQueue.size()) return false;

        // Compare each piece's type and position
        while (!startQueue.isEmpty()) {
            Pair<Character, Integer> startPair = startQueue.poll();
            Pair<Character, Integer> targetPair = targetQueue.poll();

            char startChar = startPair.getLeft();
            int startIndex = startPair.getRight();
            char targetChar = targetPair.getLeft();
            int targetIndex = targetPair.getRight();

            // Check character match and movement rules
            if (
                    startChar != targetChar ||
                            (startChar == 'L' && startIndex < targetIndex) ||
                            (startChar == 'R' && startIndex > targetIndex)
            ) {
                return false;
            }
        }

        return true;
    }

    //Space O(1) and Time O(n)
    public static boolean canChangeMine(final String start, final String target) {
        int startIdx = 0, targetIdx = 0;
        while( startIdx < start.length() || targetIdx < start.length()) {
            while(startIdx < start.length() && start.charAt(startIdx) == '_'){
                startIdx++;
            }
            while(targetIdx < start.length() && target.charAt(targetIdx) == '_') {
                targetIdx++;
            }

            if(startIdx == start.length() || targetIdx == start.length()) {
                return startIdx == targetIdx;
            }

            if (start.charAt(startIdx) != target.charAt(targetIdx) ||
                    (start.charAt(startIdx) == 'L' && targetIdx > startIdx) ||
                    (start.charAt(startIdx) == 'R' && targetIdx < startIdx)) {
                return false;
            }
            startIdx++;
            targetIdx++;
        }
        return true;
    }

        public boolean canChange(String start, String target) {
            int startLength = start.length();
            // Pointers for start string and target string
            int startIndex = 0, targetIndex = 0;

            while (startIndex < startLength || targetIndex < startLength) {
                // Skip underscores in start
                while (
                        startIndex < startLength && start.charAt(startIndex) == '_'
                ) {
                    startIndex++;
                }
                // Skip underscores in target
                while (
                        targetIndex < startLength && target.charAt(targetIndex) == '_'
                ) {
                    targetIndex++;
                }
                // If one string is exhausted, both should be exhausted
                if (startIndex == startLength || targetIndex == startLength) {
                    return startIndex == targetIndex;
                }

                // Check if the pieces match and follow movement rules
                if (
                        start.charAt(startIndex) != target.charAt(targetIndex) ||
                                (start.charAt(startIndex) == 'L' && startIndex < targetIndex) ||
                                (start.charAt(startIndex) == 'R' && startIndex > targetIndex)
                ) return false;

                startIndex++;
                targetIndex++;
            }

            // If all conditions are satisfied, return true
            return true;
        }

}
