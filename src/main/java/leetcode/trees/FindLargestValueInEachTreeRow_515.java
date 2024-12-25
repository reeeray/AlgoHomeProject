package leetcode.trees;

import leetcode.structures.Pair;
import leetcode.structures.TreeNode;

import java.util.*;

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

    //O(n) and Space O(h) and h is max depth of the tree
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

    //Space O(n) and Time O(n)
    public static List<Integer> largestValuesAlternative(final TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        final Queue<TreeNode> levels = new LinkedList<>();
        levels.offer(root);
        while(!levels.isEmpty()) {
            final int size = levels.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++) {
                final TreeNode curr = levels.poll();
                max = Math.max(curr.val, max);
                if(curr.left != null) {
                    levels.offer(curr.left);
                }
                if(curr.right != null) {
                    levels.offer(curr.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }

    //DFS iterative(bfs like) Time O(n) and Space O(h)
    public List<Integer> largestValuesAlternative2(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        final List<Integer> ans = new ArrayList<>();
        final Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));

        while (!stack.isEmpty()) {
            final Pair<TreeNode, Integer> pair = stack.pop();
            final TreeNode node = pair.getLeft();
            int depth = pair.getRight();

            if (depth == ans.size()) {
                ans.add(node.val);
            } else {
                ans.set(depth, Math.max(ans.get(depth), node.val));
            }

            if (node.left != null) {
                stack.push(new Pair<>(node.left, depth + 1));
            }

            if (node.right != null) {
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }

        return ans;
    }
}
