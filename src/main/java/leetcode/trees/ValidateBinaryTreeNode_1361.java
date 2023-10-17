package leetcode.trees;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.10.2023
 **/
public class ValidateBinaryTreeNode_1361 {

    public static void main(String[] args) {

    }

    public boolean validateBinaryTreeNode(final int n, final int[] leftChild, final int[] rightChild) {
        int root = -1;
        final Set<Integer> nodes = new HashSet<>();
        for(int i = 0; i<leftChild.length; i++) {
            nodes.add(leftChild[i]);
            nodes.add(rightChild[i]);
        }
        for(int i=0; i<n; i++) {
            if(!nodes.contains(i)) {
                root = i;
                break;
            }
        }
        if(root == -1) {
            return false;
        }

        final Set<Integer> seen = new HashSet<>();
        final Stack<Integer> toVist = new Stack<>();
        seen.add(root);
        toVist.push(root);

        while(!toVist.isEmpty()) {
            final int node = toVist.pop();
            final int[] children = {leftChild[node], rightChild[node]};

            for(int child : children) {
                if(child != -1) {
                    if(seen.contains(child)) {
                        return false;
                    }
                    toVist.push(child);
                    seen.add(child);
                }
            }
        }
        return seen.size() == n;
    }
}
