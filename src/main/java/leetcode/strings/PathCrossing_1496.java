package leetcode.strings;

import leetcode.structures.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.12.2023
 **/
public class PathCrossing_1496 {

    public static void main(String[] args) {
        isPathCrossing("ENNNNNNNNNNNEEEEEEEEEESSSSSSSSSS");
    }

    public static boolean isPathCrossing(final String path) {
        final Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        visited.add("0,0");
        final Map<Character, int[]> directions = new HashMap<>();
        directions.put('N', new int[]{0, 1});
        directions.put('S', new int[]{0, -1});
        directions.put('W', new int[]{-1, 0});
        directions.put('E', new int[]{1, 0});

        for(int i=0; i<path.length(); i++) {
            final int[] go = directions.get(path.charAt(i));
            x += go[0];
            y += go[1];
            if(!visited.add("" + x + ","+ y)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPathCrossingLC(String path) {
        final Map<Character, Pair<Integer, Integer>> moves = new HashMap();
        moves.put('N', new Pair(0, 1));
        moves.put('S', new Pair(0, -1));
        moves.put('W', new Pair(-1, 0));
        moves.put('E', new Pair(1, 0));

        Set<Pair<Integer, Integer>> visited = new HashSet();
        visited.add(new Pair(0, 0));

        int x = 0;
        int y = 0;

        for (Character c : path.toCharArray()) {
            Pair<Integer, Integer> curr = moves.get(c);
            int dx = curr.getLeft();
            int dy = curr.getRight();
            x += dx;
            y += dy;

            Pair<Integer, Integer> pair = new Pair(x, y);
            if (visited.contains(pair)) {
                return true;
            }

            visited.add(pair);
        }

        return false;
    }
}
