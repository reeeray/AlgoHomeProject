package leetcode.pointers;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.10.2025
 **/
public class AvoidFloodInTheCity_1488 {

    public static void main(String[] args) {
        avoidFlood(new int[] {0, 1, 1});
    }

    //Greedy and binary search
    public static int[] avoidFloodOpt(final int[] rains) {
        final int[] res = new int[rains.length];
        Arrays.fill(res, 1);
        final TreeSet<Integer> st = new TreeSet<>();
        final Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] == 0) {
                st.add(i);
            } else {
                res[i] = -1;
                if (mp.containsKey(rains[i])) {
                    final Integer it = st.ceiling(mp.get(rains[i]));
                    if (it == null) {
                        return new int[0];
                    }
                    res[it] = rains[i];
                    st.remove(it);
                }
                mp.put(rains[i], i);
            }
        }
        return res;
    }


    //didn't make it work
    public static int[] avoidFlood(final int[] rains) {
        final Set<Integer> fullLakes = new HashSet<>();
        final int[] res = new int[rains.length];
        int left = 0, right = 0;
        while (right < rains.length) {
            if(rains[left] != 0 && fullLakes.contains(rains[right])) {
                return new int[0];
            }
            if(rains[left] == 0) {
                if(rains[right] == 0) {
                    right++;
                } else {
                    if(!fullLakes.isEmpty() && !fullLakes.contains(rains[right])) {
                        final int toRemove = fullLakes.iterator().next();
                        res[left++] = toRemove;
                        fullLakes.remove(toRemove);

                    } else {
                        res[left++] = rains[right];
                        fullLakes.remove(rains[right++]);
                    }
                }
            } else {
                res[left] = -1;
                if(left < right) {
                    fullLakes.add(rains[left++]);
                } else {
                    left++;
                    fullLakes.add(rains[right++]);
                }
            }
        }
        while(left < right) {
            if(rains[left] != 0) {
                res[left] = -1;
            } else {
                res[left] = res[0];
            }
            left++;
        }
        return res;
    }
}
