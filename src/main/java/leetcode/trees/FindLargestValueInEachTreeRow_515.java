package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.10.2023
 **/
public class FindLargestValueInEachTreeRow_515 {

    public static void main(String[] args) {

    }

    public static List<Integer> largestValues(final TreeNode root) {
        final List<Integer> maxElementInLevel = new ArrayList<>();
        dfs(root, 0, maxElementInLevel);
        return maxElementInLevel;
    }

    private static void dfs(final TreeNode node, final int level, final List<Integer> container) {
        if(node == null) {
            return;
        }

        final int val = node.getVal();
        if(container.size() <= level) {
            container.add(val);
        } else {
            container.set(level, Math.max(container.get(level), val));
        }
        dfs(node.left, level + 1, container);
        dfs(node.right, level + 1, container);
    }
}
