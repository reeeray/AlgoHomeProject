package leetcode.combinatorics;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.02.2025
 **/
public class TupleWithSameProduct_1726 {

    public static void main(String[] args) {

    }

    //Time O(n^2) and Space O(n^2)
//    There are 8 valid tuples:
//            (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//            (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
    public static int tupleSameProduct(final int[] nums) {
        final Map<Integer, Integer> productFrequency = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                final int product = nums[i] * nums[j];
                productFrequency.put(product, productFrequency.getOrDefault(product, 0) + 1);
            }
        }

        int numberOfCombinations = 0;
        for(final int freqOfProducts : productFrequency.values()) {
            // Calculate the number of ways to choose two pairs with the same product
            //n(n-1)/2
            final int numOfPairs = (freqOfProducts - 1) * freqOfProducts / 2;
            // Add the number of tuples for this product to the total (each pair
            // can form 8 tuples)
            numberOfCombinations += 8 * numOfPairs;
        }
        return numberOfCombinations;
    }
}
