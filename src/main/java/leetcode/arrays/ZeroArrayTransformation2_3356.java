package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.03.2025
 **/
public class ZeroArrayTransformation2_3356 {

    public static void main(String[] args) {
        minZeroArray(new int[] {0}, new int[][] {{0,0,2},{0,0,4},{0,0,4},{0,0,3},{0,0,5}});
    }

    //Time O(n + m) and Space O(n)
    public int minZeroArrayLineSweep(int[] nums, int[][] queries) {
        int n = nums.length, sum = 0, k = 0;
        int[] differenceArray = new int[n + 1];

        // Iterate through nums
        for (int index = 0; index < n; index++) {
            // Iterate through queries while current index of nums cannot equal zero
            while (sum + differenceArray[index] < nums[index]) {
                k++;

                // Zero array isn't formed after all queries are processed
                if (k > queries.length) {
                    return -1;
                }
                int left = queries[k - 1][0], right = queries[k - 1][1], val =
                        queries[k - 1][2];

                // Process start and end of range
                if (right >= index) {
                    differenceArray[Math.max(left, index)] += val;
                    differenceArray[right + 1] -= val;
                }
            }
            // Update prefix sum at current index
            sum += differenceArray[index];
        }
        return k;
    }

    //Time O(logM(N+M)) and Space O(n) where n size of nums and m size of queries
    public int minZeroArrayBinarySearch(int[] nums, int[][] queries) {
        int n = nums.length, left = 0, right = queries.length;

        // Zero array isn't formed after all queries are processed
        if (!currentIndexZero(nums, queries, right)) return -1;

        // Binary Search
        while (left <= right) {
            int middle = (left + right) / 2;
            if (currentIndexZero(nums, queries, middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // Return earliest query that zero array can be formed
        return left;
    }

    private boolean currentIndexZero(int[] nums, int[][] queries, int k) {
        int n = nums.length, sum = 0;
        int[] differenceArray = new int[n + 1];

        // Process query
        for (int queryIndex = 0; queryIndex < k; queryIndex++) {
            int left = queries[queryIndex][0], right =
                    queries[queryIndex][1], val = queries[queryIndex][2];

            // Process start and end of range
            differenceArray[left] += val;
            differenceArray[right + 1] -= val;
        }

        // Check if zero array can be formed
        for (int numIndex = 0; numIndex < n; numIndex++) {
            sum += differenceArray[numIndex];
            if (sum < nums[numIndex]) return false;
        }
        return true;
    }

    //TLE
    public static int minZeroArray(final int[] nums, final int[][] queries) {
        int counter = 0;
        int numbOfZeros = 0;
        for(int i=0; i< nums.length; i++) {
            if(nums[i] == 0) {
                numbOfZeros++;
            }
        }
        if(numbOfZeros == nums.length) {
            return counter;
        }
        for(final int[] query : queries) {
            counter++;
            for(int j = query[0]; j <= query[1]; j++) {
                if(nums[j] == 0) {
                    continue;
                }
                nums[j] -= Math.min(query[2], nums[j]);
                if(nums[j] == 0) {
                    numbOfZeros++;
                }
                if(numbOfZeros == nums.length) {
                    return counter;
                }
            }
        }
        return -1;
    }
}
