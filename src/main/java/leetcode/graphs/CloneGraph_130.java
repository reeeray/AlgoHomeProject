package leetcode.graphs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.04.2023
 **/
public class CloneGraph_130 {

    public static void main(String[] args) {

    }

    public static Node cloneGraph(final Node node) {
        if(node == null) return null;
        final Node copy = new Node(node.val);
        final Node[] visited = new Node[101];
        Arrays.fill(visited, null);
        dfs(node, copy, visited);
        return copy;

    }

    private static void dfs(final Node node, final Node copy, final Node[] visited) {
        visited[node.val] = copy;

        for(final Node child : node.neighbors) {
            if(visited[child.val] == null) {
                final Node childCopy = new Node(child.val);
                copy.neighbors.add(childCopy);
                dfs(child, childCopy, visited);
            } else {
                copy.neighbors.add(visited[child.val]);
            }
        }
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
