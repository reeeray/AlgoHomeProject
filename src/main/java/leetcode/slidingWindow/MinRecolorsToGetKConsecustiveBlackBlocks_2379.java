package leetcode.slidingWindow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.03.2025
 **/
public class MinRecolorsToGetKConsecustiveBlackBlocks_2379 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static int minimumRecolots(final String blocks, final int k) {
        int minRecolors = Integer.MAX_VALUE, left = 0, numWhites = 0;
        for(int i=0; i < blocks.length(); i++) {
            if(blocks.charAt(i) == 'W') {
                numWhites++;
            }
            if(i - left == k) {
                minRecolors = Math.min(minRecolors, numWhites);
                if (blocks.charAt(left) == 'W') numWhites--;
                left++;
            }
        }
        return minRecolors;
    }

    //Time O(n) and Spac O(n)
    public int minimumRecolorsNonOpt(final String blocks, final int k) {
        final Queue<Character> blockQueue = new LinkedList<>();
        int numWhites = 0;

        // Initiate queue with first k values
        for (int i = 0; i < k; i++) {
            char currentChar = blocks.charAt(i);
            if (currentChar == 'W') numWhites++;
            blockQueue.add(currentChar);
        }

        // Set initial minimum
        int numRecolors = numWhites;

        for (int i = k; i < blocks.length(); i++) {
            // Remove front element from queue and update current number of white blocks
            if (blockQueue.poll() == 'W') numWhites--;

            // Add current element to queue and update current number of white blocks
            char currentChar = blocks.charAt(i);
            if (currentChar == 'W') numWhites++;
            blockQueue.add(currentChar);

            // Update minimum
            numRecolors = Math.min(numRecolors, numWhites);
        }
        return numRecolors;
    }
}
