package leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.12.2022
 **/
public class RemoveStonesToMinTotal {

    public static void main(String[] args) {
        final int[] input = {4, 3, 6, 7};
        final int k = 3;

        assert 12 == minStoneSumPQ(input, k);
    }


    public static int minStoneSum(final int[] piles, final int k) {
        final List<Integer> pilesList = new ArrayList<>();
        for(int pile : piles) {
            pilesList.add(pile);
        }

        Collections.sort(pilesList, Collections.reverseOrder());

        for(int i=0; i<k; i++) {
            final int pile = pilesList.remove(0);
            pilesList.add(pile - pile/2);
            Collections.sort(pilesList, Collections.reverseOrder());
        }

        return pilesList.stream().reduce(0, Integer::sum);
    }

    public static int minStoneSumPQ(final int[] piles, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for(int i : piles){
            pq.add(i);
        }

        while(k > 0 && !pq.isEmpty()){
            int temp = pq.poll();
            temp -= (int)Math.floor(temp/2);
            pq.add(temp);
            k--;
        }

        int sum = 0;
        while(!pq.isEmpty())sum += pq.poll();

        return sum;
    }
}
