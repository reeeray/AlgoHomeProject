package leetcode.structures;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.04.2025
 **/
public class CountGoodTripletsInAnArray_2179 {

    public static void main(String[] args) {

    }

    private static long goodTriplets(final int[] nums1, final int[] nums2) {
        final int n = nums1.length;
        final int[] pos2 = new int[n], reversedIndexMapping = new int[n];
        for(int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }
        for(int i = 0; i < n; i++) {
            reversedIndexMapping[pos2[nums1[i]]] = i;
        }
        final CustomTree customTree = new CustomTree(n);
        long ans = 0;
        for(int i = 0; i < n; i++) {
            final int position = reversedIndexMapping[i];
            final int left = customTree.query(position);
            final int right = (n - 1 - position) - (i - left);
            customTree.update(position, 1);
            ans += 1l * left * right;
        }
        return ans;
    }

    private static class CustomTree {

        private final int[] tree;

        public CustomTree(final int size) {
            tree = new int[size + 1];
        }

        public void update(int index, final int delta) {
            index++;
            while (index < tree.length) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public int query(int index) {
            index++;
            int res = 0;
            while (index > 0) {
                res += tree[index];
                index -= index & -index;
            }
            return res;
        }
    }
}
