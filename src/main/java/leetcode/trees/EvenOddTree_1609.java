package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.02.2024
 **/
public class EvenOddTree_1609 {

    public static void main(String[] args) {
        final TreeNode level4_1 = new TreeNode(12);
        final TreeNode level4_2 = new TreeNode(8);
        final TreeNode level4_3 = new TreeNode(6);
        final TreeNode level4_4 = new TreeNode(2);
        final TreeNode level3_1 = new TreeNode(3);
        level3_1.left = level4_1;
        level3_1.right = level4_2;
        final TreeNode level3_2 = new TreeNode(7);
        level3_2.left = level4_3;
        final TreeNode level3_3 = new TreeNode(9);
        level3_3.right = level4_4;
        final TreeNode level2_1 = new TreeNode(10);
        level2_1.left = level3_1;
        final TreeNode level2_2 = new TreeNode(4);
        level2_2.left = level3_2;
        level2_2.right = level3_3;
        final TreeNode root = new TreeNode(1);
        root.left = level2_1;
        root.right = level2_2;
        isEvenOddTree(root);
        assert true == isEvenOddTree(root);


    }

    //BFS Time O(n) and Space O(n)
    public static boolean isEvenOddTree(final TreeNode root) {
        boolean isOdd = true;
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            final int levelSize = queue.size();
            int previous = isOdd ? Integer.MIN_VALUE :Integer.MAX_VALUE;
            for(int i=0; i<levelSize; i++) {
                final TreeNode node = queue.poll();
                if(isOdd) {
                    if(node.getVal() % 2 == 0 || node.getVal() <= previous) {
                        return false;
                    }
                } else {
                    if(node.getVal() % 2 != 0 || node.getVal() >= previous) {
                        return false;
                    }
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                previous = node.getVal();
            }
            isOdd = !isOdd;
        }
        return true;
    }

    private List<Integer> prev = new ArrayList<>();

    //Overcomplicated but still the same complexity
    public boolean isEvenOddTreeDFS(final TreeNode root) {
        return dfs(root, 0);
    }

    private boolean dfs(final TreeNode current, final int level) {
        // Base case, an empty tree is Even-Odd
        if (current == null) {
            return true;
        }

        // Compare the parity of current and level
        if (current.getVal() % 2 == level % 2) {
            return false;
        }

        // Add a new level to prev if we've reached a new level
        while (prev.size() <= level) {
            prev.add(0);
        }

        // If there are previous nodes on this level, check increasing/decreasing
        // If on an even level, check that current's value is greater than the previous on this level
        // If on an odd level, check that current's value is less than the previous on this level
        if (prev.get(level) != 0 &&
                ((level % 2 == 0 && current.getVal() <= prev.get(level)) ||
                        (level % 2 == 1 && current.getVal() >= prev.get(level)))) {
            return false;
        }

        // Add current value to prev at index level
        prev.set(level, current.getVal());

        // Recursively call DFS on the left and right children
        return dfs(current.left, level + 1) && dfs(current.right, level + 1);
    }
}
