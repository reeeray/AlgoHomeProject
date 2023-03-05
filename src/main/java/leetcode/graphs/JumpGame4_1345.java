package leetcode.graphs;

import java.util.*;
import java.util.function.BinaryOperator;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.03.2023
 **/
public class JumpGame4_1345 {

    public static void main(String[] args) {
        final int[] input = {68,-94,-44,-18,-1,18,-87,29,-6,-87,-27,37,-57,7,18,68,-59,29,7,53,-27,-59,18,-1,18,-18,-59,-1,-18,-84,-20,7,7,-87,-18,-84,-20,-27};
        minJumps(input);
    }

    private static int minJumps(final int[] arr) {
        final boolean[] visited = new boolean[arr.length];
        final Map<Integer, List<Integer>> jumps = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            jumps.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        return dfs(arr, jumps, visited, 0, 0);
    }

    private static int dfs(final int[] arr, final Map<Integer, List<Integer>> jumps, final boolean[] visited, final int length, final int position) {
        if(position >= arr.length || position < 0 || visited[position]) {
            return Integer.MAX_VALUE;
        }
        if(position == arr.length-1) {
            return length;
        }
        visited[position] = true;
        int answer = Integer.MAX_VALUE;
        for(final Integer jump : jumps.get(arr[position])) {
            if(jump == position) continue;
            final int jmp = dfs(arr, jumps, visited, length+1, jump);
            answer = Math.min(jmp, answer);
        }
        final int forward = dfs(arr, jumps, visited, length+1, position+1);
        answer = Math.min(forward, answer);
        final int back = dfs(arr, jumps, visited, length+1, position-1);
        answer = Math.min(back, answer);
        visited[position] = false;
        return answer;
    }

    private static int minJumpsBFS(final int[] arr) {
        final Map<Integer, List<Integer>> jumps = new HashMap<>();
        final boolean[] visited = new boolean[arr.length];
        final Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<arr.length; i++) {
            jumps.computeIfAbsent(arr[i], v-> new ArrayList<>()).add(i);
        }
        queue.offer(0);
        visited[0] = true;
        int steps = -1;
        while(!queue.isEmpty()) {
            int sizeOfTheLevel = queue.size();
            steps++;
            while(sizeOfTheLevel-- > 0) {
                final int position = queue.poll();
                if(position == arr.length -1) {
                    return steps;
                }
                final List<Integer> possibleJumps = jumps.get(arr[position]);
                if(position + 1 < arr.length) {
                    possibleJumps.add(position + 1);
                }
                if(position - 1 >= 0) {
                    possibleJumps.add(position - 1);
                }
                for(int pos : possibleJumps) {
                    // we don't want to check the already visited indices again!
                    if(!visited[pos]) {
                        visited[pos] = true;
                        queue.offer(pos);
                    }
                }
                // avoid later lookup sameValueIndicesMap arr[i]
                jumps.get(arr[position]).clear();
            }
        }
        return 0;
    }
}
