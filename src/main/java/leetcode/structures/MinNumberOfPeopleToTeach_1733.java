package leetcode.structures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.09.2025
 **/
public class MinNumberOfPeopleToTeach_1733 {

    public static void main(String[] args) {

    }

    //Greedy Time O(mn) and Space O(m + n) where m is number of friendship pairs, n number of languages
    public int minimumTeachingsOpt(int n, int[][] languages, int[][] friendships) {
        final Set<Integer> cannotCommunicate = new HashSet<>();
        for (int[] friendship : friendships) {
            final Map<Integer, Integer> canCommunicate = new HashMap<>();
            boolean conm = false;
            for (int lan : languages[friendship[0] - 1]) {
                canCommunicate.put(lan, 1);
            }
            for (int lan : languages[friendship[1] - 1]) {
                if (canCommunicate.containsKey(lan)) {
                    conm = true;
                    break;
                }
            }
            if (!conm) {
                cannotCommunicate.add(friendship[0] - 1);
                cannotCommunicate.add(friendship[1] - 1);
            }
        }
        int max_cnt = 0;
        int[] cnt = new int[n + 1];
        for (int friendship : cannotCommunicate) {
            for (int lan : languages[friendship]) {
                cnt[lan]++;
                max_cnt = Math.max(max_cnt, cnt[lan]);
            }
        }
        return cannotCommunicate.size() - max_cnt;
    }

    //There is an error somewhere in implementation
    public static int minimumTeachings(final int n, final int[][] languages, final int[][] friendships) {
        final int[] freq = new int[n + 1];
        final Set<Integer> uniqueFriends = new HashSet<>();
        for(final int[] friends : friendships) {
            for(final int friend : friends) {
                if(uniqueFriends.add(friend)) {
                    for(final int lang : languages[friend - 1]) {
                        freq[lang]++;
                    }
                }
            }
        }
        int mostFreqLang = -1;
        for(int i = 1; i <= n; i++) {
            mostFreqLang = Math.max(mostFreqLang, freq[i]);
        }
        int res = 0;
        for(final int friend : uniqueFriends) {
            boolean flag = true;
            for(final int l : languages[friend - 1]) {
                if(l == mostFreqLang) {
                    flag = false;
                    break;
                }
            }
            if(flag) res++;
        }
        return res;
    }
}
