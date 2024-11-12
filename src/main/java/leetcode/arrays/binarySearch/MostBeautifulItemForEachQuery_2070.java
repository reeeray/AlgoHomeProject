package leetcode.arrays.binarySearch;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.11.2024
 **/
public class MostBeautifulItemForEachQuery_2070 {

    public static void main(String[] args) {
        final int[][] input = new int[][] {{1,2},{3,2},{2,4},{5,6},{3,5}};
        final int[] queries = new int[] {1, 2, 3, 4, 5, 6};
        maximumBeauty(input, queries);
    }

    public static int[] maximumBeauty(final int[][]items, final int[] queries) {
        final int[] ans = new int[queries.length];
        Arrays.sort(items, (a, b) -> {
            if(a[0] == b[0])
                return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });
        final Map<Integer, Integer> maxValue = new HashMap<>();
        int prev = Integer.MIN_VALUE;
        for(final int[] item : items) {
            prev = Math.max(item[1], prev);
            maxValue.put(item[0], prev);
        }
        final int[] keyArray = maxValue.keySet().stream().sorted().mapToInt(Integer::intValue).toArray();
        for(int i=0; i<queries.length; i++) {
            final int v = findClosest(keyArray, queries[i]);
            ans[i] = v > 0 ? maxValue.get(v) : 0;
        }
        return ans;
    }

    private static int findClosest(final int[] keys, final int value) {
        int left = 0, right = keys.length - 1;
        int key = -1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if(keys[mid] == value) {
                return keys[mid];
            } else if (keys[mid] > value) {
                right = mid - 1;
            } else {
                key = mid;
                left = mid + 1;
            }
        }
        return key == - 1 ? -1 : keys[key];
    }

    //Time O((m+n)logm) and Space O(logM) where m size of items
    public int[] maximumBeautyOpt(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];

        // Sort and store max beauty
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int max = items[0][1];
        for (int i = 0; i < items.length; i++) {
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }

        for (int i = 0; i < queries.length; i++) {
            // answer i-th query
            ans[i] = binarySearch(items, queries[i]);
        }

        return ans;
    }

    private int binarySearch(int[][] items, int targetPrice) {
        int l = 0;
        int r = items.length - 1;
        int maxBeauty = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (items[mid][0] > targetPrice) {
                r = mid - 1;
            } else {
                // Found viable price. Keep moving to right
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                l = mid + 1;
            }
        }
        return maxBeauty;
    }

}
