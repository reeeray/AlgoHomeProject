package leetcode.bfs;

import leetcode.structures.TreeNode;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.12.2024
 **/
public class MinNumberOfOperationsToSortABinaryTreeByLevel_2471 {

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        final TreeNode level1_1 = new TreeNode(4);
        final TreeNode level1_2 = new TreeNode(3);
        final TreeNode level2_1 = new TreeNode(7);
        final TreeNode level2_2 = new TreeNode(6);
        final TreeNode level2_3 = new TreeNode(8);
        final TreeNode level2_4 = new TreeNode(5);
        final TreeNode level3_5 = new TreeNode(9);
        final TreeNode level3_7 = new TreeNode(10);
        root.left = level1_1;
        root.right = level1_2;
        level1_1.left = level2_1;
        level1_1.right = level2_2;
        level1_2.left = level2_3;
        level1_2.right = level2_4;
        level2_3.left = level3_5;
        level2_4.left = level3_7;
        minimumOperations(root);
    }

    //Space O(n) and Time O(nlogn)
    public static int minimumOperations(final TreeNode root) {
        final Queue<TreeNode> levels = new LinkedList<>();
        levels.offer(root);
        int swaps = 0;
        while(!levels.isEmpty()) {
            final int n = levels.size();
            final int[] level = new int[n];
            for(int i=0; i<n; i++) {
                final TreeNode curr = levels.poll();
                level[i] = curr.val;
                if(curr.left != null) {
                    levels.offer(curr.left);
                }
                if(curr.right != null) {
                    levels.offer(curr.right);
                }
            }
            swaps += checkCount(level);
        }
        return swaps;
    }

    private static int checkCount(final int[] arr) {
        int count = 0;
        final int[] target = arr.clone();
        Arrays.sort(target);

        // Map to track current positions of values
        final Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            pos.put(arr[i], i);
        }

        // For each position, swap until correct value is placed
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                count++;

                // Update position of swapped values
                final int curPos = pos.get(target[i]);
                pos.put(arr[i], curPos);
                arr[curPos] = arr[i];
            }
        }
        return count;
    }
}
