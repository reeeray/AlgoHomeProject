package leetcode.trees;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.06.2023
 **/
public class MaxLevelSumOfBST_1161 {

    public static void main(String[] args) {

    }

    //O(n) and O(n)
    public int maxLevelSumDFS(final ValidateBST_98.TreeNode root) {
        final List<Integer> levelsSum = new ArrayList<>();
        dfs(root, levelsSum, 0);
        int element = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<levelsSum.size(); i++) {
            if(levelsSum.get(i) > max) {
                max = levelsSum.get(i);
                element = i + 1;
            }
        }
        return element;
    }

    private void dfs(final ValidateBST_98.TreeNode node, final List<Integer> levelsSum, final int level) {
        if(node == null) {
            return;
        }
        if(levelsSum.size() == level) {
            levelsSum.add(node.val);
        } else {
            levelsSum.set(level, levelsSum.get(level) + node.val);
        }
        dfs(node.right, levelsSum, level + 1);
        dfs(node.left, levelsSum, level + 1);
    }

    //O(n) and O(n)
    public int maxLevlSumBFS(final ValidateBST_98.TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int ans = 0, level = 0;

        final Queue<ValidateBST_98.TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            level++;
            int sumAtCurrentLevel = 0;
            // Iterate over all the nodes in the current level.
            for (int sz = q.size(); sz > 0; --sz) {
                final ValidateBST_98.TreeNode node = q.poll();
                sumAtCurrentLevel += node.val;

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            if (maxSum < sumAtCurrentLevel) {
                maxSum = sumAtCurrentLevel;
                ans = level;
            }
        }

        return ans;
    }



}
