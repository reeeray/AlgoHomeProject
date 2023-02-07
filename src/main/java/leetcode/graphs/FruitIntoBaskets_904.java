package leetcode.graphs;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.02.2023
 **/
public class FruitIntoBaskets_904 {

    public static void main(String[] args) {

    }

    private static int totalFruit(final int[] fruits) {
        int answ = 0;
        for(int i=0; i<fruits.length-1; i++) {
            int left = fruits[i];
            int right = -1;
            int counter = 1;
            int j = i+1;
            while (j < fruits.length) {
                if(fruits[j] == left || fruits[j] == right) {
                    counter++;
                    j++;
                    continue;
                }
                if(right == -1) {
                    right = fruits[j];
                    counter++;
                    j++;
                    continue;
                }
                break;
            }
            answ = Math.max(answ, counter);
        }

        return answ;
    }

    //Slide window
    private static int totalFruitsInBusket(final int[] fruits) {
        // Hash map 'basket' to store the types of fruits.
        final Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, right;

        // Add fruit from right side (right) of the window.
        for (right = 0; right < fruits.length; ++right) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If the current window has more than 2 types of fruit,
            // we remove one fruit from the left index (left) of the window.
            if (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0)
                    basket.remove(fruits[left]);
                left++;
            }
        }

        // Once we finish the iteration, the indexes left and right
        // stands for the longest valid subarray we encountered.
        return right - left;
    }
}
