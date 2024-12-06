package leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.12.2024
 **/
public class MaxNumberOfIntegersToChooseFromARange1_2554 {

    public static void main(String[] args) {

    }

    //Time O(m + n) and Space O(m) where m is length of banned array
    public static int maxCount(final int[] banned, final int n, int maxSum) {
        //final Set<Integer> ignore = Arrays.stream(banned).boxed().collect(Collectors.toCollection(HashSet::new));
        final Set<Integer> ignore = new HashSet<>();
        for(final int ban : banned) {
            ignore.add(ban);
        }
        int count = 0;
        for(int i=1; i<=n; i++) {
            if(ignore.contains(i)) {
                continue;
            }
            maxSum -= i;
            if(maxSum < 0) {
                return count;
            }
            count++;
        }
        return count;
    }
}
