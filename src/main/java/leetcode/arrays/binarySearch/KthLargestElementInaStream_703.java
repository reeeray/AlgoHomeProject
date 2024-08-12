package leetcode.arrays.binarySearch;

import javax.xml.stream.events.ProcessingInstruction;
import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.05.2023
 **/
public class KthLargestElementInaStream_703 {

    private static class Test {

        public static void main(String[] args) {
            KthLargestElementInaStream_703 testee = new KthLargestElementInaStream_703(5, new int[] {7, 5, 8, 13, 1});
            testee.add(6);
        }
    }

    //Space O(k) and Time(O((n+m)*logk)
    private final PriorityQueue<Integer> storage;
    private final int k;

    public KthLargestElementInaStream_703(final int k, final int[] nums) {
        this.k = k;
        this.storage = new PriorityQueue<>();
        for(int i  : nums) {
            storage.add(i);
        }

        while(storage.size() > k) {
            storage.poll();
        }
    }

    public int add(final int val) {
        if(storage.size() < k) {
            storage.add(val);
        } else if (storage.peek() <= val){
                storage.poll();
                storage.add(val);

        }
        return storage.peek();
    }
}
