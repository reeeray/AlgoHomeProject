package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.11.2023
 **/
public class FindModeInBST_501 {

    public static void main(String[] args) {

    }

    public static int[] findModel(final TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        final Map<Integer, Integer> hash = new HashMap<>();
        dfs(root, hash);
        final List<Integer> list = new ArrayList<>();
        int mode = -1;
        for(final int count : hash.values()) {
            mode = Math.max(count, mode);
        }
        for(final int count : hash.keySet()) {
            if (hash.get(count) == mode) {
                list.add(count);
            }
        }

        return list.stream().mapToInt(v -> v).toArray();
    }

    private static void dfs(final TreeNode curr, final Map<Integer, Integer> hash) {
        if(curr == null) {
            return;
        }
        hash.put(curr.getVal(), hash.getOrDefault(curr.getVal(), 0) + 1);
        dfs(curr.left, hash);
        dfs(curr.right, hash);
    }
}
