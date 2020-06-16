package coursera.data_structures.dictionary;

import coursera.data_structures.queue.QueueLinkedList;

/**
 * BST - binary search tree is a binary tree in symmetric order.
 * Symmetric order : each node has a key and every node's key is larger than all keys is left subtree
 * and smaller than all keys in right subtree
 * <p>
 * implementation           guarantee               average case             ordered ops?    operations on keys
 * <p>
 * search  insert  delete  search hit    insert    delete
 * <p>
 * sequential search     N        N        N        N/2            N       N/2     no               equals()
 * <p>
 * binary search
 * (ordered array)      lgN      N         N        lgN           N/2      N/2        yes           compareTo()
 * <p>
 * BST                  N       N          N      1.39lgN      1.39lgN     sqrt(N)    yes           compareTo()
 * <p>
 * 2-3 trees          log(N)   log(N)    log(N)   log(N)      log(N)     log(N)    yes           compareTo()
 * left-leaning red-black trees (LL RB BST's)
 * B-trees
 * The worst case for BST when keys goes in natural order(orderes somehow : ascending or descending)
 * The best case for BST when keys goes randomly. Expected height of the tree is 4.311lnN
 * (unordered list)
 * <p>
 * Problem : after a huge number of insertions and deletions the tree shifts to the right and becoming unbalanced.
 * It leads to the fact that the depth becomes sqrt(N) wich is much larger than lgN!!!The problem is in deletion.
 * User : Shein G.A.{@reeeray}
 * Date : 05.06.2020
 **/
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    //the cost is 1 + depth of the node
    public void put(final Key key, final Value value) {
        root = put(root, key, value);
    }

    private Node put(final Node node, final Key key, final Value value) {
        if (node == null) return new Node(key, value);
        final int cmp = node.key.compareTo(key);
        if (cmp > 0) node.left = put(node.left, key, value);
        if (cmp < 0) node.right = put(node.right, key, value);
        else node.value = value;
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Value get(final Key key) {
        Node current = root;
        while (current != null) {
            if (current.key.compareTo(key) > 0) current = current.left;
            else if (current.key.compareTo(key) < 0) current = current.right;
            else return current.value;
        }
        return null;
    }

    /**
     * How many keys < k?
     *
     * @param key input key
     * @return
     */
    public int rank(final Key key) {
        return rank(root, key);
    }

    public int rank(final Node node, final Key key) {
        if (node == null) return 0;
        final int cmp = node.key.compareTo(key);
        if (cmp > 0) return rank(node.left, key);
        else if (cmp < 0) return 1 + size(node.left) + rank(node.right, key);
        else return node.count;
    }

    public Key min() {
        final Node min = min(root);
        return min == null ? null : min.key;
    }

    private Node min(final Node node) {
        if (node == null) return null;
        final Node temp = min(node.left);
        return temp == null ? node : temp;
    }

    public Key max() {
        Node current = root;
        if (current == null) return null;
        while (current.right != null) {
            current = current.right;
        }
        return current.key;
    }

    /**
     * the largest Key which smaller than input Key
     *
     * @param key
     * @return
     */
    public Key floor(final Key key) {
        final Node floor = floor(root, key);
        if (floor == null)
            return null;
        return floor.key;
    }

    private Node floor(final Node node, final Key key) {
        if (node == null) return null;
        final int cmp = node.key.compareTo(key);

        if (cmp == 0) return node;

        if (cmp > 0) return floor(node.left, key);

        final Node temp = floor(node.right, key);
        if (temp != null) return temp;
        else return node;
    }

    /**
     * the smallest Key which larger than input Key
     *
     * @param key input Key
     * @return
     */
    public Key ceiling(final Key key) {
        final Node ceiling = ceiling(root, key);
        return ceiling == null ? null : ceiling.key;
    }

    private Node ceiling(final Node node, final Key key) {
        if (node == null) return null;

        final int cmp = node.key.compareTo(key);

        if (cmp == 0) return node;

        if (cmp < 0) return ceiling(node.right, key);

        final Node tmp = ceiling(node.left, key);
        return tmp == null ? node : tmp;
    }

    public int size() {
        return size(root);
    }

    private int size(final Node node) {
        return node == null ? 0 : node.count;
    }

    /**
     * Hibbard deletion find the Node than change it with min Node in right subtree and delete min Node at right subTree
     * The main defect of Hibbard deletion is that it unbalances the tree, leading to sqrt(n) height.
     * <p>
     * If instead of replacing the node to delete with its successor, you flip a coin and replace it with either its successor
     * or predecessor, then, in practice, the height becomes logarithmic (but nobody has been able to prove this fact mathematically).
     *
     * @param key
     */
    public void delete(final Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, final Key key) {
        if (node == null) return null;
        final int cmp = node.key.compareTo(key);
        if (cmp < 0) node.right = delete(node.right, key);
        else if (cmp > 0) node.left = delete(node.left, key);
        else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;

            final Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(node.right);
            node.left = temp.left;
        }
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(final Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    /**
     * Iterable data structure to iterates through all elements. In so called inorder traversal order.
     * It's also exists level-order-traversal where the root is visited first,
     * then all nodes at depth 1 (going from left to right), then all nodes at depth 2 (going from left to right), and so forth
     *
     * @return
     */
    public Iterable<Key> iterator() {
        final QueueLinkedList<Key> queue = new QueueLinkedList<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(final Node node, final QueueLinkedList queue) {
        if (node == null) return;
        inorder(node.left, queue);
        queue.enqueue(node.key);
        inorder(node.right, queue);
    }


    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int count; //number nodes in subtree

        public Node(final Key key, final Value value) {
            this.key = key;
            this.value = value;
        }
    }
}
