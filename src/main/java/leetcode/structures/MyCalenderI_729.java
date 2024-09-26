package leetcode.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.09.2024
 **/
public class MyCalenderI_729 {

    private final List<Integer> startList;
    private final List<Integer> endList;

    public static void main(String[] args) {
        final MyCalenderI_729 testee = new MyCalenderI_729();
        testee.book(10, 20);
        testee.book(15, 25);
        testee.book(0, 10);
    }

    public MyCalenderI_729() {
        startList = new ArrayList<>();
        endList = new ArrayList<>();
    }

    //correct strategie but it's an error somewhere, it should be solved via sorted list and binary search
    //Time complexity O(nlogn) and Space O(n)
    public boolean book(final int start, final int end) {
        int index = findClosest(start);
        if(index == -1) {
            return false;
        }
        if(index == startList.size()) {
            startList.add(start);
            endList.add(end);
            return true;
        }

        if(index == 0 && startList.get(index) >= end) {
            startList.add(0, start);
            endList.add(0, end);
            return true;
        }

        if(index == startList.size() - 1 && endList.get(index) <= start) {
            startList.add(start);
            endList.add(end);
            return true;
        }
        if(startList.get(index + 1) > start && startList.get(index + 1) >= end && endList.get(index) < start) {
            startList.add(index + 1, start);
            endList.add(index + 1, end);
            return true;
        }

        return false;
    }

    private int findClosest(final int start) {
        int left = 0;
        int right = startList.size() - 1;
        while (left < right) {
            final int mid = (left + right) / 2;
            if(startList.get(mid) > start) {
                right = mid;
            } else if(startList.get(mid) < start) {
                left = mid + 1;
            } else {
                return -1;
            }
        }
        return left;
    }

//    final TreeMap<Integer, Integer> calendar;
//
//    MyCalendar() {
//        calendar = new TreeMap();
//    }
//
//    public boolean book(int start, int end) {
//        Integer prev = calendar.floorKey(start),
//                next = calendar.ceilingKey(start);
//        if ((prev == null || calendar.get(prev) <= start) &&
//                (next == null || end <= next)) {
//            calendar.put(start, end);
//            return true;
//        }
//        return false;
//    }
}
