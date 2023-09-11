package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.09.2023
 **/
public class GroupThePeople_1282 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> groupThePeople(final int[] groupSize) {
        final List<List<Integer>> answer = new ArrayList<>();
        final Map<Integer, List<Integer>> groups = new HashMap<>();
        for(int i=0; i<groupSize.length; i++) {
            final int size = groupSize[i];
            groups.computeIfAbsent(size, a -> new ArrayList<>());
            final List<Integer> subGroup = groups.get(size);
            subGroup.add(i);
            if(subGroup.size() == size) {
                answer.add(subGroup);
                groups.remove(size);
            }
        }
        return answer;
    }
}
