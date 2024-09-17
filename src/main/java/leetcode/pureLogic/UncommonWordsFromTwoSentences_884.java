package leetcode.pureLogic;

import leetcode.structures.Pair;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.09.2024
 **/
public class UncommonWordsFromTwoSentences_884 {

    public static void main(String[] args) {

    }

    public static String[] uncommonFromSentences(final String s1, final String s2) {
        final String[] words = (s1 + " " + s2).split(" ");
        final Set<String> unique = new HashSet<>();
        final Set<String>  repeated = new HashSet<>();
        for(final String str : words) {
            if(!unique.add(str)) {
                repeated.add(str);
            }
        }
        final String[] ans = new String[unique.size() - repeated.size()];
        int idx = 0;
        for(final String str : unique) {
            if(!repeated.contains(str)) {
                ans[idx++] = str;
            }
        }
        return ans;
    }

    //Time O(M + N) and Space O(M + N)
    public String[] uncommonFromSentencesEditorial(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word : A.split(" ")) count.put(
                word,
                count.getOrDefault(word, 0) + 1
        );
        for (String word : B.split(" ")) count.put(
                word,
                count.getOrDefault(word, 0) + 1
        );

        final List<String> ans = new LinkedList();
        for (String word : count.keySet()) if (count.get(word) == 1) ans.add(
                word
        );

        return ans.toArray(new String[ans.size()]);
    }
}
