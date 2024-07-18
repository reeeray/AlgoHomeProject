package leetcode.structures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.02.2023
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int val) {
        this.val = val;
    }

}
