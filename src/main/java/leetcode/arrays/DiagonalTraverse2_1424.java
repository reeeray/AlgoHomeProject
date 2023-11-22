package leetcode.arrays;

import leetcode.structures.Pair;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.11.2023
 **/
public class DiagonalTraverse2_1424 {

    public static void main(String[] args) {
        final List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1,2,3,4,5));
        input.add(Arrays.asList(6,7));
        input.add(Arrays.asList(8));
        input.add(Arrays.asList(9,10,11));
        input.add(Arrays.asList(12,13,14,15,16));
        System.out.println(Arrays.toString(findDiagonalOrder(input)));
    }

    //TLE
    public static int[] findDiagonalOrder(final List<List<Integer>> nums) {
        final List<Integer> travers = new ArrayList<>();
        int maxLength = 0;

        for(int row = 0; row < nums.size(); row++) {
            int index = 0;
            int diagRow = row;
            maxLength = Math.max(maxLength, nums.get(row).size());
            while(index <= row && diagRow >= 0) {
                final List<Integer> r = nums.get(diagRow);
                if(r.size() > index) {
                    travers.add(r.get(index));
                }
                diagRow--;
                index++;
            }
        }

        for(int index = 1; index < maxLength; index++) {
            int elemnt = index;
            for(int j = nums.size()-1; j >=0; j--) {
                final List<Integer> diagRow = nums.get(j);
                if(diagRow.size() > elemnt) {
                    travers.add(diagRow.get(elemnt));
                }
                elemnt++;
            }
        }

        return travers.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] findDiagramOrder(final List<List<Integer>> nums) {
        final Queue<Pair<Integer, Integer>> queue = new LinkedList();
        queue.offer(new Pair(0, 0));
        final List<Integer> travers = new ArrayList();

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getLeft();
            int col = p.getRight();
            travers.add(nums.get(row).get(col));

            if (col == 0 && row + 1 < nums.size()) {
                queue.offer(new Pair(row + 1, col));
            }

            if (col + 1 < nums.get(row).size()) {
                queue.offer(new Pair(row, col + 1));
            }
        }
        return travers.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] findDiagonalOrderByGrouping(final List<List<Integer>> nums) {
        Map<Integer, List<Integer>> groups = new HashMap();
        int n = 0;
        for (int row = nums.size() - 1; row >= 0; row--) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                int diagonal = row + col;
                if (!groups.containsKey(diagonal)) {
                    groups.put(diagonal, new ArrayList<Integer>());
                }

                groups.get(diagonal).add(nums.get(row).get(col));
                n++;
            }
        }

        int[] ans = new int[n];
        int i = 0;
        int curr = 0;

        while (groups.containsKey(curr)) {
            for (int num : groups.get(curr)) {
                ans[i] = num;
                i++;
            }

            curr++;
        }

        return ans;
    }
}
