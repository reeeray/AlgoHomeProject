package leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.04.2023
 **/
public class LastStoneWeight_1046 {

    public static void main(String[] args) {
        final int[] input = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(input));
    }

    private static int lastStoneWeight(final int[] stones) {
        final List<Integer> st = new ArrayList<>();
        for (final int s:
             stones) {
            st.add(s);
        }
        Collections.sort(st, Collections.reverseOrder());
        while (st.size() >= 2) {
            final int s1 = st.get(0);
            final int s2 = st.get(1);
            st.remove(0);
            st.remove(0);
            if(s1 == s2) {
                continue;
            } else if (s1 < s2 ){
                st.add(s2 - s1);
                Collections.sort(st, Collections.reverseOrder());
            } else {
                st.add(s1 - s2);
                Collections.sort(st, Collections.reverseOrder());
            }
        }
        return st.size() == 0 ? 0 : st.get(0);
    }
}
