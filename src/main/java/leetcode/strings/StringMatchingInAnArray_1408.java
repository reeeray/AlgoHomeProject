package leetcode.strings;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.01.2025
 **/
public class StringMatchingInAnArray_1408 {

    public static void main(String[] args) {

    }

    public static List<String> stringMatching(final String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        final Set<String> unique = new HashSet<>();
        final List<String> answer = new ArrayList<>();
        for(final String word : words) {
            if(unique.stream().anyMatch(v -> v.contains(word))) {
                answer.add(word);
                continue;
            }
            unique.add(word);
        }
        return answer;
    }

    private static class TrieNode {

        // Tracks how many times this substring appears in the Trie.
        int frequency;
        // Maps characters to their respective child nodes.
        final Map<Character, TrieNode> childNodes;

        TrieNode() {
            frequency = 0;
            childNodes = new HashMap<>();
        }
    }

    //Time (m^2 * n) where n is the number of words and m is the length of the longest word and Space is O(m^2 * n)
    public static List<String> stringMatchingOpt(final String[] words) {
        final List<String> matchingWords = new ArrayList<>();
        final TrieNode root = new TrieNode(); // Initialize the root of the Trie.

        // Insert all suffixes of each word into the Trie.
        for (final String word : words) {
            for (int startIndex = 0; startIndex < word.length(); startIndex++) {
                // Insert each suffix starting from index startIndex.
                insertWord(root, word.substring(startIndex));
            }
        }

        // Check each word to see if it exists as a substring in the Trie.
        for (final String word : words) {
            if (isSubstring(root, word)) {
                matchingWords.add(word);
            }
        }

        return matchingWords;
    }

    private static void insertWord(final TrieNode root, final String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            // If the character already exists as a child node, move to it.
            currentNode.childNodes.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.childNodes.get(c);
            currentNode.frequency++; // Increment the frequency of the node.
        }
    }

    private static boolean isSubstring(final TrieNode root, final String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            // Traverse the Trie following the characters of the word.
            currentNode = currentNode.childNodes.get(c);
        }
        // A word is a substring if its frequency in the Trie is greater than 1.
        return currentNode.frequency > 1;
    }

}
