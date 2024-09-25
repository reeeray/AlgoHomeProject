package leetcode.structures;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.09.2024
 **/
public class SumOfPrefixScoresOfStrings_2416 {

    public static void main(String[] args) {

    }

    //Time O(n*m) where n - length of words and m - average length of word in words, Space is O(n*m)
    public static int[] sumPrefixScores(final String[] words) {
        final TrieNode root = new TrieNode();

        for(final String word : words) {
            insert(word, root);
        }

        final int[] answer = new int[words.length];
        for(int i=0; i<words.length; i++) {
            answer[i] = count(root, words[i]);
        }
        return answer;
    }

    private static void insert(final String word, TrieNode node) {
        for(final char c : word.toCharArray()) {
            if(node.nodes[c - 'a'] == null) {
                node.nodes[c - 'a'] = new TrieNode();
            }
            node.nodes[c - 'a'].currentPrefixCount++;
            node = node.nodes[c - 'a'];
        }
    }

    private static int count(TrieNode node, final String word) {
        int count = 0;
        for(final char c : word.toCharArray()) {
            if(node != null) {
                count += node.nodes[c - 'a'].currentPrefixCount;
                node = node.nodes[c - 'a'];
            }
        }
        return count;
    }




    private static class TrieNode {
        final TrieNode[] nodes = new TrieNode[26];
        int currentPrefixCount = 0;
    }
}
