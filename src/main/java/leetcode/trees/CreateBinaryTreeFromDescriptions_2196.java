package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.07.2024
 **/
public class CreateBinaryTreeFromDescriptions_2196 {

    public static void main(String[] args) {

    }

    //Space O(n) and Time O(n)
    public TreeNode createBinaryTree(final int[][] descriptions) {
        final Set<Integer> children = new HashSet<>();
        final Map<Integer, TreeNode> nodes = new HashMap<>();
        for(final int[] descr : descriptions) {
            children.add(descr[1]);
            final TreeNode parent = nodes.getOrDefault(descr[0], new TreeNode(descr[0]));
            final TreeNode child = nodes.getOrDefault(descr[1], new TreeNode(descr[1]));
            if(descr[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            nodes.putIfAbsent(descr[0], parent);
            nodes.putIfAbsent(descr[1], child);
        }
        for(final int node : nodes.keySet()) {
            if(!children.contains(node)) {
                return nodes.get(node);
            }
        }
        return null;
    }
}
