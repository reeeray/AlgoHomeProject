package leetcode.structures;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.04.2026
 **/
public class WordsWithinTwoEditsOfDictionary_2452 {

    public static void main(String[] args) {

    }

    //Almost there but failing on some tests Time O(dn + qn^2 25^2) Time (dn)
    public static List<String> twoEditWords(final String[] queries, final String[] dictionary) {
        final Level entry = new Level();
        for(final String str : dictionary) {
            Level curr = entry;
            for(int i = 0; i < str.length(); i++) {
                curr.isEmpty = false;
                if(curr.levels[str.charAt(i) - 'a'] == null) curr.levels[str.charAt(i) - 'a'] = new Level();
                if(i == str.length() - 1) {
                    curr.fullWord[str.charAt(i) - 'a'] = true;
                    continue;
                }
                curr = curr.levels[str.charAt(i) - 'a'];
            }
        }

        final List<String> res = new ArrayList<>();
        for(final String str : queries) {
            if(check(str, 0, entry, 0)) res.add(str);
        }
        return res;
    }

    private static boolean check(final String word, final int idx, final Level curr, final int skips) {
        if(curr.isEmpty || skips > 2) return false;
        boolean flag = false;
        final int idxOfCurrChar = word.charAt(idx) - 'a';
        if(curr.levels[idxOfCurrChar] != null && curr.fullWord[idxOfCurrChar] && idx == word.length() - 1) return true;
        for(int i = 0; i < 26; i++) {
            if(flag) break;
            if(curr.levels[i] != null)
                flag = check(word, idx + 1, curr.levels[i], idxOfCurrChar == i ? skips : skips + 1);
        }
        return flag;
    }

    private static class Level {
        final Level[] levels;
        final boolean[] fullWord;
        boolean isEmpty;
        Level() {
            levels = new Level[26];
            fullWord = new boolean[26];
            isEmpty = true;
        }
    }
    // ================================================================================ Similar implementation TrieNode +DFS =====================================================================================
    static class TrieNode {

        TrieNode[] child = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.child[idx] == null) node.child[idx] = new TrieNode();
            node = node.child[idx];
        }
        node.isEnd = true;
    }

    boolean dfs(String word, int i, TrieNode node, int cnt) {
        if (cnt > 2 || node == null) return false;

        if (i == word.length()) return node.isEnd;

        int idx = word.charAt(i) - 'a';

        // no changes made
        if (node.child[idx] != null) {
            if (dfs(word, i + 1, node.child[idx], cnt)) return true;
        }

        // made changes
        if (cnt < 2) {
            for (int c = 0; c < 26; c++) {
                if (c == idx) continue;
                if (node.child[c] != null) {
                    if (dfs(word, i + 1, node.child[c], cnt + 1)) return true;
                }
            }
        }

        return false;
    }

    public List<String> twoEditWordsWorkingVersion(String[] queries, String[] dictionary) {
        for (String w : dictionary) insert(w);

        List<String> res = new ArrayList<>();
        for (String q : queries) {
            if (dfs(q, 0, root, 0)) {
                res.add(q);
            }
        }
        return res;
    }
}
