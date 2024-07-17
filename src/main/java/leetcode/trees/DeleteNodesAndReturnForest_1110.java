package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.07.2024
 **/
public class DeleteNodesAndReturnForest_1110 {

    public static void main(String[] args) {

    }

    public List<TreeNode> delNodes(final TreeNode root, final int[] to_delete) {
        final Map<Integer, TreeNode[]> tree = new HashMap<>();
        final Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode prev = null;
        nodes.add(root);
        while(!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            if(curr == null) {
                continue;
            }
            final TreeNode[] neighbours = new TreeNode[4];
            neighbours[0] = prev;
            neighbours[1] = curr.left;
            neighbours[2] = curr.right;
            neighbours[4] = curr;
            tree.put(curr.getVal(), neighbours);
            nodes.add(curr.left);
            nodes.add(curr.right);
            prev = curr;
        }
        final Set<Integer> roots = new HashSet<>();
        roots.add(root.getVal());
        final List<TreeNode> answer = new ArrayList<>();
        for(int del : to_delete) {
            final TreeNode[] neighbours = tree.get(del);
            roots.remove(del);
            final TreeNode previous = tree.get(del)[0];
            if(previous != null) {
                if(previous.left != null && previous.left.getVal() == del) {
                    previous.left = null;
                } else {
                    previous.right = null;
                }
            }
            if(neighbours[1] != null) {
                roots.add(neighbours[1].getVal());
            }
            if(neighbours[2] != null) {
                roots.add(neighbours[2].getVal());
            }
        }
        for(int r : roots) {
            answer.add(tree.get(r)[3]);
        }
        return answer;
    }

    //Very bad. Time O(n) and Space O(n)
    public List<TreeNode> delNodesDFS(final TreeNode root, final int[] to_delete) {
        final Set<Integer> del = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        final List<TreeNode> ans = new ArrayList<>();
        dfs(root, del, ans, null);
        return ans;
    }

    private static void dfs(final TreeNode node, final Set<Integer> del, final List<TreeNode> roots, final TreeNode prev) {
        if(node == null) {
            return;
        }

        if(del.remove(node.val)) {
            if(prev != null && prev.left == node) {
                prev.left = null;
            } else if (prev != null){
                prev.right = null;
            }
            dfs(node.left, del, roots, null);
            dfs(node.right, del, roots, null);
            return;
        }

        if(prev == null) {
            roots.add(node);
        }

        dfs(node.left, del, roots, node);
        dfs(node.right, del, roots, node);
    }

    //Time O(n) and Space O(n)
    public List<TreeNode> delNodesBFS(TreeNode root, int[] to_delete) {
        final List<TreeNode> forest = new ArrayList<>();
        if (root == null) {
            return forest;
        }
        final Set<Integer> del = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());



        final Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            final TreeNode currentNode = nodes.poll();

            if (currentNode.left != null) {
                nodes.add(currentNode.left);
                // Disconnect the left child if it needs to be deleted
                if (del.contains(currentNode.left.val)) {
                    currentNode.left = null;
                }
            }

            if (currentNode.right != null) {
                nodes.add(currentNode.right);
                // Disconnect the right child if it needs to be deleted
                if (del.contains(currentNode.right.val)) {
                    currentNode.right = null;
                }
            }

            // If the current node needs to be deleted, add its non-null children to the forest
            if (nodes.contains(currentNode.val)) {
                if (currentNode.left != null) {
                    forest.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    forest.add(currentNode.right);
                }
            }
        }

        // Ensure the root is added to the forest if it is not to be deleted
        if (!del.contains(root.val)) {
            forest.add(root);
        }

        return forest;
    }

}
