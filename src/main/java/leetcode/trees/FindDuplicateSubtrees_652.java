package leetcode.trees;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.02.2023
 **/
public class FindDuplicateSubtrees_652 {

    public static void main(String[] args) {

    }

    public List<TreeNode> findDuplicateSubtrees(final TreeNode root) {
       final List<TreeNode> answer = new ArrayList<>();
       final Map<String, Integer> subtrees = new HashMap<>();
       dfs(root, answer, subtrees);

       return answer;
    }

    private static String dfs(final TreeNode node, final List<TreeNode> answer, final Map<String,  Integer> subtrees) {
        if(node == null) {
            return "";
        }
        final String left = dfs(node.left, answer, subtrees);
        final String right = dfs(node.right, answer, subtrees);
        final String curNodeId = node.val + " " + left + " " + right;
        subtrees.put(curNodeId, subtrees.getOrDefault(curNodeId, 0) + 1);
        if(subtrees.get(curNodeId) == 2) {
            answer.add(node);
        }

        return curNodeId;
    }




    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
