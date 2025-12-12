package leetcode.pureLogic;

import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.12.2025
 **/
public class CountMentionsPerUser_3433 {

    public static void main(String[] args) {
        //countMentions(2, List.of(List.of("MESSAGE","10","id1 id0"), List.of("OFFLINE","11","0"), List.of("MESSAGE","12","ALL")));
        countMentions(3, List.of(List.of("MESSAGE","2","HERE"), List.of("OFFLINE","2","1"), List.of("OFFLINE","1","0"), List.of("MESSAGE","61","HERE")));
    }

    //Space O(n) and let m be length of events and t max time eventm then Time is O(nm + mlogmlogt)
    public static int[] countMentions(final int numberOfUsers, final List<List<String>> events) {
        final int[] lastSeen = new int[numberOfUsers];
        final int[] numOfMentions = new int[numberOfUsers];
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB) {
                return Integer.compare(timeA, timeB);
            }
            boolean aIsMessage = a.get(0).equals("MESSAGE");
            boolean bIsMessage = b.get(0).equals("MESSAGE");
            return Boolean.compare(aIsMessage, bIsMessage);
        });
        for(final List<String> event : events) {
            final String message = event.get(0);
            final int timeStamp = Integer.parseInt(event.get(1));
            final String id = event.get(2);
            if("MESSAGE".equals(message)) {
                if(id.equals("ALL")) {
                    for(int i = 0; i < numberOfUsers; i++) {
                        numOfMentions[i]++;
                    }
                } else if(id.equals("HERE")) {
                    for(int i = 0; i < numberOfUsers; i++) {
                        if(lastSeen[i] <= timeStamp) {
                            numOfMentions[i]++;
                        }
                    }
                } else {
                    final String[] ids = id.split(" ");
                    for(final String currID : ids) {
                        final int integerID = Integer.parseInt(currID.substring(2));
                            numOfMentions[integerID]++;
                    }
                }
            } else {
                lastSeen[Integer.parseInt(id)] = timeStamp + 60;
            }
        }
        return numOfMentions;
    }
}
