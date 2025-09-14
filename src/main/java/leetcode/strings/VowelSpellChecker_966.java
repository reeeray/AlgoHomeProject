package leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.09.2025
 **/
public class VowelSpellChecker_966 {

    public static void main(String[] args) {

    }

    //Time O(w + q) and Space O(w) where w is the length of wordList and q is the length of queries
    public static String[] spellChecker(final String[] wordList, final String[] queries) {
        final Set<String> uniqueWords = new HashSet<>();
        final Map<String, String> counterparts = new HashMap<>();
        for(final String word : wordList) {
            uniqueWords.add(word);
            if(!counterparts.containsKey(word.toLowerCase())) {
                counterparts.put(word.toLowerCase(), word);
            }
            final String cp = word.toLowerCase().replaceAll("[aeiou]", "*");
            if(!counterparts.containsKey(cp)) {
                counterparts.put(cp, word);
            }
        }

        for(int i = 0; i < queries.length; i++) {
            if(uniqueWords.contains(queries[i])) {
                continue;
            }
            if(counterparts.containsKey(queries[i].toLowerCase())) {
                queries[i] = counterparts.get(queries[i].toLowerCase());
                continue;
            }
            final String cp = queries[i].toLowerCase().replaceAll("[aeiou]", "*");
            queries[i] = counterparts.getOrDefault(cp, "");
        }
        return queries;
    }
}
