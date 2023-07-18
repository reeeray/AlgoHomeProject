package leetcode.structures;

import java.util.HashMap;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.07.2023
 **/
class LRUCache_146 {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    final Node head = new Node(-1, -1);
    final Node tail = new Node(-1, -1);
    final int cap;
    final HashMap<Integer, Node> m = new HashMap<>();

    public LRUCache_146(final int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(final Node newnode) {
        final Node temp = head.next;

        newnode.next = temp;
        newnode.prev = head;

        head.next = newnode;
        temp.prev = newnode;
    }

    private void deleteNode(final Node delnode) {
        final Node prevv = delnode.prev;
        final Node nextt = delnode.next;

        prevv.next = nextt;
        nextt.prev = prevv;
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            final Node resNode = m.get(key);
            int ans = resNode.val;

            m.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            m.put(key, head.next);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node curr = m.get(key);
            m.remove(key);
            deleteNode(curr);
        }

        if (m.size() == cap) {
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key, value));
        m.put(key, head.next);
    }
}
