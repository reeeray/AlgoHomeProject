package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.08.2024
 **/
public class NaryPostorderTraversal_590 {

    public static void main(String[] args) {
    }

    public static List<Integer> postOrder(final Node root) {
        final List<Integer> answ = new ArrayList<>();
        postOrderDFS(root, answ);
        return answ;
    }

    private static void postOrderDFS(final Node node, final List<Integer> answ) {
        if(node == null) {
            return;
        }
        for(final Node n : node.children) {
            postOrderDFS(n, answ);
        }
        answ.add(node.val);
    }


    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
