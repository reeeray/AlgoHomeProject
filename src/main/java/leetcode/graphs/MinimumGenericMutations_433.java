package leetcode.graphs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.11.2022
 **/
public class MinimumGenericMutations_433 {


    public static void main(String[] args) {
        final String start = "AACCGGTT";
        final String end = "AAACGGTA";
        final String[] bank = {"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"};

        System.out.println(minMutation(start, end, bank));
    }

    private static int minMutation(String start, final String end, final String[] bank) {
        final List<String> strings = Arrays.asList(bank);

        return dbs(start, end, strings, 0);
    }

    private static int dbs(String start, final String end, final List<String> bank, final int count) {
        if(start.equals(end)) {
            return count;
        }
        int tempCount = count;

        for(int i=0; i<8; i++) {
            if(start.charAt(i) == end.charAt(i)) {
                continue;
            } else {
                final String temp = start.substring(0, i) + end.charAt(i) + start.substring(i+1);
                if(bank.contains(temp)) {
                    int res = dbs(temp, end, bank, count + 1);
                    tempCount = res == -1 ? tempCount : Math.max(tempCount, res);
                }
            }
        }
        return tempCount == count ? -1 : tempCount;

    }

    /**
     * This issues requires BFS instead of DFS, misunderstood description of the problem.
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutationLeetcodeSolution(String start, String end, String[] bank) {
        final Queue<String> queue = new LinkedList<>();
        final Set<String> seen = new HashSet<>();
        queue.add(start);
        seen.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {
            int nodesInQueue = queue.size();
            for (int j = 0; j < nodesInQueue; j++) {
                String node = queue.remove();
                if (node.equals(end)) {
                    return steps;
                }

                for (char c: new char[] {'A', 'C', 'G', 'T'}) {
                    for (int i = 0; i < node.length(); i++) {
                        String neighbor = node.substring(0, i) + c + node.substring(i + 1);
                        if (!seen.contains(neighbor) && Arrays.asList(bank).contains(neighbor)) {
                            queue.add(neighbor);
                            seen.add(neighbor);
                        }
                    }
                }
            }

            steps++;
        }

        return -1;

    }

}
