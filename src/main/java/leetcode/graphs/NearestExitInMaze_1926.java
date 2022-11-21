package leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.11.2022
 **/
public class NearestExitInMaze_1926 {

    public static void main(String[] args) {
        final char[][] maze = {{'+', '.', '+', '+', '+', '+', '+'}, {'+', '.', '+', '.', '.', '.', '+'}, {'+', '.', '+', '.', '+', '.', '+'},
                {'+', '.', '.', '.', '.', '.', '+'}, {'+', '+', '+', '+', '.', '+', '.'}};
        final int[] entrance = {0, 1};
        assert 7 == nearestExitBFS(maze, entrance);

    }

    /**
     * Too slow for huge mazes
     * @param maze
     * @param entrance
     * @return
     */
    private static int nearestExit(final char[][] maze, int[] entrance) {
        int steps = 0;
//        if(entrance[0] == 0 || entrance[1] == 0) {
//            maze[entrance[0]][entrance[1]] = '+';
//        }
        int res = findExit(maze, entrance, steps);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int findExit(final char[][] maze, int[] pos, int steps) {
        if((pos[0] == 0 || pos[1] == 0 || pos[0] == maze.length-1 || pos[1] == maze[0].length-1) && steps != 0) {
            return steps;
        }

        maze[pos[0]][pos[1]] = '~';
        int res = Integer.MAX_VALUE;
        if(pos[0] + 1 < maze.length && maze[pos[0] + 1][pos[1]] == '.') {
            res = findExit(maze, new int[] {pos[0]+1, pos[1]}, steps+1);
        }
        if(pos[0] - 1 >= 0 && maze[pos[0] - 1][pos[1]] == '.') {
            res = Math.min(res, findExit(maze, new int[] {pos[0]-1, pos[1]}, steps+1));
        }

        if(pos[1] + 1 < maze[0].length && maze[pos[0]][pos[1] + 1] == '.') {
            res = Math.min(res, findExit(maze, new int[] {pos[0], pos[1] + 1}, steps+1));
        }
        if(pos[1] - 1 >= 0 && maze[pos[0]][pos[1] - 1] == '.') {
            res = Math.min(res, findExit(maze, new int[] {pos[0], pos[1]-1}, steps+1));
        }
        maze[pos[0]][pos[1]] = '.';
        return res;
    }

    private static int nearestExitBFS(final char[][] maze, final int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Mark the entrance as visited since its not a exit.
        int startRow = entrance[0], startCol = entrance[1];
        maze[startRow][startCol] = '+';

        // Start BFS from the entrance, and use a queue `queue` to store all
        // the cells to be visited.
        final Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0});

        while (!queue.isEmpty()) {
            int[] currState = queue.poll();
            int currRow = currState[0], currCol = currState[1], currDistance = currState[2];

            // For the current cell, check its four neighbor cells.
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];

                // If there exists an unvisited empty neighbor:
                if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols
                        && maze[nextRow][nextCol] == '.') {

                    // If this empty cell is an exit, return distance + 1.
                    // it will be shortest because of the queue, FIFO
                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1)
                        return currDistance + 1;

                    // Otherwise, add this cell to 'queue' and mark it as visited.
                    maze[nextRow][nextCol] = '+';
                    queue.offer(new int[]{nextRow, nextCol, currDistance + 1});
                }
            }
        }

        // If we finish iterating without finding an exit, return -1.
        return -1;
    }


}
