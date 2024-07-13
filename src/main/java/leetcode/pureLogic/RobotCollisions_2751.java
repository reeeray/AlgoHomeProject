package leetcode.pureLogic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.07.2024
 **/
public class RobotCollisions_2751 {


    public static List<Integer> survivedRobotsHealts(final int[] positions, final int[] healths, final String direction) {
        final List<Robot> robots = new ArrayList<>();
        for(int i=0; i<positions.length; i++) {
            robots.add(new Robot(healths[i], direction.charAt(i) == 'L' ? 0 : 1, positions[i]));
        }

        while(!robotsSafe(robots)) {

        }

        return robots.stream().map(r -> r.health).collect(Collectors.toList());
    }

    private static boolean robotsSafe(final List<Robot> robots) {
        int minR = Integer.MAX_VALUE;
        int maxL = Integer.MIN_VALUE;
        for(final Robot robot : robots) {
            if(robot.direction == 0) {
                maxL = Math.max(maxL, robot.position);
            } else {
                minR = Math.max(minR, robot.position);
            }
        }

        return minR > maxL;
    }



    private static class Robot {
        public int health;
        public int direction;
        public int position;

        public Robot(final int health, final int direction, final int position) {
            this.direction = direction;
            this.health = health;
            this.position = position;
        }
    }

    //Time O(n logn) Space O(n)
    public List<Integer> survivedRobotsHealthsOptimized(final int[] positions, final int[] healths, final String directions) {
        final int n = positions.length;
        final Integer[] indices = new Integer[n];
        final List<Integer> result = new ArrayList<>();
        final Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < n; ++index) {
            indices[index] = index;
        }

        Arrays.sort(indices, Comparator.comparingInt(lhs -> positions[lhs]));

        for (int currentIndex : indices) {
            // Add right-moving robots to the stack
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    // Pop the top robot from the stack for collision check
                    int topIndex = stack.pop();

                    // Top robot survives, current robot is destroyed
                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        // Current robot survives, top robot is destroyed
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        // Both robots are destroyed
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        // Collect surviving robots
        for (int index = 0; index < n; ++index) {
            if (healths[index] > 0) {
                result.add(healths[index]);
            }
        }
        return result;
    }
}
