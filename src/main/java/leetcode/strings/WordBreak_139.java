package leetcode.strings;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.08.2023
 **/
public class WordBreak_139 {

    public static void main(String[] args) {
        final String input = "leetcode";
        System.out.println(wordBreak(input, Arrays.asList("leet", "code")));

    }

    //TODO : it cases TLE
    public static boolean wordBreak(final String s, final List<String> wordDict) {
        final Map<Character, List<String>> alphabet = new HashMap<>();
        wordDict.forEach(word -> {
            alphabet.computeIfAbsent(word.charAt(0),v -> new ArrayList<>());
            alphabet.get(word.charAt(0)).add(word);
        });
        return dfs(alphabet, s);
    }

    private static boolean dfs(final Map<Character, List<String>> alphabet, final String subStr) {
        if(subStr == "" || subStr == null) {
            return true;
        }

        for(final String str : alphabet.getOrDefault(subStr.charAt(0), Collections.emptyList())) {
            if(subStr.length() >= str.length() && subStr.substring(0, str.length()).equals(str)) {
                if(dfs(alphabet, subStr.substring(str.length()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wordBreakBFS(final String s, final List<String> wordDict) {
        final Set<String> words = new HashSet<>(wordDict);
        final Queue<Integer> queue = new LinkedList<>();
        final boolean[] seen = new boolean[s.length() + 1];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (start == s.length()) {
                return true;
            }

            for (int end = start + 1; end <= s.length(); end++) {
                if (seen[end]) {
                    continue;
                }

                if (words.contains(s.substring(start, end))) {
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }

        return false;
    }
}
