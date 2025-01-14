package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.01.2025
 **/
public class FindThePrefixCommonArrayOfTwoArrays_2657 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public static int[] findThePrefixCommonArray(final int[] A, final int[] B) {
        final boolean[] left = new boolean[A.length + 1];
        final boolean[] right = new boolean[B.length + 1];
        int counter = 0;
        final int[] res = new int[A.length];
        for(int i=0; i<A.length; i++) {
            left[A[i]] = true;
            right[B[i]] = true;
            if(A[i] == B[i]) {
                counter++;
            } else {
                if(left[A[i]] == right[A[i]]) {
                    counter++;
                }
                if (left[B[i]] == right[B[i]]) {
                    counter++;
                }
            }
            res[i] = counter;
        }
        return res;
    }

    //Time O(n) and Space O(n)
    public int[] findThePrefixCommonArraySpaceOptimized(int[] A, int[] B) {
        final int n = A.length;
        final int[] prefixCommonArray = new int[n];
        final int[] frequency = new int[n + 1];
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
