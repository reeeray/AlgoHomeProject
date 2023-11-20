package leetcode.pureLogic;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.11.2023
 **/
public class MinAmountTimeToCollectGarbage_2391 {

    public static void main(String[] args) {

    }

    public static int garbageCollection(final String[] garbage, final int[] travel) {
        for(int i=1; i<travel.length; i++) {
            travel[i] = travel[i-1] + travel[i];
        }

        final Map<Character, Integer> lastIndexPerGerbageType = new HashMap<>();
        int total = 0;
        for(int i=0; i<garbage.length; i++) {
            for(final char c : garbage[i].toCharArray()) {
                lastIndexPerGerbageType.put(c, i);
                total++;
            }
        }
        for(final char c : "MPG".toCharArray()) {
            total+= lastIndexPerGerbageType.getOrDefault(c, 0) == 0 ? 0 : travel[lastIndexPerGerbageType.get(c) - 1];
        }
        return total;
    }
}
