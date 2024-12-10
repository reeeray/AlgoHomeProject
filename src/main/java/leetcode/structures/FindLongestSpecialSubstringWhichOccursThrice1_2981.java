package leetcode.structures;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.12.2024
 **/
public class FindLongestSpecialSubstringWhichOccursThrice1_2981 {

    public static void main(String[] args) {
        assert 2 == maxLength("aaaa");
    }

    //Time O(n^2) and Space O(n^2)
    public static int maxLength(final String s) {
        final Map<String, Integer> sequencesLength = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            final char c = s.charAt(i);
            for (int j = i; j < s.length(); j++) {
                if (c == s.charAt(j)) {
                    final String subSeq = s.substring(i, j + 1);
                    sequencesLength.put(subSeq, sequencesLength.getOrDefault(subSeq, 0) + 1);
                } else {
                    break;
                }
            }
        }
        int ans = -1;
        for(final Map.Entry<String, Integer> entry : sequencesLength.entrySet()) {
            if(entry.getValue() >= 3 && entry.getKey().length() > ans) {
                ans = entry.getKey().length();
            }
        }
        return ans;
    }
}
