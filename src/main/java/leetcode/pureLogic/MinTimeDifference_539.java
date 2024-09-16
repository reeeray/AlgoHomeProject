package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.09.2024
 **/
public class MinTimeDifference_539 {

    public static void main(String[] args) {
        final List<String> input = new ArrayList<>();
        input.add("12:12");
        input.add("00:13");
        findMinDifference(input);
    }

    public static int findMinDifference(final List<String> timePoints) {
        final List<Integer> translated = new ArrayList<>();
        for(final String str : timePoints) {
            final String[] time = str.split(":");
            final int hours = Integer.parseInt(time[0]);
            final int minutes = Integer.parseInt(time[1]);
            translated.add(hours*60 + minutes);
        }
        Collections.sort(translated);
        int minDiff = Integer.MAX_VALUE;
        for(int i=1; i<translated.size(); i++) {
            minDiff = Math.min(minDiff, translated.get(i) - translated.get(i - 1));
        }
        return Math.min(
                minDiff,
                24 * 60 - translated.get(translated.size() - 1) + translated.get(0));
    }
}
