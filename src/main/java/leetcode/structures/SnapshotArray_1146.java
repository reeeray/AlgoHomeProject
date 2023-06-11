package leetcode.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.06.2023
 **/
public class SnapshotArray_1146 {

    private static class Test {
        public static void main(String[] args) {
            SnapshotArray_1146 testee = new SnapshotArray_1146(2);
            testee.snap();
            testee.get(1, 0);
            testee.get(0, 0);
            testee.set(1, 8);
            testee.get(1, 0);
            testee.set(0, 20);
            testee.get(0, 0);
            testee.set(0, 7);

        }
    }
//    private int id;
//    private int[] array;
//    private List<int[]> snapshot;
//
//    public SnapshotArray_1146(final int length) {
//        this.id = 0;
//        this.array = new int[length];
//        this.snapshot = new ArrayList<>();
//    }
//
//    public void set(final int index, final int val) {
//        array[index] = val;
//    }
//
//    public int snap(){
//        snapshot.add(array);
//        final int[] copy = new int[array.length];
//        System.arraycopy(array, 0, copy, 0, array.length);
//        array = copy;
//        return id++;
//    }
//
//    public int get(final int index, final int snap_id) {
//        final int[] snap = snapshot.get(snap_id);
//        return snap[index];
//    }

    int id = 0;
    final TreeMap<Integer, Integer>[] historyRecords;

    public SnapshotArray_1146(int length) {
        historyRecords = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            historyRecords[i] = new TreeMap<Integer, Integer>();
            historyRecords[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        historyRecords[index].put(id, val);
    }

    public int snap() {
        return id++;
    }

    public int get(int index, int snapId) {
        return historyRecords[index].floorEntry(snapId).getValue();
    }
}
