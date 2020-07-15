package coursera.data_structures.tries;

import edu.princeton.cs.algs4.Queue;

/**
 * R-way tries. For example for spell checking you can build 26-way trie.
 * Symbol table wich representing tree that each node stores all possible letters.
 * search hit      search miss     insert      space(references)
 * R-way tries       L               Log(R)N       L             (R+1)N
 * <p>
 * L- length of the key
 * User : Shein G.A.{@reeeray}
 * Date : 06.07.2020
 **/
public class Trie<T> {

    private static final int Radix = 256; //extended ASCII
    private Node<T> root = new Node();

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

    public Iterable<String> keys() {
        final Queue<String> queue = new Queue<>();
        collect(root, "", queue);
        return queue;
    }

    private void collect(final Node<T> node, final String prefix, final Queue<String> queue) {
        if (node == null) return;
        if (node.value != null) queue.enqueue(prefix);
        for (char c = 0; c < Radix; c++)
            collect(node.children[c], prefix + c, queue);
    }

    private Node<T> get(final Node<T> node, final String key, final int depth) {
        if (node == null) return null;
        if (depth == key.length()) return node;
        final char c = key.charAt(depth);
        return get(node.children[c], key, depth + 1);
    }

    private Node<T> put(Node node, final String key, final T value, final int depth) {
        if (node == null) node = new Node<T>();
        if (depth == key.length()) {
            node.value = value;
            return node;
        }
        final char c = key.charAt(depth);
        node.children[c] = put(node.children[c], key, value, depth + 1);
        return node;
    }

    private static class Node<T> {
        private T value;
        private Node[] children = new Node[Radix];
    }
}
