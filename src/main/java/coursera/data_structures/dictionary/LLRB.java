package coursera.data_structures.dictionary;

/**
 * Left-Leaning Red-Black BST (левопоставленные красно-черные деревья)  is an example of 2-3 Trees model : perfect balanced and symmetric order trees.
 * Each transformation maintains symmetric order and perfect balance. Tree height : lgN(all 2 nodes) worst case
 * best case : log3(N) = 0.631lgN(all 3 nodes).
 * We can guarantee performance for huge data.
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
 * 2-3 trees          cLog(N)   cLog(N)    cLog(N)   cLog(N)     cLog(N)    cLog(N)    yes           compareTo()
 * left-leaning
 * red-black trees     2*Lg(N)   2*Lg(N)    2*Lg(N)   1*Lg(N)     1*Lg(N)    1*Lg(N)    yes           compareTo()
 * (LL RB BST's)
 * B-trees                                           exact value of coefficient is unknown but extremely close to 1
 * <p>
 * c -const which depends on the implementation
 * <p>
 * The idea of Red-Black BST is that we are going to represent our 2-3 tree as a BST. For this we need just simple
 * representation for 3-nodes. We are going to use internal left leaning links to glue 3 nodes together. We are going to color in red link
 * which corresponds to a larger node. So in another words we will get BST with next options :
 * -No node has two red links connected to it;
 * -Every path from root to null link has the same number of black links (perfect balanced black tree);
 * -Red links lean left.
 * Transformation from BST to RB BST : red-black tree -> horizontal red links -> merge them into 2-3 tree
 * <p>
 * Remarkable : Height of the tree is guaranteed to be <= 2Lg(N) in the worst case
 * <p>
 * B-trees is a generalization of RB BST where you can use much more keys an each node.
 * How many probes does a search in a B-tree of order m with n keys require in the worst case?
 * Answer : Log m/2 N. This is the worst-case height, when every node has m/2 children.
 * User : Shein G.A.{@reeeray}
 * Date : 05.06.2020
 **/
public class LLRB<Key extends Comparable, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public Node root;

    /**
     * Observation : search is the same as for elementary BST (ignoring color)
     *
     * @param key search Key
     * @return Value
     */
    public Value get(final Key key) {
        Node current = root;

        while (current != null) {
            final int cmp = current.key.compareTo(key);
            if (cmp < 0) current = current.right;
            else if (cmp > 0) current = current.left;
            else return current.value;
        }
        return null;
    }

    /**
     * Same code handles all cases :
     * - First case :Left child BALCK, Right child RED : rotate left;
     * - Second case : Left child and left-left grandchild are RED : rotate right;
     * - Third case : Both children are RED : flip colors;
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node put(Node node, final Key key, final Value value) {
        if (node == null) return new Node(key, value, RED); //INSERT AT BOTTOM
        final int cmp = node.key.compareTo(key);
        if (cmp < 0) node.right = put(node.right, key, value);
        else if (cmp > 0) node.left = put(node.left, key, value);
        else node.value = value;

        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node); //lean left(case when right node is red).First case.
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node); // Second case.Balance 4-node.
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    /**
     * Orient a (temporarily) right-leaning red link to lean left.
     *
     * @param node
     * @return
     */
    private Node rotateLeft(final Node node) {
        assert isRed(node.right);
        final Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    /**
     * Paradoxically but sometimes we need to rotate right
     * Orient a left-leaning red link to (temporarily) lean right
     *
     * @param node
     * @return
     */
    private Node rotateRight(final Node node) {
        assert isRed(node.left);
        final Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    /**
     * Recolor to split a (temporary) 4-node
     *
     * @param node
     */
    private void flipColors(final Node node) {
        assert !isRed(node);
        assert isRed(node.left);
        assert isRed(node.right);
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private boolean isRed(final Node node) {
        return node != null && node.color == RED;
    }


    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color; //color of parent link

        public Node(final Key key, final Value value, final boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }


}
