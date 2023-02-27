package leetcode.trees;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.02.2023
 **/
public class ConstructQuadTree_427 {

    public static void main(String[] args) {

    }

    private static Node construct(final int[][] grid) {

        return constructInternal(0, 0, grid.length, grid);
    }

    private static Node constructInternal(final int m, final int n, final int length, final int[][] grid) {
        boolean isLeaf = true;
        final int ref = grid[m][n];
        for(int row=m; row<m+length; row++) {
            for(int col=n; col<n+length; col++) {
                if(grid[row][col] != ref) {
                    isLeaf = false;
                    break;
                }
            }
        }
        Node node = null;
        if(isLeaf) {
            node = new Node(ref == 1 ? true : false, true);
        } else {
            node = new Node(true, false);
            node.topLeft = constructInternal(m, n, length/2, grid);
            node.topRight = constructInternal(m + length/2, n, length/2, grid);
            node.bottomLeft = constructInternal(m, n + length/2, length/2, grid);
            node.bottomRight = constructInternal(m + length/2, n + length/2, length/2, grid);
        }
        return node;
    }

    private static Node constructInternalWorking(final int m, final int n, final int length, final int[][] grid) {
        if (length == 1) {
            return new Node(grid[m][n] == 1, true);
        }

        int halfLength = length / 2;
        final Node topLeft = constructInternal(m, n, halfLength, grid);
        final Node topRight = constructInternal(m, n + halfLength, halfLength, grid);
        final Node bottomLeft = constructInternal(m + halfLength, n, halfLength, grid);
        final Node bottomRight = constructInternal(m + halfLength, n + halfLength, halfLength, grid);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                ((topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) ||
                        (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val))) {
            return new Node(topLeft.val, true);
        } else {
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
