package leetcode.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.10.2023
 **/
public class FlattenNestedListIterator_341 implements Iterator<Integer> {

    final List<Integer> flattened;
    private int index;


    public FlattenNestedListIterator_341(final List<NestedInteger> nestedList) {
        index = 0;
        flattened = flatten(nestedList);
    }

    private List<Integer> flatten(final List<NestedInteger> nestedList) {
        final List<Integer> result = new ArrayList<>();
        for(final NestedInteger ni : nestedList) {
            if(ni.isInteger()) {
                result.add(ni.getInteger());
            } else {
                result.addAll(flatten(ni.getList()));
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        return flattened.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < flattened.size();
    }

//    final List<Integer> integers;
//    List<NestedInteger> nested;
//    public NestedIterator(final List<NestedInteger> nestedList) {
//        integers = new ArrayList<>();
//        nested = nestedList;
//    }
//
//    @Override
//    public Integer next() {
//        hasNext();
//        final Integer toReturn = integers.remove(0);
//        return toReturn;
//    }
//
//    @Override
//    public boolean hasNext() {
//        if(integers.isEmpty()) {
//            while (integers.isEmpty() && !nested.isEmpty()) {
//                if(nested.get(0).isInteger()) {
//                    integers.add(nested.get(0).getInteger());
//                    nested.remove(0);
//                } else {
//                    final List<NestedInteger> newList = nested.get(0).getList();
//                    newList.addAll(nested);
//                    nested = newList;
//                }
//            }
//        }
//        return !integers.isEmpty();
//    }

    private interface NestedInteger {
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }
}
