package coursera.strings;

import java.util.Arrays;

/**
 * Algorithm to find longest repeated substring in a String.
 * Based on SuffixSort(linear time)
 * It is not working for long common prefixes!
 * User : Shein G.A.{@reeeray}
 * Date : 05.07.2020
 **/
public class LongestSubstring {

    public String lrs(final String input) {
        final int N = input.length();
        final String[] suffixes = new String[N];

        //creation of suffixes - linear time and space
        for (int i = 0; i < N; i++)
            suffixes[i] = input.substring(i, N);

        Arrays.sort(suffixes); //suffix sort

        String lrs = ""; //final LCP(longest common prefix) between adjacent suffixes in sorted order
        for (int i = 0; i < N - 1; i++) {
            int len = 0;//lcp(suffixes[i], suffixes[i+1]); - Manber-Myers algorithm guarantee NlogN
            if (len > lrs.length())
                lrs = suffixes[i].substring(0, len);
        }
        return lrs;
    }
}
