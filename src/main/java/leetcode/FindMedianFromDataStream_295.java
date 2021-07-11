package leetcode;

import java.util.PriorityQueue;

/**
 * 295. Find Median From Data Stream.
 * <p>
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
 * <p>
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 * <p>
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 11.07.2021
 **/
public class FindMedianFromDataStream_295 {
    private final PriorityQueue<Integer> leftHalf;
    private final PriorityQueue<Integer> rightHalf;
    boolean even;

    public FindMedianFromDataStream_295() {
        leftHalf = new PriorityQueue<>();
        rightHalf = new PriorityQueue<>();
        even = true;
    }

    public void addNum(final int num) {
        if (even) {
            rightHalf.add(num);
            leftHalf.add(rightHalf.poll());
        } else {
            leftHalf.add(num);
            rightHalf.add(leftHalf.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (leftHalf.size() == rightHalf.size()) {
            return (leftHalf.peek() + rightHalf.peek()) / 2.0;
        } else {
            return 1.0 * (leftHalf.peek());
        }
    }
}
