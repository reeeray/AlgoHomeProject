package leetcode.binaryStuff;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.02.2026
 **/
public class BinaryWatch_401 {

    public static void main(String[] args) {

    }

    public List<String> readBinaryWatchEnumeration(int turnedOn) {
        final List<String> res = new ArrayList<String>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    res.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return res;
    }

    //O(1) and Space O(1)
    public List<String> readBinaryWatchBinaryEnumeration(int turnedOn) {
        final List<String> res = new ArrayList<String>();
        for (int i = 0; i < 1024; i++) {
            int h = i >> 6;
            int m = i & 63; // Extract the high 4 bits and low 6 bits using bitwise operations
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                res.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return res;
    }

    public List<String> readBinaryWatch(final int turnedOn) {
        final Map<Integer, List<String>> hours = new HashMap<>();
        final Map<Integer, List<String>> minutes = new HashMap<>();
        for(int i = 0; i< 60; i++) {
            final int bitCount = Integer.bitCount(i);
            if(i < 12) {
                hours.computeIfAbsent(i, v -> new ArrayList<>());
                hours.get(i).add("" + i);
            }
            minutes.computeIfAbsent(i, v -> new ArrayList<>());
            minutes.get(i).add((i < 10 ? "0" : "") + i);
        }
        final List<String> res = new ArrayList<>();
        final int limit = Math.min(turnedOn, 4);
        for(int i = 0; i < limit; i++) {
            for(final String hour : hours.getOrDefault(i, Collections.emptyList())) {
                for(final String min : minutes.getOrDefault(turnedOn - i, Collections.emptyList()))
                    res.add(hour + ":" + minutes);
            }
        }
        return res;
    }

}
