package coursera.data_structures.tries;

import edu.princeton.cs.algs4.Queue;

/**
 * Ternary Search Tries
 * It is a Tries at nodes of which we store onlt character and 3 children
 * search hit      search miss     insert      space(references)
 * TNT            L + lnN           lnN         L + lnN            4N
 * User : Shein G.A.{@reeeray}
 * Date : 07.07.2020
 **/
public class TNT<T> {

    private Node<T> root;

    public void put(final String key, final T value) {
        root = put(root, key, value, 0);
    }

    public boolean contains(final String key) {
        return get(key) != null;
    }

    public T get(final String key) {
        final Node<T> node = get(root, key, 0);
        return node == null ? null : node.value;
    }

    public Iterable<String> keysWithPrefix(final String prefix) {
        final Queue<String> queue = new Queue<>();
        final Node rootForPrefix = get(root, prefix, 0);
        //collect(rootForPrefix, prefix, queue);
        return queue;
    }

    public String longestPrefixOf(final String query) {
        int length = search(root, query, 0, 0);
        return query.substring(0, length);
    }

    private int search(final Node node, final String query, final int depth, int length) {
        if (node == null) return length;
        if (node.value != null) length = depth;
        if (depth == query.length()) return length;
        final char c = query.charAt(depth);
        return search(node.mid, query, depth + 1, length);//node.children[c]
    }

    private Node<T> get(final Node<T> node, final String key, final int depth) {
        if (node == null) return null;
        final char c = key.charAt(depth);
        if (c < node.c) return get(node.left, key, depth);
        if (c > node.c) return get(node.right, key, depth);
        else if (depth < key.length() - 1) return get(node.mid, key, depth + 1);
        else return node;
    }

    private Node<T> put(Node<T> node, final String key, final T value, final int depth) {
        final char c = key.charAt(depth);
        if (node == null) {
            node = new Node<T>();
            node.c = c;
        }
        if (c < node.c) node.left = put(node.left, key, value, depth);
        else if (c > node.c) node.right = put(node.right, key, value, depth);
        else if (depth < key.length() - 1) node.mid = put(node.mid, key, value, depth + 1);
        else node.value = value;
        return node;
    }

    private static class Node<T> {
        private char c;
        private T value;
        private Node left, mid, right;
    }
}
