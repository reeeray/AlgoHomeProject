package leetcode.pureLogic;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.09.2024
 **/
public class WalkingRobotSimulation_874 {


    public static void main(String[] args) {

    }


    private static final int HASH_MULTIPLIER = 60013; // Slightly larger than 2 * max coordinate value

    //Time O(n + m) where n - number of commands, m - number of obstacles, Space O(m)
    public int robotSim(final int[] commands, final int[][] obstacles) {
        // Store obstacles in an HashSet for efficient lookup
        final Set<String> obstacleSet = new HashSet<>();
        for (final int[] obstacle : obstacles) {
            obstacleSet.add("" + obstacle[0] + obstacle[1]);
        }

        // Define direction vectors: North, East, South, West
        final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int[] currentPosition = { 0, 0 };
        int maxDistanceSquared = 0;
        int currentDirection = 0; // 0: North, 1: East, 2: South, 3: West

        for (final int command : commands) {
            if (command == -1) {
                // Turn right
                currentDirection = (currentDirection + 1) % 4;
                continue;
            }
            if (command == -2) {
                // Turn left
                currentDirection = (currentDirection + 3) % 4;
                continue;
            }

            // Move forward
            final int[] direction = directions[currentDirection];
            for (int step = 0; step < command; step++) {
                int nextX = currentPosition[0] + direction[0];
                int nextY = currentPosition[1] + direction[1];
                if (obstacleSet.contains("" + nextX + nextY)) {
                    break;
                }
                currentPosition[0] = nextX;
                currentPosition[1] = nextY;
            }
            maxDistanceSquared = Math.max(maxDistanceSquared, currentPosition[0] * currentPosition[0] + currentPosition[1] * currentPosition[1]);
        }

        return maxDistanceSquared;
    }

    // Hash function to convert (x, y) coordinates to a unique integer value
    private int hashCoordinates(int x, int y) {
        return x + HASH_MULTIPLIER * y;
    }
}
