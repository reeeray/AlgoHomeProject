package leetcode.structures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.02.2023
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {

    private int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int val) {
        this.val = val;
    }

}
