package leetcode.structures;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.09.2024
 **/
public class Node {

    int val;
    Node prev;
    Node next;

    public Node(final int val, final Node prev, final Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

}
