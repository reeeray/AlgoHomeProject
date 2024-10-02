package leetcode.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.10.2024
 **/
public class RankTransformationOfAnArray_1331 {

    public static void main(String[] args) {
        final int[] input = new int[] {37,12,28,9,100,56,80,5,12};
        arrayRankTransform(input);
    }

    public static int[] arrayRankTransform(final int[] arr) {
        final int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        final Map<Integer, Integer> indexes = new HashMap<>();
        int idx = 1;
        for(int val : sorted) {
            if(!indexes.containsKey(val)) {
                indexes.put(val, idx++);
            }
        }
        for(int i=0; i<arr.length; i++) {
            arr[i] = indexes.get(arr[i]);
        }
        return arr;
    }

    //Space O(n + s) and Time O(nlogn)
    public int[] arrayRankTransformFancy(int[] arr) { // tc -> nlogn + 2n //sc -> n + n = 2n
        int[] dup = arr.clone();
        Arrays.sort(dup); // nlogn
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i<dup.length;i++){ // n
            map.putIfAbsent(dup[i],map.size()+1);
        }
        for(int i = 0;i<arr.length;i++){ // n
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
