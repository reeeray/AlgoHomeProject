package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.stream.Stream;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.07.2024
 **/
public class StepByStepDirectionFromABinaryTreeNodeToAnother_2096 {

    public static void main(String[] args) {

    }

    //Space O(n) and Time O(n)
    public static String getDirections(final TreeNode root, final int startValue, final int destValue) {
        final String[] paths = new String[2];
        dfs(root, startValue, destValue, paths, new StringBuilder());
        final StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < paths[0].length() && index < paths[1].length() && paths[0].charAt(index) == paths[1].charAt(index)) {
            index++;
        }
        for(int i=0; i<paths[0].length() - index; i++) {
            sb.append('U');
        }
        sb.append(paths[1].substring(index));
        return sb.toString();
    }

    private static void dfs(final TreeNode node, final int s, final int t, final String[] paths, final StringBuilder curr) {
        if(node == null) {
            return;
        }
        if(node.getVal() == s) {
            paths[0] = curr.toString();
            if(paths[1] != null) {
                return;
            }
        }
        if(node.getVal() == t) {
            paths[1] = curr.toString();
            if(paths[0] != null) {
                return;
            }
        }
        final int len = curr.length();
        dfs(node.getLeft(), s, t, paths, curr.append('L'));
        dfs(node.getRight(), s, t, paths, curr.delete(len, curr.length()).append('R'));
    }
}
