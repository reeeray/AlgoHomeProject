package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.01.2024
 **/
public class LeafSimilarTrees_872 {

    public static void main(String[] args) {

    }

    public static boolean leafSimilar(final TreeNode root1, final TreeNode root2) {
        final List<Integer> leafs1 = new ArrayList<>();
        final List<Integer> leafs2 = new ArrayList<>();
        dfs(root1, leafs1);
        dfs(root2, leafs2);
        return leafs1.equals(leafs2);
    }

    private static void dfs(final TreeNode root, final List<Integer> leafs) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            leafs.add(root.getVal());
        }

        dfs(root.left, leafs);
        dfs(root.right, leafs);
    }

    public boolean leafSimilarBFS(TreeNode root1, TreeNode root2) {
        final Stack<TreeNode> s1 = new Stack<>();
        final Stack<TreeNode> s2 = new Stack<>();

        final Stack<Integer> l1 = new Stack<>();
        final Stack<Integer> l2 = new Stack<>();

        while((root1!=null || !s1.isEmpty()) ||
                (root2!=null || !s2.isEmpty())){
            while(root1 != null){
                s1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                s2.push(root2);
                root2 = root2.left;
            }
            root1 = s1.isEmpty() ? null : s1.pop();
            root2 = s2.isEmpty() ? null :  s2.pop();

            if(isLeaf(root1)) l1.push(root1.getVal());
            if(isLeaf(root2)) l2.push(root2.getVal());

            root1 = (root1 == null) ? null : root1.right;
            root2 = (root2 == null) ? null :  root2.right;
        }

        if(l1.size() != l2.size()) return false;
        while(!l1.isEmpty() && !l2.isEmpty() && l1.peek() == l2.peek()){
            l1.pop();
            l2.pop();
        }
        return l1.isEmpty();
    }

    public boolean isLeaf(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }
}
