package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.06.2024
 **/
public class HandOfStraights_846 {

    public static void main(String[] args) {

    }

    public static boolean isNStraightHand(final int[] hand, final int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }
        final List<Integer> list = new ArrayList<>();
        for(final int h : hand) {
            list.add(h);
        }
        Collections.sort(list);
        for(int i=0; i<hand.length / groupSize; i++) {
            int num = list.get(0);
            for(int j=0; j<groupSize; j++) {
                if(!list.remove((Integer)num)) {
                    return false;
                }
                num++;
            }
        }
        return true;
    }

    //Time O(n) and Space O(n)
    public static boolean isNStraightHandOptimized(final int[] hand, final int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        // HashMap to store the count of each card value
        final HashMap<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            int count = cardCount.getOrDefault(card, 0);
            cardCount.put(card, count + 1);
        }

        for (int card : hand) {
            int startCard = card;
            // Find the start of the potential straight sequence
            while (cardCount.getOrDefault(startCard - 1, 0) > 0) {
                startCard--;
            }

            // Process the sequence starting from startCard
            while (startCard <= card) {
                while (cardCount.getOrDefault(startCard, 0) > 0) {
                    // Check if we can form a consecutive sequence
                    // of groupSize cards
                    for (
                            int nextCard = startCard;
                            nextCard < startCard + groupSize;
                            nextCard++
                    ) {
                        if (cardCount.getOrDefault(nextCard, 0) == 0) {
                            return false;
                        }
                        cardCount.put(nextCard, cardCount.get(nextCard) - 1);
                    }
                }
                startCard++;
            }
        }

        return true;
    }
}
