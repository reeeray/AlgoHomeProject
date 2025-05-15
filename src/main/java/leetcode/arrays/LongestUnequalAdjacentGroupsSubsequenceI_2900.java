package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.05.2025
 **/
public class LongestUnequalAdjacentGroupsSubsequenceI_2900 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static List<String> getLongestSubsequence(final String[] words, final int[] groups) {
        int prevIndex = 0; //it can be removed and compare to the previous one
        final List<String> res = new ArrayList<>();
        res.add(words[0]);
        for(int i = 1; i < groups.length; i++) {
            if(groups[i] != groups[prevIndex]) {
                res.add(words[i]);
                prevIndex = i;
            }
        }
        return res;
    }

    //Totally different task
    public static List<String> getLongestSubsequenceMisunderstood(final String[] words, final int[] groups) {
        if(groups.length == 1) {
            return List.of(words[0]);
        }
        final List<String> res = new ArrayList<>();
        int startLongest = 0;
        int endLongest = 0;
        int start = 0;
        for(int i = 1; i <= groups.length; i++) {
            if(i != groups.length && groups[i] != groups[i - 1]) {
                continue;
            }
            if((i - 1 - start) > (endLongest - startLongest)) {
                startLongest = start;
                endLongest = i - 1;
            }
            start = i;
        }

        for(int i = startLongest; i <= endLongest; i++) {
            res.add(words[i]);
        }
        return res;
    }


}
