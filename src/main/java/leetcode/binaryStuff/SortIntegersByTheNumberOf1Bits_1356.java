package leetcode.binaryStuff;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.10.2023
 **/
public class SortIntegersByTheNumberOf1Bits_1356 {

    public static void main(String[] args) {

    }

    public static int[] sortByBits(final int[] arr) {
        final Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, new ByteComparator());
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }

        private static class ByteComparator implements Comparator<Integer> {

            @Override
            public int compare(Integer t1, Integer t2) {
//                final long count1 = Integer.toBinaryString(t1).chars().filter(a -> a == 1).count();
//                final long count2 = Integer.toBinaryString(t1).chars().filter(a -> a == 1).count();
                if(Integer.bitCount(t1)  == Integer.bitCount(t2)) {
                    return t1.compareTo(t2);
                }
                return Integer.bitCount(t1) - Integer.bitCount(t2);
            }
        }

    public int[] sortByBitsMask(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = new CustomComparator();
        Arrays.sort(nums, comparator);
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}

class CustomComparator implements Comparator<Integer> {
    private int findWeight(int num) {
        int mask = 1;
        int weight = 0;

        while (num > 0) {
            if ((num & mask) > 0) {
                weight++;
                num ^= mask;
            }

            mask <<= 1;
        }

        return weight;
    }

    @Override
    public int compare(Integer a, Integer b) {
        if (findWeight(a) == findWeight(b)) {
            return a - b;
        }

        return findWeight(a) - findWeight(b);
    }
}
