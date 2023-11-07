package leetcode.pureLogic;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.11.2023
 **/
public class EliminateMaxNumberOfMonsters_1921 {

    public static void main(String[] args) {
        assert 7 == eliminateMaximum(new int[] {46,33,44,42,46,36,7,36,31,47,38,42,43,48,48,25,28,44,49,47,29,32,30,6,42,9,39,48,22,26,50,34,40,22,10,45,7,43,24,18,40,44,17,39,36},
                new int[] {1,2,1,3,1,1,1,1,1,1,1,1,1,1,7,1,1,3,2,2,2,1,2,1,1,1,1,1,1,1,1,6,1,1,1,8,1,1,1,3,6,1,3,1,1});
    }

    public static int eliminateMaximumForm(final int[] dist, final int[] speed) {
        final double[] arrival = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            arrival[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(arrival);
        int ans = 0;

        for (int i = 0; i < arrival.length; i++) {
            if (arrival[i] <= i) {
                return ans;
            }
            ans++;
        }

        return dist.length;
    }

    public static int eliminateMaximum(final int[] dist, final int[] speed) {
//        final PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (a.dist - a.speed)));
        final List<Pair> comb = new ArrayList<>();
        for(int i=0; i<dist.length; i++) {
            comb.add(new Pair(dist[i], speed[i]));
//            pq.add(new Pair(dist[i], speed[i]));
        }
        for(int i=0; i<dist.length; i++) {
            Collections.sort(comb, Comparator.comparingInt(a -> (a.dist - a.speed)));
            comb.remove(0);
            for(int j=0; j<comb.size(); j++) {
                final Pair cur = comb.get(j);
                cur.dist -= cur.speed;
                if(cur.dist <= 0) {
                    return i+1;
                }
            }
        }
//        for(int i=0; i<dist.length; i++) {
//            dist[i] = Integer.MAX_VALUE;
//            for(int j=i+1; j<dist.length; j++) {
//                dist[j] = dist[j] - speed[j];
//                if(dist[j] <= 0) {
//                    return i+1;
//                }
//            }
//        }
        return dist.length;
    }

    private static class Pair {
        public int dist;
        public int speed;

        public Pair(final int dist, final int speed) {
            this.dist = dist;
            this.speed = speed;
        }

//        @Override
//        public int compareTo(final Pair p2) {
//            return (this.dist - this.speed) - (p2.dist - p2.speed);
//        }
    }

}
