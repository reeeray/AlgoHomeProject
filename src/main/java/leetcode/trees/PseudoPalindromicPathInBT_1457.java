package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.01.2024
 **/
public class PseudoPalindromicPathInBT_1457 {

    private int count = 0;


    public int pseudoPalindromicPaths (TreeNode root) {
        final int[] path = new int[9];
        count = 0;
        dfs(root, path);
        return count;
    }

    private void dfs(final TreeNode node, final int[] path) {
        if(node == null) {
            return;
        }
        final int[] copy = Arrays.copyOf(path, 9);
        copy[node.getVal() - 1]++;
        if(node.left == null && node.right == null) {
            System.out.println(Arrays.toString(copy));
            int oddCount = 0;
            for(int val : copy) {
                if (val % 2 != 0) {
                    oddCount++;
                }
            }
            if(oddCount < 2) {
                count++;
            }
            return;
        }
        dfs(node.left, copy);
        dfs(node.right, copy);
    }

    public void preorder(TreeNode node, int path) {
        if (node != null) {
            // compute occurences of each digit
            // in the corresponding register
            path = path ^ (1 << node.getVal());
            // if it's a leaf check if the path is pseudo-palindromic
            if (node.left == null && node.right == null) {
                // check if at most one digit has an odd frequency
                if ((path & (path - 1)) == 0) {
                    ++count;
                }
            }
            preorder(node.left, path);
            preorder(node.right, path) ;
        }
    }

    //O(n) and O(H)
    public int pseudoPalindromicPathsBitManipulation(TreeNode root) {
        preorder(root, 0);
        return count;
    }

}
