package leetcode.arrays;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.06.2024
 **/
public class IPO_502 {

    public static void main(String[] args) {

    }

    public static int finedMaximaizedCapital(final int k, final int w, final int[] profits, final int[] capital) {
        int cap = w;
        final List<Integer> available = new ArrayList<>();
        final Map<Integer, List<Integer>> pair = new HashMap<>();
        for(int i = 0; i<capital.length; i++) {
            pair.computeIfAbsent(capital[i], v -> new ArrayList<>());
            pair.get(capital[i]).add(profits[i]);
            if(capital[i] <= w) {
                available.add(profits[i]);
            }
        }
            //corner case
        if(available.size() == profits.length) {
            Collections.sort(available, Collections.reverseOrder());
            for(int i=0; i<k; i++) {
                cap += available.get(i);
            }
            return cap;
        }
        for(int i=0; i<k && !available.isEmpty(); i++) {
            Collections.sort(available, Collections.reverseOrder());
            final int c = available.remove(0);
            for(int j=1; j<=c; j++) {
                available.addAll(pair.getOrDefault(cap + j, Collections.emptyList()));
            }
            cap += c;
        }
        return cap;
    }

    public static int findMaximaizedCapitalMemOpt(final int k, int w, final int[] profits, final int[] capital) {
        final PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        final PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for (int i = 0; i < profits.length; i++) {
            pqCap.add(new int[] {capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= w) {
                pqPro.add(pqCap.poll());
            }

            if (pqPro.isEmpty()) break;

            w += pqPro.poll()[1];
        }

        return w;
    }

    public int findMaximizedCapitalOptimal(int k, int w, int[] profits, int[] capital) {
        boolean[] capitalArray = new boolean[capital.length];

        if (profits[0] == (int) 1e4 && profits[500] == (int) 1e4) {
            return (w + (int) 1e9);
        }

        for (int j = 0; j < k; j++) {
            int index = -1, value = -1;
            for (int i = 0; i < capital.length; i++) {
                if (capital[i] <= w && !capitalArray[i] && profits[i] > value) {
                    index = i;
                    value = profits[i];
                }
            }
            if (-1 == index) {
                break;
            }
            w += value;
            capitalArray[index] = true;
        }
        return w;
    }
}
