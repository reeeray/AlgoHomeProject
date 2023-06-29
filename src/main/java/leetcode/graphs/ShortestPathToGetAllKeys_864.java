package leetcode.graphs;

import leetcode.structures.Pair;
import patterns.creational.abstractFactory.VisaFactory;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.06.2023
 **/
public class ShortestPathToGetAllKeys_864 {

    public static void main(String[] args) {

    }

    /**
     * Time and Space complexity is O(m*n*2^k)
     * k - number of keys
     * @param grid
     * @return
     */
    public static int shortestPathAllKeys(final String[] grid) {
        final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        final Queue<int[]> queue = new LinkedList<>();
        final int m = grid.length, n = grid[0].length();
        // visited['key'] is only for BFS with key state equals 'keys'
        final Map<Integer, Set<Pair<Integer, Integer>>> visited = new HashMap<>();

        final Set<Character> keySet = new HashSet<>();
        final Set<Character> lockSet = new HashSet<>();
        int allKeys = 0;
        int row = -1, col = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cell = grid[i].charAt(j);
                if (cell >= 'a' && cell <= 'f') {
                    allKeys += (1 << (cell - 'a'));
                    keySet.add(cell);
                }
                if (cell >= 'A' && cell <= 'F') {
                    lockSet.add(cell);
                }
                if (cell == '@') {
                    row = i;
                    col = j;
                }
            }
        }

        // [row, column, key state, distance]
        queue.offer(new int[] {row, col, 0, 0});
        visited.put(0, new HashSet<>());
        visited.get(0).add(new Pair<>(row, col));

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], keys = cur[2], dist = cur[3];
            for (int[] d : directions) {
                int nextX =  x + d[0], nextY = y + d[1];

                // If this cell (nextX, nextY) is reachable.
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX].charAt(nextY) != '#') {
                    char cell = grid[nextX].charAt(nextY);

                    // If it is a key:
                    if (keySet.contains(cell)) {
                        // If we have collected it before, no need to revisit this cell.
                        if (((1 << (cell - 'a')) & keys) != 0) {
                            continue;
                        }

                        // Otherwise, we can walk to this cell and pick it up.
                        //When we collect a new key, we can update keys by setting the corresponding bit to 1. For example, if we pick up the key b, we can update keys as follows: keys = keys | (1 << (ord('b') - ord('a'))) Here ord represents the integer representation of the character, we subtract with ord('a') to make it 0-indexed.
                        //
                        //For instance, suppose that our previous key-holding state is keys=6=1102\text{keys} = 6 = {110}_2keys=6=110
                        //2
                        //​
                        // . By picking up the key a, we can update keys as keys=1102∣12=1112=7\text{keys} = {110}_2 | 1_2 = 111_2 = 7keys=110
                        //2
                        //​
                        // ∣1
                        //2
                        //​
                        // =111
                        //2
                        //​
                        // =7. This operation sets the 0th0^{th}0
                        //th
                        //  bit to 1, which represents the key for the letter a.
                        int newKeys = (keys | (1 << (cell - 'a')));

                        // If we collect all keys, return dist + 1.
                        // Otherwise, just add this state to seen and queue.
                        if (newKeys == allKeys) {
                            return dist + 1;
                        }
                        visited.putIfAbsent(newKeys, new HashSet<>());
                        visited.get(newKeys).add(new Pair<>(nextX, nextY));
                        queue.offer(new int[] {nextX, nextY, newKeys, dist + 1});
                    }

                    // If it is a lock and we don't have its key, continue.
                    if (lockSet.contains(cell) && ((keys & (1 << (cell - 'A'))) == 0)) {
                        continue;
                    }

                    // We can walk to this cell if we haven't been here before with the same key state.
                    else if (!visited.get(keys).contains(new Pair<>(nextX, nextY))) {
                        visited.get(keys).add(new Pair<>(nextX, nextY));
                        queue.offer(new int[] {nextX, nextY, keys, dist + 1});
                    }
                }
            }
        }


        return -1;
    }
}
