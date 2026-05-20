package leetcode.pointers;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.05.2026
 **/
public class FindThePrefixCommonArrayOfTwoArrays_2657 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(3n)
    public static int[] findThePrefixCommonArray(final int[] A, final int[] B) {
        final Set<Integer> setA = new HashSet<>();
        final Set<Integer> setB = new HashSet<>();
        final int[] res = new int[A.length];
        res[0] = A[0] == B[0] ? 1 : 0;
        setA.add(A[0]);
        setB.add(B[0]);
        for(int i = 1; i < A.length; i++) {
            int count = 0;
            if(setB.contains(A[i])) count++;
            setA.add(A[i]);
            if(setA.contains(B[i])) count++;
            setB.add(B[i]);
            res[i] = res[i - 1] + count;
        }
        return res;
    }

    //Time O(n) and Space O(n)
    public int[] findThePrefixCommonArrayMemOpt(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];
        int[] frequency = new int[n + 1];
        int commonCount = 0;

        // Iterate through the elements of both arrays
        for (int currentIndex = 0; currentIndex < n; ++currentIndex) {
            // Increment frequency of current elements in A and B
            // Check if the element in A has appeared before (common in prefix)
            frequency[A[currentIndex]] += 1;
            if (frequency[A[currentIndex]] == 2) ++commonCount;

            // Check if the element in B has appeared before (common in prefix)
            frequency[B[currentIndex]] += 1;
            if (frequency[B[currentIndex]] == 2) ++commonCount;

            // Store the count of common elements for the current prefix
            prefixCommonArray[currentIndex] = commonCount;
        }

        // Return the final array with counts of common elements in each prefix
        return prefixCommonArray;
    }
}
