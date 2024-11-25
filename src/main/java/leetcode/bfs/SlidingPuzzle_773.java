package leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.11.2024
 **/
public class SlidingPuzzle_773 {

    public static void main(String[] args) {

    }

    public static int slidingPuzzle(final int[][] board) {
        final String winState = "123450";
        final StringBuilder sb = new StringBuilder();
        for(final int[] row : board) {
            for (int i =0; i<3; i++) {
                sb.append(row[i]);
            }
        }
        final Set<String> visitedStates = new HashSet<>();
        final Queue<String> possibleStates = new LinkedList<>();
        final int[][] directions = new int[][] {
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}
        };
        final String start = sb.toString();
        possibleStates.add(start);
        visitedStates.add(start);
        int count = 0;
        while (possibleStates.size() > 0) {
            int size = possibleStates.size();
            while (size-- > 0) {
                final String currState = possibleStates.poll();
                if(winState.equals(currState)) {
                    return count;
                }
                final int dirIndex = currState.indexOf('0');
                for(final int dir : directions[dirIndex]) {
                    final StringBuilder newStr = new StringBuilder(currState);
                    newStr.setCharAt(dirIndex, currState.charAt(dir));
                    newStr.setCharAt(dir, '0');
                    final String newString = newStr.toString();
                    if(visitedStates.add(newString)) {
                        possibleStates.offer(newString);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
