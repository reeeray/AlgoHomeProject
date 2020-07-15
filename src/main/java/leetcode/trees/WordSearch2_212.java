package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Word Search II. 212 leetcode issue
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * User : Shein G.A.{@reeeray}
 * Date : 30.06.2020
 **/
public class WordSearch2_212 {

    private static class TreeNode {
        private final TreeNode[] letters = new TreeNode[26];
        private String word;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        final List<String> result = new ArrayList<>();

        final TreeNode root = buildTree(words);

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, i, j, root, result);

        return result;
    }

    private static TreeNode buildTree(final String[] words) {
        final TreeNode root = new TreeNode();

        for (String word : words) {
            TreeNode cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.letters[index] == null)
                    cur.letters[index] = new TreeNode();
                cur = cur.letters[index];
            }
            cur.word = word;
        }
        return root;
    }

    private static void dfs(final char[][] board, final int i, final int j, TreeNode root, final List<String> result) {
        final char c = board[i][j];
        if (c == '*' || root.letters[c - 'a'] == null)
            return;
        root = root.letters[c - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }

        board[i][j] = '*';
        if (i > 0) dfs(board, i - 1, j, root, result);
        if (j > 0) dfs(board, i, j - 1, root, result);
        if (i + 1 < board.length) dfs(board, i + 1, j, root, result);
        if (j + 1 < board[0].length) dfs(board, i, j + 1, root, result);
        board[i][j] = c; //backtrack the character
    }

    public static void main(String[] args) {
        final char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        final String[] input = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, input));
    }
}
