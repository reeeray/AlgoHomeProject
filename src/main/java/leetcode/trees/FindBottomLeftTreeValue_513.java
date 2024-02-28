package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.02.2024
 **/
public class FindBottomLeftTreeValue_513 {

    public static void main(String[] args) {

    }

    //BFS
    public static int findBottomLeftValue(final TreeNode root) {
        int left = root.getVal();
        final Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);
        while(!levels.isEmpty()) {
            int numberNodesOnThisLevel = levels.size();
            boolean isSet = false;
            for(int i=0; i<numberNodesOnThisLevel; i++) {
                final TreeNode node = levels.poll();
                if(!isSet) {
                    left = node.getVal();
                    isSet = true;
                }
                if(node.left != null)
                    levels.add(node.left);
                if(node.right != null) {
                    levels.add(node.right);
                }
            }
        }
        return left;
    }

    private int leftMost;
    private int leftMostLevel = -1;

    //Much more efficient in terms of space
    public int findBottomLeftValueDFS(final TreeNode root) {
        dfs(root, 0);
        return leftMost;
    }

    private void dfs(final TreeNode node, final int level) {
        if(node == null) return;
        if(level > leftMost) {
            leftMost = node.getVal();
            leftMostLevel = level;
        }
        dfs(node.getLeft(), level + 1);
        dfs(node.getRight(), level + 1);
    }
}
