package leetcode.structures;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.10.2023
 **/
public class HashMapImpl_706 {

    private static int HASH_TABLE_SIZE = 10_007;
    private Node[] hashTable;

    public HashMapImpl_706() {
        this.hashTable = new Node[HASH_TABLE_SIZE];
    }

    private int calcHash(final int val) {
        return val % HASH_TABLE_SIZE;
    }

    public void put (final int key, final int val) {
        final int index = calcHash(key);
        final Node node = new Node(key, val);
        Node temp = hashTable[index];
        while (temp != null) {
            if(temp.key == key) {
                temp.value = val;
                return;
            }
            temp = temp.next;
        }
        node.next = hashTable[index];
        hashTable[index] = node;
    }

    public int get(final int key) {
        final int index = calcHash(key);
        Node temp = hashTable[index];
        while (temp != null) {
            if(temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void remove(final int key) {
        final int index = calcHash(key);
        Node node = hashTable[index];
        if(node != null && node.key == key) {
            hashTable[index] = node.next;
            return;
        }
        while (node != null && node.next != null) {
            if(node.next.key == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }


    private static class Node {
        public int key, value;
        public Node next;

        public Node(final int key, final int value) {
            this.key = key;
            this.value = value;
        }
    }
}
